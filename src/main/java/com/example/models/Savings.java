package com.example.models;

public class Savings {

    private double goalPercent; // if 0 → fixed amount used
    private double goalAmount;

    public void setGoalByAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be non-negative.");
        }
        this.goalAmount = amount;
        this.goalPercent = 0;
    }

    public void setGoalByPercent(double percent, double totalIncome) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Goal percentage must be between 0 and 100.");
        }
        this.goalPercent = percent;
        this.goalAmount = (percent / 100.0) * totalIncome;
    }

    public boolean isGoalAchievable(double remainingAmount) {
        return remainingAmount >= goalAmount;
    }

    public double getGoalAmount() {
        return goalAmount;
    }

    public double getGoalPercent() {
        return goalPercent;
    }
}
