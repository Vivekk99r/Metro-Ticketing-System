package com.metro.controller;

import com.metro.model.*;
import com.metro.service.MetroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/metro")
public class MetroController {
    @Autowired
    private MetroService metroService;

    @PostMapping("/recharge")
    public UserCard rechargeCard(@RequestParam Long cardId, @RequestParam double amount) {
        return metroService.rechargeCard(cardId, amount);
    }

    @PostMapping("/travel")
    public Transaction travel(@RequestParam Long cardId, @RequestParam String source, @RequestParam String destination) {
        return metroService.travel(cardId, source, destination);
    }

    @PostMapping("/add-station")
    public Station addStation(@RequestParam String name) {
        return metroService.addStation(name);
    }

    @DeleteMapping("/remove-station/{stationId}")
    public void removeStation(@PathVariable Long stationId) {
        metroService.removeStation(stationId);
    }
}
