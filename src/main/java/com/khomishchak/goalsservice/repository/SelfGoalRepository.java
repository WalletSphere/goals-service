package com.khomishchak.goalsservice.repository;

import com.khomishchak.goalsservice.model.SelfGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SelfGoalRepository extends JpaRepository<SelfGoal, Long> {

    List<SelfGoal> findAllByUserId(Long userId);

    @Query(value = "SELECT * FROM self_goals sf WHERE NOW() > sf.end_date AND sf.is_closed = false", nativeQuery = true)
    List<SelfGoal> getAllOverdueGoals();
}
