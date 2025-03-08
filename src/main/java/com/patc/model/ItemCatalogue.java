package com.patc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ItemCatalogue {
    private Map<String, Item> itemMap;

    public ItemCatalogue() {
        itemMap = new HashMap<>();
        addAllItems();
    }

    private void addAllItems() {
        String miracleSeedName = "Miracle Seed";
        Item miracleSeed = new Item(miracleSeedName, "When held, it raises the power of Grass-type moves by 20%.", true);
        itemMap.put(miracleSeedName, miracleSeed);

        String charcoalName = "Charcoal";
        Item charcoal = new Item(charcoalName, "When held, it raises the power of Fire-type moves by 20%.", true);
        itemMap.put(charcoalName, charcoal);

        String mysticWaterName = "Mystic Water";
        Item mysticWater = new Item(mysticWaterName, "When held, it raises the power of Water-type moves by 20%.", true);
        itemMap.put(mysticWaterName, mysticWater);
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<String, Item> itemMap) {
        this.itemMap = itemMap;
    }

    public Item selectItem(String itemName) {
        if (itemMap.containsKey(itemName))
            return itemMap.get(itemName);

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemCatalogue that = (ItemCatalogue) o;
        return Objects.equals(itemMap, that.itemMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(itemMap);
    }

    @Override
    public String toString() {
        return "ItemCatalogue{" +
                "itemMap=" + itemMap +
                '}';
    }
}