package com.patc.controller;

import com.patc.model.Battle;
import com.patc.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}