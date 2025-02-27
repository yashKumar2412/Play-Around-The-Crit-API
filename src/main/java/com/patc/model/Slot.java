package com.patc.model;

import com.patc.enums.Status;

import java.util.Arrays;
import java.util.Objects;

public class Slot {
    private Pokemon pokemon;
    private int health;
    private int level;
    private Stats ingameStats;
    private Item item;
    private Status status;
    private Move[] moves;

    public Slot(Pokemon pokemon, int health, int level, Stats ingameStats, Item item, Status status, Move[] moves) {
        this.pokemon = pokemon;
        this.health = health;
        this.level = level;
        this.ingameStats = ingameStats;
        this.item = item;
        this.status = status;
        this.moves = moves;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Stats getIngameStats() {
        return ingameStats;
    }

    public void setIngameStats(Stats ingameStats) {
        this.ingameStats = ingameStats;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Move[] getMoves() {
        return moves;
    }

    public void setMoves(Move[] moves) {
        this.moves = moves;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Slot slot = (Slot) o;
        return health == slot.health
                && level == slot.level
                && Objects.equals(pokemon, slot.pokemon)
                && Objects.equals(ingameStats, slot.ingameStats)
                && Objects.equals(item, slot.item)
                && status == slot.status
                && Objects.deepEquals(moves, slot.moves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pokemon, health, level, ingameStats, item, status, Arrays.hashCode(moves));
    }

    @Override
    public String toString() {
        return "Slot{" +
                "pokemon=" + pokemon +
                ", health=" + health +
                ", level=" + level +
                ", ingameStats=" + ingameStats +
                ", item=" + item +
                ", status=" + status +
                ", moves=" + Arrays.toString(moves) +
                '}';
    }
}