package com.patc.model;

import com.patc.enums.StatsType;

import java.util.Objects;

public class Stats {
    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private StatsType statsType;

    public Stats(int hp, int attack, int defense, int specialAttack, int specialDefense, int speed, StatsType statsType) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.statsType = statsType;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public void setSpecialAttack(int specialAttack) {
        this.specialAttack = specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public void setSpecialDefense(int specialDefense) {
        this.specialDefense = specialDefense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public StatsType getStatsType() {
        return statsType;
    }

    public void setStatsType(StatsType statsType) {
        this.statsType = statsType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stats stats = (Stats) o;
        return hp == stats.hp
                && attack == stats.attack
                && defense == stats.defense
                && specialAttack == stats.specialAttack
                && specialDefense == stats.specialDefense
                && speed == stats.speed
                && statsType == stats.statsType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, attack, defense, specialAttack, specialDefense, speed, statsType);
    }

    @Override
    public String toString() {
        return "Stats{" +
                "hp=" + hp +
                ", attack=" + attack +
                ", defense=" + defense +
                ", specialAttack=" + specialAttack +
                ", specialDefense=" + specialDefense +
                ", speed=" + speed +
                ", statsType=" + statsType +
                '}';
    }
}