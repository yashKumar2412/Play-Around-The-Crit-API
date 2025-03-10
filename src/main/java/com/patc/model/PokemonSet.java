package com.patc.model;

import com.patc.enums.Nature;
import com.patc.enums.StatType;

import java.util.List;
import java.util.Objects;

public class PokemonSet {
    private String name;
    private Pokemon pokemon;
    private int level;
    private Stats iv;
    private Stats ev;
    private Ability ability;
    private Nature nature;
    private Stats displayedStats;
    private Item heldItem;
    private List<Move> moves;

    public PokemonSet(String name, Pokemon pokemon, int level, Stats iv, Stats ev, Ability ability, Nature nature, Item heldItem, List<Move> moves) {
        this.name = name;
        this.pokemon = pokemon;
        this.level = level;
        this.iv = iv;
        this.ev = ev;
        this.ability = ability;
        this.nature = nature;
        calculateStats();
        this.heldItem = heldItem;
        this.moves = moves;
    }

    private void calculateStats() {
        int hp = ((2 * pokemon.getBaseStats().getHp() + iv.getHp() + (ev.getHp() / 4)) * level) / 100 + level + 10;
        int attack = ((2 * pokemon.getBaseStats().getAttack() + iv.getAttack() + (ev.getAttack() / 4)) * level) / 100 + 5;
        int defense = ((2 * pokemon.getBaseStats().getDefense() + iv.getDefense() + (ev.getDefense() / 4)) * level) / 100 + 5;
        int specialAttack = ((2 * pokemon.getBaseStats().getSpecialAttack() + iv.getSpecialAttack() + (ev.getSpecialAttack() / 4)) * level) / 100 + 5;
        int specialDefense = ((2 * pokemon.getBaseStats().getSpecialDefense() + iv.getSpecialDefense() + (ev.getSpecialDefense() / 4)) * level) / 100 + 5;
        int speed = ((2 * pokemon.getBaseStats().getSpeed() + iv.getSpeed() + (ev.getSpeed() / 4)) * level) / 100 + 5;

        if (nature == Nature.Lonely || nature == Nature.Adamant || nature == Nature.Naughty || nature == Nature.Brave)
            attack = (attack * 11) / 10;

        if (nature == Nature.Bold || nature == Nature.Impish || nature == Nature.Lax || nature == Nature.Relaxed)
            defense = (defense * 11) / 10;

        if (nature == Nature.Modest || nature == Nature.Mild || nature == Nature.Rash || nature == Nature.Quiet)
            specialAttack = (specialAttack * 11) / 10;

        if (nature == Nature.Calm || nature == Nature.Gentle || nature == Nature.Careful || nature == Nature.Sassy)
            specialDefense = (specialDefense * 11) / 10;

        if (nature == Nature.Timid || nature == Nature.Hasty || nature == Nature.Jolly || nature == Nature.Naive)
            speed = (speed * 11) / 10;

        if (nature == Nature.Bold || nature == Nature.Modest || nature == Nature.Calm || nature == Nature.Timid)
            attack = (attack * 9) / 10;

        if (nature == Nature.Lonely || nature == Nature.Mild || nature == Nature.Gentle || nature == Nature.Hasty)
            defense = (defense * 9) / 10;

        if (nature == Nature.Adamant || nature == Nature.Impish || nature == Nature.Careful || nature == Nature.Jolly)
            specialAttack = (specialAttack * 9) / 10;

        if (nature == Nature.Naughty || nature == Nature.Lax || nature == Nature.Rash || nature == Nature.Naive)
            specialDefense = (specialDefense * 9) / 10;

        if (nature == Nature.Brave || nature == Nature.Relaxed || nature == Nature.Quiet || nature == Nature.Sassy)
            speed = (speed * 9) / 10;
        
        this.displayedStats = new Stats(StatType.ACTUAL, hp, attack, defense, specialAttack, specialDefense, speed);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Stats getIv() {
        return iv;
    }

    public void setIv(Stats iv) {
        this.iv = iv;
    }

    public Stats getEv() {
        return ev;
    }

    public void setEv(Stats ev) {
        this.ev = ev;
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }

    public Nature getNature() {
        return nature;
    }

    public void setNature(Nature nature) {
        this.nature = nature;
    }

    public Stats getDisplayedStats() {
        return displayedStats;
    }

    public void setDisplayedStats(Stats displayedStats) {
        this.displayedStats = displayedStats;
    }

    public Item getHeldItem() {
        return heldItem;
    }

    public void setHeldItem(Item heldItem) {
        this.heldItem = heldItem;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PokemonSet that = (PokemonSet) o;
        return level == that.level && Objects.equals(name, that.name) && Objects.equals(pokemon, that.pokemon) && Objects.equals(iv, that.iv) && Objects.equals(ev, that.ev) && Objects.equals(ability, that.ability) && nature == that.nature && Objects.equals(displayedStats, that.displayedStats) && Objects.equals(heldItem, that.heldItem) && Objects.equals(moves, that.moves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pokemon, level, iv, ev, ability, nature, displayedStats, heldItem, moves);
    }

    @Override
    public String toString() {
        return "PokemonSet{" +
                "name='" + name + '\'' +
                ", pokemon=" + pokemon +
                ", level=" + level +
                ", iv=" + iv +
                ", ev=" + ev +
                ", ability=" + ability +
                ", nature=" + nature +
                ", displayedStats=" + displayedStats +
                ", heldItem=" + heldItem +
                ", moves=" + moves +
                '}';
    }
}