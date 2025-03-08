package com.patc.model;

import com.patc.enums.StatType;
import com.patc.enums.Type;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PokemonCatalogue {
    private Map<String, Pokemon> pokemonMap;

    public PokemonCatalogue() {
        this.pokemonMap = new HashMap<>();
        addAllPokemon();
    }

    private void addAllPokemon() {
        String chesnaughtName = "Chesnaught";
        Stats chesnaughtStats = new Stats(StatType.ACTUAL, 88, 107, 122, 74, 75, 64);
        Pokemon chesnaught = new Pokemon(652, chesnaughtName, Type.GRASS, Type.FIGHTING,
                1.6, 90.0, chesnaughtStats, false);
        pokemonMap.put(chesnaughtName, chesnaught);

        String delphoxName = "Delphox";
        Stats delphoxStats = new Stats(StatType.ACTUAL, 75, 69, 72, 114, 100, 104);
        Pokemon delphox = new Pokemon(655, delphoxName, Type.FIRE, Type.PSYCHIC,
                1.5, 39.0, delphoxStats, false);
        pokemonMap.put(delphoxName, delphox);

        String greninjaName = "Greninja";
        Stats greninjaStats = new Stats(StatType.ACTUAL, 72, 95, 67, 103, 71, 122);
        Pokemon greninja = new Pokemon(658, greninjaName, Type.WATER, Type.DARK,
                1.5, 40.0, greninjaStats, false);
        pokemonMap.put(greninjaName, greninja);
    }

    public Map<String, Pokemon> getPokemonMap() {
        return pokemonMap;
    }

    public void setPokemonMap(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PokemonCatalogue that = (PokemonCatalogue) o;
        return Objects.equals(pokemonMap, that.pokemonMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pokemonMap);
    }

    @Override
    public String toString() {
        return "PokemonCatalogue{" +
                "pokemonMap=" + pokemonMap +
                '}';
    }
}