package com.patc.service;

import com.patc.model.Battle;
import org.springframework.stereotype.Service;

@Service
public class BattleService {
    private Battle battle;

    public Battle initializeBattle() {
        battle = new Battle();
        calculateAllDamages();
        return battle;
    }

    private void calculateAllDamages() {
        battle.calculateAllDamages(true);
        battle.calculateAllDamages(false);
    }
}