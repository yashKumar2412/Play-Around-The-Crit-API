package com.patc.model;

import com.patc.enums.*;

import java.util.*;

public class ActiveSet {
    private PokemonSet set;
    private Stats statModifiers;
    private Stats effectiveStats;
    private int health;
    private Status status;
    private Map<Move, List<Integer>> damage;
    private Map<Move, List<Integer>> critDamage;

    public ActiveSet(PokemonSet set) {
        this.set = set;
        this.statModifiers = new Stats(StatType.MODIFIERS, 0, 0, 0, 0, 0, 0);
        calculateStats();
        this.health = effectiveStats.getHp();
        this.status = Status.Healthy;
        this.damage = new HashMap<>();
        this.critDamage = new HashMap<>();
    }

    public ActiveSet(PokemonSet set, ActiveSet opponent, Weather weather, Map<Type, Map<Type, Double>> typeChart) {
        this(set);
        calculateAllDamages(opponent, weather, typeChart);
    }

    public PokemonSet getSet() {
        return set;
    }

    public void setSet(PokemonSet set) {
        this.set = set;
    }

    public Stats getStatModifiers() {
        return statModifiers;
    }

    public void setStatModifiers(Stats statModifiers) {
        this.statModifiers = statModifiers;
    }

    public Stats getEffectiveStats() {
        return effectiveStats;
    }

