package com.patc.controller;

import com.patc.enums.RequestType;
import com.patc.model.SelectRequestBody;
import com.patc.model.Battle;
import com.patc.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}