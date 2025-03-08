package com.patc.model;

import java.util.Objects;

public class PlatformData {
    private PokemonCatalogue pokemonCatalogue;
    private AbilityCatalogue abilityCatalogue;
    private ItemCatalogue itemCatalogue;
    private MoveCatalogue moveCatalogue;
    private PokemonSetCatalogue pokemonSetCatalogue;

    public PlatformData() {
        this.pokemonCatalogue = new PokemonCatalogue();
        this.abilityCatalogue = new AbilityCatalogue();
        this.itemCatalogue = new ItemCatalogue();
        this.moveCatalogue = new MoveCatalogue();
        this.pokemonSetCatalogue = new PokemonSetCatalogue(pokemonCatalogue.getPokemonMap(), abilityCatalogue.getAbilityMap(),
                                                            itemCatalogue.getItemMap(), moveCatalogue.getMoveMap());
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
    
    public PokemonSet selectSet(String pokemonSetName) {
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