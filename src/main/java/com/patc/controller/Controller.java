package com.patc.controller;

import com.patc.enums.RequestType;
import com.patc.enums.Status;
import com.patc.model.SelectRequestBody;
import com.patc.model.Battle;
import com.patc.model.Stats;
import com.patc.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class Controller {

    @Autowired
    BattleService battleService;

    @GetMapping("")
    public Battle initializeBattle() {
        return battleService.initializeBattle();
    }

    @GetMapping("/select")
    public Battle select(@RequestBody SelectRequestBody requestBody) {
        if (requestBody.getType().equals(RequestType.SET)) {
            return battleService.selectPokemonSet(requestBody.getName(), requestBody.isUser());
        } else if (requestBody.getType().equals(RequestType.ABILITY)) {
            return battleService.selectAbility(requestBody.getName(), requestBody.isUser());
        } else if (requestBody.getType().equals(RequestType.ITEM)) {
            return battleService.selectItem(requestBody.getName(), requestBody.isUser());
        } else if (requestBody.getType().equals(RequestType.MOVES)) {
            return battleService.selectMove(requestBody.getNames(), requestBody.isUser());
        }

        return battleService.getBattle();
    }

    @GetMapping("/update/health/{newHealth}/{isUser}")
    public Battle updateHealth(@PathVariable int newHealth, @PathVariable boolean isUser) {
        return battleService.updateHealth(newHealth, isUser);
    }

    @GetMapping("/update/status/{newStatus}/{isUser}")
    public Battle updateStatus(@PathVariable Status newStatus, @PathVariable boolean isUser) {
        return battleService.updateStatus(newStatus, isUser);
    }

    @GetMapping("/update/stats/modifiers/{isUser}")
    public Battle updateStatModifiers(@RequestBody Stats statModifiers, @PathVariable boolean isUser) {
        return battleService.updateEffectiveStats(statModifiers, isUser);
    }

    @GetMapping("/update/screens/{screenType}/{isUser}")
    public Battle updateScreens(@PathVariable String screenType, @PathVariable boolean isUser) {
        return battleService.updateScreens(screenType, isUser);
    }
}