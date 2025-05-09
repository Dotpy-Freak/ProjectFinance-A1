package com.example.models;

public class Savings {
    private double goalPercent;
    private double goalAmount;

    public void setGoal(double totalIncome) {
        this.goalPercent = 10.0;
        this.goalAmount = (goalPercent / 100.0) * totalIncome;
    }

    public boolean isGoalAchievable(double remainingAmount) {
        return remainingAmount >= goalAmount;
    }

    public double getGoalAmount() {
        return goalAmount;
    }
}
