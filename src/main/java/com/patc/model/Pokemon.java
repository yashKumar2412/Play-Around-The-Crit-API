package com.patc.model;

import com.patc.enums.Nature;
import com.patc.enums.Type;

import java.util.Objects;

public class Pokemon {
    private int dexNumber;
    private String name;
    private Type type1;
    private Type type2;
    private Ability ability;
    private Nature nature;
    private Stats baseStats;
    private Stats iv;
    private Stats ev;
    private Stats effectiveStats;

    public Pokemon(int dexNumber, String name, Type type1, Type type2, Ability ability, Nature nature, Stats baseStats, Stats iv, Stats ev) {
        this.dexNumber = dexNumber;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.ability = ability;
        this.nature = nature;
        this.baseStats = baseStats;
        this.iv = iv;
        this.ev = ev;
    }

    public int getDexNumber() {
        return dexNumber;
    }

    public void setDexNumber(int dexNumber) {
        this.dexNumber = dexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType1() {
        return type1;
    }

    public void setType1(Type type1) {
        this.type1 = type1;
    }

    public Type getType2() {
        return type2;
    }

    public void setType2(Type type2) {
        this.type2 = type2;
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

    public Stats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
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

    public Stats getEffectiveStats() {
        return effectiveStats;
    }

    public void setEffectiveStats(Stats effectiveStats) {
        this.effectiveStats = effectiveStats;
    }

    // todo: implement actual calculation
    public void updateStats() {}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return dexNumber == pokemon.dexNumber
                && Objects.equals(name, pokemon.name)
                && type1 == pokemon.type1
                && type2 == pokemon.type2
                && Objects.equals(ability, pokemon.ability)
                && Objects.equals(nature, pokemon.nature)
                && Objects.equals(baseStats, pokemon.baseStats)
                && Objects.equals(iv, pokemon.iv)
                && Objects.equals(ev, pokemon.ev)
                && Objects.equals(effectiveStats, pokemon.effectiveStats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dexNumber, name, type1, type2, ability, nature, baseStats, iv, ev, effectiveStats);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "dexNumber=" + dexNumber +
                ", name='" + name + '\'' +
                ", type1=" + type1 +
                ", type2=" + type2 +
                ", ability=" + ability +
                ", nature=" + nature +
                ", baseStats=" + baseStats +
                ", iv=" + iv +
                ", ev=" + ev +
                ", effectiveStats=" + effectiveStats +
                '}';
    }
}