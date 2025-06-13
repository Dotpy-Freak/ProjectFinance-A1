package com.example.views;

import java.util.Scanner;

public class SavingsView {

    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n===== Savings Menu =====");
        System.out.println("1. Set goal by fixed amount");
        System.out.println("2. Set goal by percentage of income");
        System.out.println("3. Show goal amount");
        System.out.println("4. Check if goal achievable");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public int getUserChoice() {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public double getGoalAmountInput() {
        while (true) {
            System.out.print("Enter saving goal amount: ");
            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();
                scanner.nextLine();
                return amount;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public double getGoalPercentInput() {
        while (true) {
            System.out.print("Enter saving goal percentage (0 - 100): ");
            if (scanner.hasNextDouble()) {
                double percent = scanner.nextDouble();
                scanner.nextLine();
                return percent;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public double getRemainingAmount() {
        while (true) {
            System.out.print("Enter remaining available amount: ");
            if (scanner.hasNextDouble()) {
                double amount = scanner.nextDouble();
                scanner.nextLine();
                return amount;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public void printGoalAmount(double amount) {
        System.out.printf("Current savings goal amount: $%.2f%n", amount);
    }

    public void printGoalAchievability(boolean achievable) {
        if (achievable) {
            System.out.println("You can achieve your saving goal with current remaining amount.");
        } else {
            System.out.println("You CANNOT achieve your saving goal with current remaining amount.");
        }
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
