package com.example.models;

import com.example.InputManager;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Expenditure {
    private Map<String, Double> expenses = new HashMap<>();
    private Double totalExpenses;

    public void addExpenses() {
        Scanner scanner = InputManager.getScanner();
        String choice;
        String source;
        Double value;

        do {
            System.out.println("Do you want to add any expenditure (Y/N)? Press 'N' to stop!");
            choice = scanner.nextLine().trim();

            if (choice.equalsIgnoreCase("Y")) {
                System.out.println("Enter the name of the source:");
                source = scanner.nextLine().trim();

                while (true) {
                    System.out.println("Enter the value of the expenditure:");

                    if (scanner.hasNextDouble()) {
                        value = scanner.nextDouble();
                        scanner.nextLine(); // consume leftover newline
                        expenses.put(source, value);
                        break; // exit value input loop
                    } else {
                        System.out.println("Invalid value! Please enter a valid number.");
                        scanner.nextLine(); // consume invalid input
                    }
                }
            } else if (!choice.equalsIgnoreCase("N")) {
                System.out.println("Invalid input! Please enter 'Y' or 'N'.");
            }
        } while (!choice.equalsIgnoreCase("N"));


    }

    public void addExpenses(String expense, Double value) {
        expenses.put(expense,value);
    }


    public double getTotalExpenses() {
        totalExpenses = expenses.values().stream().mapToDouble(Double::doubleValue).sum();
        return totalExpenses;
    }
}
