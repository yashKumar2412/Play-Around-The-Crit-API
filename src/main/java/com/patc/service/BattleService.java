package com.patc.service;

import com.patc.enums.Status;
import com.patc.model.Battle;
import com.patc.model.Stats;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleService {
    private Battle battle;

    public Battle initializeBattle() {
        battle = new Battle();
        calculateAllDamages();
        return battle;
    }

    public Battle selectPokemonSet(String pokemonSetName, boolean isUser) {
        battle.selectPokemonSet(pokemonSetName, isUser);
        calculateAllDamages();
        return battle;
    }

    public Battle selectAbility(String abilityName, boolean isUser) {
        battle.selectAbility(abilityName, isUser);
        calculateAllDamages();
        return battle;
    }

    public Battle selectItem(String itemName, boolean isUser) {
        battle.selectItem(itemName, isUser);
        calculateAllDamages();
        return battle;
    }

    public Battle selectMove(List<String> moveNames, boolean isUser) {
        battle.selectMove(moveNames, isUser);
        calculateAllDamages();
        return battle;
    }

    public Battle updateHealth(int newHealth, boolean isUser) {
        battle.updateHealth(newHealth, isUser);
        calculateAllDamages();
        return battle;
    }

    public Battle updateEffectiveStats(Stats statModifiers, boolean isUser) {
        battle.updateEffectiveStats(statModifiers, isUser);
        calculateAllDamages();
        return battle;
    }

    public Battle updateStatus(Status newStatus, boolean isUser) {
        battle.updateStatus(newStatus, isUser);
        calculateAllDamages();
        return battle;
    }

    public Battle updateScreens(String screenType, boolean isUser) {
        battle.updateScreen(screenType, isUser);
        calculateAllDamages();
        return battle;
    }

    private void calculateAllDamages() {
        battle.calculateAllDamages(true);
        battle.calculateAllDamages(false);
    }

    public Battle getBattle() {
        return battle;
    }
}