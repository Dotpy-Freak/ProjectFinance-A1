package com.example.views;

import java.util.Map;
import java.util.Scanner;

public class ExpenditureView {

    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n===== Expenditure Menu =====");
        System.out.println("1. Add expense");
        System.out.println("2. Remove expense");
        System.out.println("3. Show all expenses");
        System.out.println("4. Show total expenses");
        System.out.println("5. Clear all expenses");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public int getUserChoice() {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return choice;
            } else {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public String getExpenseName() {
        System.out.print("Enter expense name: ");
        return scanner.nextLine().trim();
    }

    public double getExpenseValue() {
        while (true) {
            System.out.print("Enter expense value: ");
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                return value;
            } else {
                System.out.println("Invalid value! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public void printExpenses(Map<String, Double> expenses) {
        if (expenses.isEmpty()) {
            System.out.println("No expenses to show.");
        } else {
            System.out.println("\n--- Expenses ---");
            expenses.forEach((key, value) ->
                    System.out.println(key + ": $" + value));
        }
    }

    public void printTotal(double total) {
        System.out.println("\nTotal Expenses: $" + total);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
