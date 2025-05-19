package com.example.models;

import com.example.InputScanner;

import java.util.Scanner;

public class Savings {
    private double goalPercent;
    private double goalAmount;

    public void setGoal(double totalIncome) {
        Scanner scanner = InputScanner.getScanner();
        String choice;
        double goalPercentage;

        while (true) {
            System.out.println("Do you want to use Percentage to save? Press (Y/N)");
            choice = scanner.next();

            if (choice.equalsIgnoreCase("N")) {
                // User wants to enter a fixed amount

                while (true) {
                    System.out.println("Enter the Saving goal amount you want to have:");
                    if (scanner.hasNextDouble()) {
                        double amount = scanner.nextDouble();
                        if (amount >= 0) {
                            this.goalAmount = amount;
                            this.goalPercent = 0; // or some indicator
                            return;
                        } else {
                            System.out.println("Amount must be non-negative. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input! Please enter a valid number.");
                        scanner.next(); // discard invalid input
                    }
                }

            } else if (choice.equalsIgnoreCase("Y")) {
                // User wants to enter percentage
                while (true) {
                    System.out.println("Enter the goal percentage:");
                    if (scanner.hasNextDouble()) {
                        goalPercentage = scanner.nextDouble();
                        if (goalPercentage >= 0 && goalPercentage <= 100) {
                            this.goalPercent = goalPercentage;
                            this.goalAmount = (goalPercentage / 100.0) * totalIncome;
                            return;
                        } else {
                            System.out.println("Goal percentage must be between 0 and 100. Please try again.");
                        }
                    } else {
                        System.out.println("Invalid input! Please enter a valid number.");
                        scanner.next(); // consume invalid input
                    }
                }

            } else {
                System.out.println("Invalid input! Please enter Y or N.");
            }
        }
    }



    public boolean isGoalAchievable(double remainingAmount) {
        return remainingAmount >= goalAmount;
    }

    public double getGoalAmount() {
        return goalAmount;
    }
}
