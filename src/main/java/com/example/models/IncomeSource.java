package com.example.models;

public class IncomeSource {

    private String source;
    private double amount;
    private int frequency; // 1 = weekly, 2 = biweekly

    public IncomeSource(String source, double amount, int frequency) {
        this.source = source;
        this.amount = amount;
        this.frequency = frequency;
    }

    public String getSource() {
        return source;
    }

    public double getAdjustedAmount() {
        // Assuming 4 weeks per month for simplicity
        return amount * (4.0 / frequency);
    }

    public double getRawAmount() {
        return amount;
    }

    public int getFrequency() {
        return frequency;
    }
}
