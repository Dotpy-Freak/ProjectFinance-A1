package com.example.models;

import java.util.Scanner;

public class Savings {
    private double goalPercent;
    private double goalAmount;

    public void setGoal(double totalIncome) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        double goalPercentage = 0;
        boolean exit = false;
        while (!exit) {
            do {
                System.out.println("Do you want to use Percentage to save? Press (Y/N)");
                 choice = scanner.next();
                 scanner.nextLine();
                 if (choice.equalsIgnoreCase("N")){
                     exit = true;
                     break;
                 }
            }
            while (!choice.equalsIgnoreCase("Y"));
            if (exit) break;

            while (true) {
                System.out.println("Enter the goal percentage:");

                if (scanner.hasNextDouble()) {
                    goalPercentage = scanner.nextDouble();

                    if (goalPercentage >= 0 && goalPercentage <= 100) {
                        break; // valid input, exit loop
                    } else {
                        System.out.println("Goal percentage must be between 0 and 100. Please try again.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next(); // consume the invalid input
                }
            }
        this.goalPercent = goalPercentage;
        this.goalAmount = (goalPercent / 100.0) * totalIncome;
        scanner.close();
        }
    }

    public boolean isGoalAchievable(double remainingAmount) {
        return remainingAmount >= goalAmount;
    }

    public double getGoalAmount() {
        return goalAmount;
    }
}
