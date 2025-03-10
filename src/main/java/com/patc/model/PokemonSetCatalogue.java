package com.patc.model;

import com.patc.enums.Nature;
import com.patc.enums.StatType;

import java.util.*;

public class PokemonSetCatalogue {
    private Map<String, PokemonSet> pokemonSetMap;

    public PokemonSetCatalogue(Map<String, Pokemon> pokemonMap, Map<String, Ability> abilityMap, Map<String, Item> itemMap, Map<String, Move> moveMap) {
        pokemonSetMap = new HashMap<>();
        addAllSets(pokemonMap, abilityMap, itemMap, moveMap);
    }

    private void addAllSets(Map<String, Pokemon> pokemonMap, Map<String, Ability> abilityMap, Map<String, Item> itemMap, Map<String, Move> moveMap) {
        for (Map.Entry<String, Pokemon> entry: pokemonMap.entrySet()) {
            Stats iv = new Stats(StatType.IV, 31, 31, 31, 31, 31, 31);
            Stats ev = new Stats(StatType.EV, 0, 0, 0, 0, 0, 0);
            Ability ability = getDefaultAbility(abilityMap, entry);
            Nature nature = Nature.Hardy;
            Item item = null;
            List<Move> moves = new ArrayList<>();
            String setKey = entry.getKey() + " Default";
            PokemonSet set = new PokemonSet(setKey, entry.getValue(), 50, iv, ev, ability, nature, item, moves);
            pokemonSetMap.put(setKey, set);
        }
    }

    private static Ability getDefaultAbility(Map<String, Ability> abilityMap, Map.Entry<String, Pokemon> entry) {
        return switch (entry.getKey()) {
            case "Chesnaught" -> abilityMap.get("Overgrow");
            case "Delphox" -> abilityMap.get("Blaze");
            case "Greninja" -> abilityMap.get("Torrent");
            default -> null;
        };
    }

    public Map<String, PokemonSet> getPokemonSetMap() {
        return pokemonSetMap;
    }

    public void setPokemonSetMap(Map<String, PokemonSet> pokemonSetMap) {
        this.pokemonSetMap = pokemonSetMap;
    }

    public PokemonSet selectPokemonSet(String pokemonSetName) {
        if (pokemonSetMap.containsKey(pokemonSetName))
            return new PokemonSet(pokemonSetMap.get(pokemonSetName));

        return null;
    }

    public void savePokemonSet(String pokemonSetName, PokemonSet set) {
        pokemonSetMap.put(pokemonSetName, set);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PokemonSetCatalogue that = (PokemonSetCatalogue) o;
        return Objects.equals(pokemonSetMap, that.pokemonSetMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pokemonSetMap);
    }

    @Override
    public String toString() {
        return "PokemonSetCatalogue{" +
                "setMap=" + pokemonSetMap +
                '}';
    }
}