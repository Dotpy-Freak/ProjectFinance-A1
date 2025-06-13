package com.example.models;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Expenditure {

    private Map<String, Double> expenses = new HashMap<>();

    public void addExpense(String source, Double value) {
        if (source == null || source.isEmpty() || value == null || value < 0) {
            throw new IllegalArgumentException("Invalid expense source or value.");
        }
        expenses.put(source, value);
    }

    public boolean removeExpense(String source) {
        return expenses.remove(source) != null;
    }

    public double getTotalExpenses() {
        return expenses.values().stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public Map<String, Double> getExpenses() {
        return Collections.unmodifiableMap(expenses);
    }

    public void clearExpenses() {
        expenses.clear();
    }
}
