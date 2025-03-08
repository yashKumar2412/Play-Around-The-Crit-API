package com.patc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AbilityCatalogue {
    private Map<String, Ability> abilityMap;

    public AbilityCatalogue() {
        this.abilityMap = new HashMap<>();
        addAllAbilities();
    }

    private void addAllAbilities() {
        String overgrowName = "Overgrow";
        Ability overgrow = new Ability(overgrowName,
                "Overgrow increases the power of Grass-type moves by 50% (1.5×) when the ability-bearer's " +
                        "HP falls below a third of its maximum.", true);
        abilityMap.put(overgrowName, overgrow);

        String blazeName = "Blaze";
        Ability blaze = new Ability(blazeName,
                "Blaze increases the power of Fire-type moves by 50% (1.5×) when the ability-bearer's " +
                        "HP falls below a third of its maximum.", true);
        abilityMap.put(blazeName, blaze);

        String torrentName = "Torrent";
        Ability torrent = new Ability(torrentName,
                "Torrent increases the power of Water-type moves by 50% (1.5×) when the ability-bearer's " +
                        "HP falls below a third of its maximum.", true);
        abilityMap.put(torrentName, torrent);
    }

    public Map<String, Ability> getAbilityMap() {
        return abilityMap;
    }

    public void setAbilityMap(Map<String, Ability> abilityMap) {
        this.abilityMap = abilityMap;
    }

    public Ability selectAbility(String abilityName) {
        if (abilityMap.containsKey(abilityName))
            return abilityMap.get(abilityName);

        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AbilityCatalogue that = (AbilityCatalogue) o;
        return Objects.equals(abilityMap, that.abilityMap);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(abilityMap);
    }

    @Override
    public String toString() {
        return "AbilityCatalogue{" +
                "abilityMap=" + abilityMap +
                '}';
    }
}