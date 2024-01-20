package com.khomishchak.goalsservice.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Embeddable
public class CryptoGoalsTableRecord {
    private String name;
    private BigDecimal quantity;
    private BigDecimal averageCost;
    private BigDecimal goalQuantity;

    @Transient
    private BigDecimal donePercentage;

    @Transient
    private BigDecimal leftToBuy;

    @Transient
    private boolean finished;
}
