package com.patc.model;

import com.patc.enums.Category;
import com.patc.enums.Type;

import java.util.Objects;

public class Move {

    private String name;
    private String description;
    private Type type;
    private int basePower;
    private Category category;

    public Move(String name, String description, Type type, int basePower, Category category) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.basePower = basePower;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getBasePower() {
        return basePower;
    }

    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return basePower == move.basePower && Objects.equals(name, move.name) && Objects.equals(description, move.description) && type == move.type && category == move.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, type, basePower, category);
    }

    @Override
    public String toString() {
        return "Move{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", basePower=" + basePower +
                ", category=" + category +
                '}';
    }
}