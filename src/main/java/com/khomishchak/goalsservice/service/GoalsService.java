package com.khomishchak.goalsservice.service;

import com.khomishchak.goalsservice.model.CryptoGoalTableTransaction;
import com.khomishchak.goalsservice.model.CryptoGoalsTable;
import com.khomishchak.goalsservice.model.SelfGoal;

import java.util.List;

public interface GoalsService {

    CryptoGoalsTable createCryptoGoalsTable(Long userId, CryptoGoalsTable tableRequest);

    CryptoGoalsTable getCryptoGoalsTable(Long userId);

    CryptoGoalsTable updateCryptoGoalsTable(CryptoGoalsTable cryptoGoalsTable);

    CryptoGoalsTable updateCryptoGoalsTable(CryptoGoalTableTransaction transaction, long tableId);

    List<SelfGoal> getSelfGoals(Long userId);

    List<SelfGoal> createSelfGoals(Long userId, List<SelfGoal> goals);

    List <SelfGoal> saveAll(Iterable<SelfGoal> entities);

    List<SelfGoal> getAllOverdueGoals();

    boolean overdueGoalIsAchieved(SelfGoal goal);
}
