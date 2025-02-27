package com.patc.model;

import java.util.Objects;

public class Item {
    private String name;
    private String description;
    private boolean hasInGameEffect;

    public Item(String name, String description, boolean hasInGameEffect) {
        this.name = name;
        this.description = description;
        this.hasInGameEffect = hasInGameEffect;
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

    public boolean isHasInGameEffect() {
        return hasInGameEffect;
    }

    public void setHasInGameEffect(boolean hasInGameEffect) {
        this.hasInGameEffect = hasInGameEffect;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return hasInGameEffect == item.hasInGameEffect
                && Objects.equals(name, item.name)
                && Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, hasInGameEffect);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", hasInGameEffect=" + hasInGameEffect +
                '}';
    }
}