    public void setEffectiveStats(Stats effectiveStats) {
        this.effectiveStats = effectiveStats;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Map<Move, List<Integer>> getDamage() {
        return damage;
    }

    public void setDamage(Map<Move, List<Integer>> damage) {
        this.damage = damage;
    }

    public Map<Move, List<Integer>> getCritDamage() {
        return critDamage;
    }

    public void setCritDamage(Map<Move, List<Integer>> critDamage) {
        this.critDamage = critDamage;
    }

    public void calculateStats() {
        this.effectiveStats = set.getDisplayedStats();
        // todo: add stat modifier effect
    }

    public void calculateAllDamages(ActiveSet opponent, Weather weather, Map<Type, Map<Type, Double>> typeChart) {
        for (Move move: set.getMoves()) {
            List<Integer> damageList = new ArrayList<>();
            List<Integer> critDamageList = new ArrayList<>();

            if (move.isDoesDamage()) {
                int baseDamage = (2 * set.getLevel()) / 5 + 2;
                baseDamage = baseDamage * move.getBasePower();

                if (set.getHeldItem() != null && set.getHeldItem().isHasInGameEffect()) {
                    baseDamage = calculateItemBoost(move, baseDamage);
                }

                if (set.getAbility().isHasInGameEffect()) {
                    baseDamage = calculateAbilityBoost(move, baseDamage);
                }

                int atk = 1, def = 1;

                if (move.getCategory().equals(MoveCategory.PHYSICAL)) {
                    atk = effectiveStats.getAttack();
                    def = opponent.effectiveStats.getDefense();
                } else if (move.getCategory().equals(MoveCategory.SPECIAL)) {
                    atk = effectiveStats.getSpecialAttack();
                    def = opponent.effectiveStats.getSpecialDefense();
                }

                baseDamage = (baseDamage * atk) / def;
                baseDamage = baseDamage / 50 + 2;
                int critBaseDamage = (baseDamage * 3) / 2;

                if (weather.equals(Weather.Rain)) {
                    if (move.getType().equals(Type.WATER))
                        baseDamage = (baseDamage * 3) / 2;
                    else if (move.getType().equals(Type.FIRE))
                        baseDamage = baseDamage / 2;
                } else if (weather.equals(Weather.Sun)) {
                    if (move.getType().equals(Type.FIRE))
                        baseDamage = (baseDamage * 3) / 2;
                    else if (move.getType().equals(Type.WATER))
                        baseDamage = baseDamage / 2;
                }

                for (int random = 85; random <= 100; random++) {
                    int randomBaseDamage = (random * baseDamage) / 100;
                    int randomCritBaseDamage = (random * critBaseDamage) / 100;
                    damageList.add(randomBaseDamage);
                    critDamageList.add(randomCritBaseDamage);
                }

                if (move.getType().equals(set.getPokemon().getPrimaryType()) || move.getType().equals(set.getPokemon().getSecondaryType())) {
                    for (int i = 0; i < 16; i++) {
                        damageList.set(i, (damageList.get(i) * 3) / 2);
                        critDamageList.set(i, (critDamageList.get(i) * 3) / 2);
                    }
                }

                Map<Type, Double> moveTypeMatchups = typeChart.get(move.getType());
                Double multiplier = moveTypeMatchups.get(opponent.getSet().getPokemon().getPrimaryType());
                calculateTypeMultiplierDamages(multiplier, damageList, critDamageList);

                if (damageList.get(0) != 0 && !opponent.getSet().getPokemon().getSecondaryType().equals(Type.NONE)) {
                    multiplier = moveTypeMatchups.get(opponent.getSet().getPokemon().getSecondaryType());
                    calculateTypeMultiplierDamages(multiplier, damageList, critDamageList);
                }

                if (damageList.get(0) != 0 && status.equals(Status.Burned) && move.getCategory().equals(MoveCategory.PHYSICAL))
                    baseDamage = baseDamage / 2;

            } else {
                for (int i = 0; i < 16; i++) {
                    damageList.add(0);
                    critDamageList.add(0);
                }
            }

            this.damage.put(move, damageList);
            this.critDamage.put(move, critDamageList);
        }
    }

    private void calculateTypeMultiplierDamages(Double multiplier, List<Integer> damageList, List<Integer> critDamageList) {
        for (int i = 0; i < 16; i++) {
            if (multiplier == 0.5) {
                damageList.set(i, damageList.get(i) / 2);
                critDamageList.set(i, critDamageList.get(i) / 2);
            } else if (multiplier == 2.0) {
                damageList.set(i, damageList.get(i) * 2);
                critDamageList.set(i, critDamageList.get(i) * 2);
            } else if (multiplier == 0.0) {
                damageList.set(i, 0);
                critDamageList.set(i, 0);
            }
        }
    }

    private int calculateItemBoost(Move move, int baseDamage) {
        if (move.getType().equals(Type.GRASS) && set.getHeldItem().getName().equals("Miracle Seed")) {
            baseDamage = (baseDamage * 6) / 5;
        }

        if (move.getType().equals(Type.FIRE) && set.getHeldItem().getName().equals("Charcoal")) {
            baseDamage = (baseDamage * 6) / 5;
        }

        if (move.getType().equals(Type.WATER) && set.getHeldItem().getName().equals("Mystic Water")) {
            baseDamage = (baseDamage * 6) / 5;
        }

        return baseDamage;
    }

    private int calculateAbilityBoost(Move move, int baseDamage) {
        if (health < set.getDisplayedStats().getHp() / 3) {
            if (move.getType().equals(Type.GRASS) && set.getAbility().getName().equals("Overgrow")) {
                baseDamage = (baseDamage * 3) / 2;
            }

            if (move.getType().equals(Type.FIRE) && set.getAbility().getName().equals("Blaze")) {
                baseDamage = (baseDamage * 3) / 2;
            }

            if (move.getType().equals(Type.WATER) && set.getAbility().getName().equals("Torrent")) {
                baseDamage = (baseDamage * 3) / 2;
            }
        }

        return baseDamage;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ActiveSet activeSet = (ActiveSet) o;
        return health == activeSet.health && Objects.equals(set, activeSet.set) && Objects.equals(effectiveStats, activeSet.effectiveStats) && status == activeSet.status && Objects.equals(damage, activeSet.damage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set, effectiveStats, health, status, damage);
    }

    @Override
    public String toString() {
        return "ActiveSet{" +
                "set=" + set +
                ", effectiveStats=" + effectiveStats +
                ", health=" + health +
                ", status=" + status +
                ", damage=" + damage +
                '}';
    }
}