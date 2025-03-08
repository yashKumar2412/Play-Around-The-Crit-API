package com.patc.model;

import com.patc.enums.Type;

import java.util.Objects;

public class Pokemon {
    private int dexNumber;
    private String name;
    private Type primaryType;
    private Type secondaryType;
    private double height;
    private double weight;
    private Stats baseStats;
    private boolean isMega;

    public Pokemon(int dexNumber, String name, Type primaryType, Type secondaryType, double height, double weight, Stats baseStats, boolean isMega) {
        this.dexNumber = dexNumber;
        this.name = name;
        this.primaryType = primaryType;
        this.secondaryType = secondaryType;
        this.height = height;
        this.weight = weight;
        this.baseStats = baseStats;
        this.isMega = isMega;
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

    public Type getPrimaryType() {
        return primaryType;
    }

    public void setPrimaryType(Type primaryType) {
        this.primaryType = primaryType;
    }

    public Type getSecondaryType() {
        return secondaryType;
    }

    public void setSecondaryType(Type secondaryType) {
        this.secondaryType = secondaryType;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }

    public boolean isMega() {
        return isMega;
    }

    public void setMega(boolean mega) {
        isMega = mega;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return dexNumber == pokemon.dexNumber && Double.compare(height, pokemon.height) == 0 && Double.compare(weight, pokemon.weight) == 0 && isMega == pokemon.isMega && Objects.equals(name, pokemon.name) && primaryType == pokemon.primaryType && secondaryType == pokemon.secondaryType && Objects.equals(baseStats, pokemon.baseStats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dexNumber, name, primaryType, secondaryType, height, weight, baseStats, isMega);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "dexNumber=" + dexNumber +
                ", name='" + name + '\'' +
                ", primaryType=" + primaryType +
                ", secondaryType=" + secondaryType +
                ", height=" + height +
                ", weight=" + weight +
                ", baseStats=" + baseStats +
                ", isMega=" + isMega +
                '}';
    }
}