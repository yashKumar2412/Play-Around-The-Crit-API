package com.patc.model;

import com.patc.enums.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PlatformData {
    private PokemonCatalogue pokemonCatalogue;
    private AbilityCatalogue abilityCatalogue;
    private ItemCatalogue itemCatalogue;
    private MoveCatalogue moveCatalogue;
    private PokemonSetCatalogue pokemonSetCatalogue;
    Map<Type, Map<Type, Double>> typeChart;

    public PlatformData() {
        this.pokemonCatalogue = new PokemonCatalogue();
        this.abilityCatalogue = new AbilityCatalogue();
        this.itemCatalogue = new ItemCatalogue();
        this.moveCatalogue = new MoveCatalogue();
        this.pokemonSetCatalogue = new PokemonSetCatalogue(pokemonCatalogue.getPokemonMap(), abilityCatalogue.getAbilityMap(),
                                                            itemCatalogue.getItemMap(), moveCatalogue.getMoveMap());
        this.typeChart = new HashMap<>();
        initializeTypeChart();
    }

    private void initializeTypeChart() {
        for (Type attackerType: Type.values()) {
            if (attackerType.equals(Type.NONE))
                continue;

            typeChart.put(attackerType, new HashMap<>());
            for (Type defenderType: Type.values()) {
                if (defenderType.equals(Type.NONE))
                    continue;

                typeChart.get(attackerType).put(defenderType, 1.0);
            }
        }

        // Super-effective (2x)
        typeChart.get(Type.FIRE).put(Type.GRASS, 2.0);
        typeChart.get(Type.FIRE).put(Type.ICE, 2.0);
        typeChart.get(Type.FIRE).put(Type.BUG, 2.0);
        typeChart.get(Type.FIRE).put(Type.STEEL, 2.0);

        typeChart.get(Type.WATER).put(Type.FIRE, 2.0);
        typeChart.get(Type.WATER).put(Type.GROUND, 2.0);
        typeChart.get(Type.WATER).put(Type.ROCK, 2.0);

        typeChart.get(Type.GRASS).put(Type.WATER, 2.0);
        typeChart.get(Type.GRASS).put(Type.GROUND, 2.0);
        typeChart.get(Type.GRASS).put(Type.ROCK, 2.0);

        typeChart.get(Type.ELECTRIC).put(Type.WATER, 2.0);
        typeChart.get(Type.ELECTRIC).put(Type.FLYING, 2.0);

        typeChart.get(Type.BUG).put(Type.GRASS, 2.0);
        typeChart.get(Type.BUG).put(Type.PSYCHIC, 2.0);
        typeChart.get(Type.BUG).put(Type.DARK, 2.0);

        typeChart.get(Type.FLYING).put(Type.GRASS, 2.0);
        typeChart.get(Type.FLYING).put(Type.FIGHTING, 2.0);
        typeChart.get(Type.FLYING).put(Type.BUG, 2.0);

        typeChart.get(Type.FIGHTING).put(Type.NORMAL, 2.0);
        typeChart.get(Type.FIGHTING).put(Type.ICE, 2.0);
        typeChart.get(Type.FIGHTING).put(Type.ROCK, 2.0);
        typeChart.get(Type.FIGHTING).put(Type.DARK, 2.0);
        typeChart.get(Type.FIGHTING).put(Type.STEEL, 2.0);

        typeChart.get(Type.GHOST).put(Type.PSYCHIC, 2.0);
        typeChart.get(Type.GHOST).put(Type.GHOST, 2.0);

        typeChart.get(Type.DARK).put(Type.PSYCHIC, 2.0);
        typeChart.get(Type.DARK).put(Type.GHOST, 2.0);

        typeChart.get(Type.PSYCHIC).put(Type.FIGHTING, 2.0);
        typeChart.get(Type.PSYCHIC).put(Type.POISON, 2.0);

        typeChart.get(Type.POISON).put(Type.GRASS, 2.0);
        typeChart.get(Type.POISON).put(Type.FAIRY, 2.0);

        typeChart.get(Type.GROUND).put(Type.FIRE, 2.0);
        typeChart.get(Type.GROUND).put(Type.ELECTRIC, 2.0);
        typeChart.get(Type.GROUND).put(Type.POISON, 2.0);
        typeChart.get(Type.GROUND).put(Type.ROCK, 2.0);
        typeChart.get(Type.GROUND).put(Type.STEEL, 2.0);

        typeChart.get(Type.ROCK).put(Type.FIRE, 2.0);
        typeChart.get(Type.ROCK).put(Type.ICE, 2.0);
        typeChart.get(Type.ROCK).put(Type.FLYING, 2.0);
        typeChart.get(Type.ROCK).put(Type.BUG, 2.0);

        typeChart.get(Type.STEEL).put(Type.ICE, 2.0);
        typeChart.get(Type.STEEL).put(Type.ROCK, 2.0);
        typeChart.get(Type.STEEL).put(Type.FAIRY, 2.0);

        typeChart.get(Type.DRAGON).put(Type.DRAGON, 2.0);

        typeChart.get(Type.FAIRY).put(Type.FIGHTING, 2.0);
        typeChart.get(Type.FAIRY).put(Type.GHOST, 2.0);
        typeChart.get(Type.FAIRY).put(Type.DRAGON, 2.0);

        typeChart.get(Type.ICE).put(Type.GRASS, 2.0);
        typeChart.get(Type.ICE).put(Type.GROUND, 2.0);
        typeChart.get(Type.ICE).put(Type.FLYING, 2.0);
        typeChart.get(Type.ICE).put(Type.DRAGON, 2.0);

        // Not very effective (0.5x)
        typeChart.get(Type.NORMAL).put(Type.ROCK, 0.5);
        typeChart.get(Type.NORMAL).put(Type.STEEL, 0.5);

        typeChart.get(Type.FIRE).put(Type.FIRE, 0.5);
        typeChart.get(Type.FIRE).put(Type.WATER, 0.5);
        typeChart.get(Type.FIRE).put(Type.ROCK, 0.5);
        typeChart.get(Type.FIRE).put(Type.DRAGON, 0.5);

        typeChart.get(Type.WATER).put(Type.WATER, 0.5);
        typeChart.get(Type.WATER).put(Type.GRASS, 0.5);
        typeChart.get(Type.WATER).put(Type.DRAGON, 0.5);

        typeChart.get(Type.GRASS).put(Type.FIRE, 0.5);
        typeChart.get(Type.GRASS).put(Type.GRASS, 0.5);
        typeChart.get(Type.GRASS).put(Type.POISON, 0.5);
        typeChart.get(Type.GRASS).put(Type.FLYING, 0.5);
        typeChart.get(Type.GRASS).put(Type.BUG, 0.5);
        typeChart.get(Type.GRASS).put(Type.DRAGON, 0.5);
        typeChart.get(Type.GRASS).put(Type.STEEL, 0.5);

        typeChart.get(Type.ELECTRIC).put(Type.ELECTRIC, 0.5);
        typeChart.get(Type.ELECTRIC).put(Type.GRASS, 0.5);
        typeChart.get(Type.ELECTRIC).put(Type.DRAGON, 0.5);

        typeChart.get(Type.BUG).put(Type.FIRE, 0.5);
        typeChart.get(Type.BUG).put(Type.FIGHTING, 0.5);
        typeChart.get(Type.BUG).put(Type.POISON, 0.5);
        typeChart.get(Type.BUG).put(Type.FLYING, 0.5);
        typeChart.get(Type.BUG).put(Type.GHOST, 0.5);
        typeChart.get(Type.BUG).put(Type.STEEL, 0.5);
        typeChart.get(Type.BUG).put(Type.FAIRY, 0.5);

        typeChart.get(Type.FLYING).put(Type.ELECTRIC, 0.5);
        typeChart.get(Type.FLYING).put(Type.ROCK, 0.5);
        typeChart.get(Type.FLYING).put(Type.STEEL, 0.5);

        typeChart.get(Type.FIGHTING).put(Type.POISON, 0.5);
        typeChart.get(Type.FIGHTING).put(Type.FLYING, 0.5);
        typeChart.get(Type.FIGHTING).put(Type.PSYCHIC, 0.5);
        typeChart.get(Type.FIGHTING).put(Type.BUG, 0.5);
        typeChart.get(Type.FIGHTING).put(Type.FAIRY, 0.5);

        typeChart.get(Type.GHOST).put(Type.DARK, 0.5);

        typeChart.get(Type.DARK).put(Type.FIGHTING, 0.5);
        typeChart.get(Type.DARK).put(Type.DARK, 0.5);
        typeChart.get(Type.DARK).put(Type.FAIRY, 0.5);

        typeChart.get(Type.PSYCHIC).put(Type.PSYCHIC, 0.5);
        typeChart.get(Type.PSYCHIC).put(Type.STEEL, 0.5);

        typeChart.get(Type.POISON).put(Type.POISON, 0.5);
        typeChart.get(Type.POISON).put(Type.GROUND, 0.5);
        typeChart.get(Type.POISON).put(Type.ROCK, 0.5);
        typeChart.get(Type.POISON).put(Type.GHOST, 0.5);

        typeChart.get(Type.GROUND).put(Type.GRASS, 0.5);
        typeChart.get(Type.GROUND).put(Type.BUG, 0.5);

        typeChart.get(Type.ROCK).put(Type.FIGHTING, 0.5);
        typeChart.get(Type.ROCK).put(Type.GROUND, 0.5);
        typeChart.get(Type.ROCK).put(Type.STEEL, 0.5);

        typeChart.get(Type.STEEL).put(Type.FIRE, 0.5);
        typeChart.get(Type.STEEL).put(Type.WATER, 0.5);
        typeChart.get(Type.STEEL).put(Type.ELECTRIC, 0.5);
        typeChart.get(Type.STEEL).put(Type.STEEL, 0.5);

        typeChart.get(Type.DRAGON).put(Type.STEEL, 0.5);

        typeChart.get(Type.FAIRY).put(Type.FIRE, 0.5);
        typeChart.get(Type.FAIRY).put(Type.POISON, 0.5);
        typeChart.get(Type.FAIRY).put(Type.STEEL, 0.5);

        typeChart.get(Type.ICE).put(Type.FIRE, 0.5);
        typeChart.get(Type.ICE).put(Type.WATER, 0.5);
        typeChart.get(Type.ICE).put(Type.ICE, 0.5);
        typeChart.get(Type.ICE).put(Type.STEEL, 0.5);

        // Immunities (0x)
        typeChart.get(Type.NORMAL).put(Type.GHOST, 0.0);
        typeChart.get(Type.ELECTRIC).put(Type.GROUND, 0.0);
        typeChart.get(Type.FIGHTING).put(Type.GHOST, 0.0);
        typeChart.get(Type.GHOST).put(Type.NORMAL, 0.0);
        typeChart.get(Type.PSYCHIC).put(Type.DARK, 0.0);
        typeChart.get(Type.POISON).put(Type.STEEL, 0.0);
        typeChart.get(Type.GROUND).put(Type.FLYING, 0.0);
        typeChart.get(Type.DRAGON).put(Type.FAIRY, 0.0);
    }

    public PokemonCatalogue getPokemonCatalogue() {
        return pokemonCatalogue;
    }

    public void setPokemonCatalogue(PokemonCatalogue pokemonCatalogue) {
        this.pokemonCatalogue = pokemonCatalogue;
    }

    public AbilityCatalogue getAbilityCatalogue() {
        return abilityCatalogue;
    }

    public void setAbilityCatalogue(AbilityCatalogue abilityCatalogue) {
        this.abilityCatalogue = abilityCatalogue;
    }

    public ItemCatalogue getItemCatalogue() {
        return itemCatalogue;
    }

    public void setItemCatalogue(ItemCatalogue itemCatalogue) {
        this.itemCatalogue = itemCatalogue;
    }

    public MoveCatalogue getMoveCatalogue() {
        return moveCatalogue;
    }

    public void setMoveCatalogue(MoveCatalogue moveCatalogue) {
        this.moveCatalogue = moveCatalogue;
    }

    public PokemonSetCatalogue getPokemonSetCatalogue() {
        return pokemonSetCatalogue;
    }

    public void setPokemonSetCatalogue(PokemonSetCatalogue pokemonSetCatalogue) {
        this.pokemonSetCatalogue = pokemonSetCatalogue;
    }

    public Map<Type, Map<Type, Double>> getTypeChart() {
        return typeChart;
    }

    public void setTypeChart(Map<Type, Map<Type, Double>> typeChart) {
        this.typeChart = typeChart;
    }

    public PokemonSet selectPokemonSet(String pokemonSetName) {
        return pokemonSetCatalogue.selectPokemonSet(pokemonSetName);
    }

    public void savePokemonSet(String pokemonSetName, PokemonSet set) {
        pokemonSetCatalogue.savePokemonSet(pokemonSetName, set);
    }

    public Ability selectAbility(String abilityName) {
        return abilityCatalogue.selectAbility(abilityName);
    }

    public Item selectItem(String itemName) {
        return itemCatalogue.selectItem(itemName);
    }

    public Move selectMove(String moveName) {
        return moveCatalogue.selectMove(moveName);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PlatformData that = (PlatformData) o;
        return Objects.equals(pokemonCatalogue, that.pokemonCatalogue) && Objects.equals(abilityCatalogue, that.abilityCatalogue) && Objects.equals(itemCatalogue, that.itemCatalogue) && Objects.equals(moveCatalogue, that.moveCatalogue) && Objects.equals(pokemonSetCatalogue, that.pokemonSetCatalogue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemonCatalogue, abilityCatalogue, itemCatalogue, moveCatalogue, pokemonSetCatalogue);
    }

    @Override
    public String toString() {
        return "PlatformData{" +
                "pokemonCatalogue=" + pokemonCatalogue +
                ", abilityCatalogue=" + abilityCatalogue +
                ", itemCatalogue=" + itemCatalogue +
                ", moveCatalogue=" + moveCatalogue +
                ", pokemonSetCatalogue=" + pokemonSetCatalogue +
                '}';
    }
}