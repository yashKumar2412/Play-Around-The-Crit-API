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
    }

    public ActiveSet(PokemonSet set, ActiveSet opponent, Weather weather, Map<Type, Map<Type, Integer>> typeMatchup) {
        this(set);
        calculateAllDamages(opponent, weather, typeMatchup);
    }

    public PokemonSet getSet() {
        return set;
    }

    public void setSet(PokemonSet set) {
        this.set = set;
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

    private void calculateStats() {
        this.effectiveStats = set.getDisplayedStats();
        // todo: add stat modifier effect
    }

    private void calculateAllDamages(ActiveSet opponent, Weather weather, Map<Type, Map<Type, Integer>> typeMatchup) {
        for (Move move: set.getMoves()) {
            List<Integer> damageList = new ArrayList<>();
            List<Integer> critDamageList = new ArrayList<>();
            if (move.isDoesDamage()) {
                int baseDamage = (2 * set.getLevel()) / 5 + 2;
                int atk = 1, def = 1;

                if (move.getCategory().equals(MoveCategory.PHYSICAL)) {
                    atk = effectiveStats.getAttack();
                    def = opponent.effectiveStats.getDefense();
                } else if (move.getCategory().equals(MoveCategory.SPECIAL)) {
                    atk = effectiveStats.getSpecialAttack();
                    def = opponent.effectiveStats.getSpecialDefense();
                }

                baseDamage = baseDamage * atk / def;
                baseDamage = baseDamage / 50 + 2;


                if (weather.equals(Weather.Rain)) {
                    if (move.getType().equals(Type.WATER))
                        baseDamage = baseDamage + (baseDamage / 2);
                    else if (move.getType().equals(Type.FIRE))
                        baseDamage = baseDamage - (baseDamage / 2);
                } else if (weather.equals(Weather.Sun)) {
                    if (move.getType().equals(Type.FIRE))
                        baseDamage = baseDamage + (baseDamage / 2);
                    else if (move.getType().equals(Type.WATER))
                        baseDamage = baseDamage - (baseDamage / 2);
                }

                if (move.getType().equals(set.getPokemon().getPrimaryType()) || move.getType().equals(set.getPokemon().getSecondaryType()))
                    baseDamage = baseDamage + (baseDamage / 2);

                Map<Type, Integer> moveTypeMatchup = typeMatchup.get(move.getType());
                Integer multiplier = moveTypeMatchup.get(opponent.getSet().getPokemon().getPrimaryType());
                if (multiplier == -1)
                    baseDamage = baseDamage / 2;
                else if (multiplier == 2)
                    baseDamage = baseDamage * 2;
                else if (multiplier == 0) {
                    baseDamage = 0;
                }

                if (!opponent.getSet().getPokemon().getSecondaryType().equals(Type.NONE)) {
                    multiplier = moveTypeMatchup.get(opponent.getSet().getPokemon().getSecondaryType());
                    if (multiplier == -1)
                        baseDamage = baseDamage / 2;
                    else if (multiplier == 2)
                        baseDamage = baseDamage * 2;
                    else if (multiplier == 0) {
                        baseDamage = 0;
                    }
                }

                if (status.equals(Status.Burned) && move.getCategory().equals(MoveCategory.PHYSICAL))
                    baseDamage = baseDamage / 2;

                if (baseDamage != 0) {
                    for (int random = 85; random <= 100; random++) {
                        int randomBaseDamage = random * baseDamage;
                        damageList.add(randomBaseDamage);
                        critDamageList.add(randomBaseDamage + (randomBaseDamage / 2));
                    }
                } else {
                    damageList.add(0);
                    critDamageList.add(0);
                }
            } else {
                damageList.add(0);
                critDamageList.add(0);
            }

            this.damage.put(move, damageList);
            this.critDamage.put(move, critDamageList);
        }
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