package com.khomishchak.goalsservice.model.transaction;

import java.math.BigDecimal;

public record CreateNewRecordTransaction(String name, BigDecimal quantity, BigDecimal price, BigDecimal goalQuantity) {

    public CreateNewRecordTransaction {
        if (quantity != null && quantity.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than zero.");
        }
        if (goalQuantity != null && goalQuantity.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Goal Quantity cannot be less than zero.");
        }
    }
}
