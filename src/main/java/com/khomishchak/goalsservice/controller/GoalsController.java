package com.khomishchak.goalsservice.controller;

import com.khomishchak.goalsservice.model.CryptoGoalTableTransaction;
import com.khomishchak.goalsservice.model.CryptoGoalsTable;
import com.khomishchak.goalsservice.model.SelfGoal;
import com.khomishchak.goalsservice.service.GoalsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/v1/goals")
public class GoalsController {

    // TODO: replace @RequestHeader("UserId") with AOP poincut to extract userId before needed controllers

    private final GoalsService goalsService;

    public GoalsController(GoalsService goalsService) {
        this.goalsService = goalsService;
    }

    @PostMapping("/crypto-tables")
    public ResponseEntity<CryptoGoalsTable> createCryptoGoalsTable(@RequestHeader("UserId") Long userId,
                                                                   @RequestBody CryptoGoalsTable requestTable) {
        return new ResponseEntity<>(goalsService.createCryptoGoalsTable(userId, requestTable), HttpStatus.CREATED);
    }

    @GetMapping("/crypto-tables")
    public ResponseEntity<CryptoGoalsTable> getCryptoGoalsTable(@RequestHeader("UserId") Long userId) {
        return new ResponseEntity<>(goalsService.getCryptoGoalsTable(userId), HttpStatus.OK);
    }

    @PutMapping("/crypto-tables")
    public ResponseEntity<CryptoGoalsTable> updateWholeCryptoGoalsTable(@RequestHeader("UserId") Long userId,
                                                                        @RequestBody CryptoGoalsTable cryptoGoalsTable) {
        return new ResponseEntity<>(goalsService.updateCryptoGoalsTable(cryptoGoalsTable, userId), HttpStatus.OK);
    }

    @PutMapping("/{tableId}/crypto-tables")
    public ResponseEntity<CryptoGoalsTable> updateCryptoGoalsTableWithSingleTransaction(
            @RequestBody CryptoGoalTableTransaction transaction, @PathVariable Long tableId) {
        return new ResponseEntity<>(goalsService.updateCryptoGoalsTable(transaction, tableId), HttpStatus.OK);
    }

    @GetMapping("/self-goals")
    public ResponseEntity<List<SelfGoal>> getSelfGoals(@RequestHeader("UserId") Long userId) {
        return new ResponseEntity<>(goalsService.getSelfGoals(userId), HttpStatus.OK);
    }

    @PostMapping("/self-goals")
    public ResponseEntity<List<SelfGoal>> createSelfGoals(@RequestHeader("UserId") Long userId, @RequestBody List<SelfGoal> goals) {
        return new ResponseEntity<>(goalsService.createSelfGoals(userId, goals), HttpStatus.OK);
    }
}
