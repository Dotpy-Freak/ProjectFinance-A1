package models;

import java.util.HashMap;
import java.util.Map;

public class Expenditure {
    private Map<String, Double> expenses = new HashMap<>();

    public void addExpenses() {
        expenses.put("Rent", 1000.0);
        expenses.put("Food", 300.0);
        expenses.put("Transport", 150.0);
    }

    public double getTotalExpenses() {
        return expenses.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}
