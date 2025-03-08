package com.patc.model;

import com.patc.enums.MoveCategory;
import com.patc.enums.Type;

import java.util.Objects;

public class Move {
    private String name;
    private Type type;
    private boolean doesDamage;
    private int basePower;
    private MoveCategory category;

    public Move(String name, Type type, boolean doesDamage, int basePower, MoveCategory category) {
        this.name = name;
        this.type = type;
        this.doesDamage = doesDamage;
        this.basePower = basePower;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isDoesDamage() {
        return doesDamage;
    }

    public void setDoesDamage(boolean doesDamage) {
        this.doesDamage = doesDamage;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }

    public MoveCategory getCategory() {
        return category;
    }

    public void setCategory(MoveCategory category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return doesDamage == move.doesDamage && basePower == move.basePower && Objects.equals(name, move.name) && type == move.type && category == move.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, doesDamage, basePower, category);
    }

    @Override
    public String toString() {
        return "Move{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", doesDamage=" + doesDamage +
                ", basePower=" + basePower +
                ", category=" + category +
                '}';
    }
}