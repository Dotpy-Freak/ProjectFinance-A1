package com.example.views;

import java.util.List;
import java.util.Scanner;
import com.example.models.IncomeSource;

public class IncomeView {

    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n===== Income Menu =====");
        System.out.println("1. Add income source");
        System.out.println("2. Remove income source");
        System.out.println("3. Show all income sources");
        System.out.println("4. Show total income");
        System.out.println("5. Clear all income sources");
        System.out.println("6. Exit");
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

    public String getIncomeSourceName() {
        System.out.print("Enter income source name: ");
        return scanner.nextLine().trim();
    }

    public double getIncomeAmount() {
        while (true) {
            System.out.print("Enter income amount: ");
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } else {
                System.out.println("Invalid value! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public int getIncomeFrequency() {
        while (true) {
            System.out.print("Enter income frequency (1 = weekly, 2 = biweekly): ");
            if (scanner.hasNextInt()) {
                int freq = scanner.nextInt();
                scanner.nextLine();
                if (freq == 1 || freq == 2) return freq;
                else System.out.println("Invalid frequency. Please enter 1 or 2.");
            } else {
                System.out.println("Invalid input! Please enter 1 or 2.");
                scanner.nextLine();
            }
        }
    }

    public void printSources(List<IncomeSource> sources) {
        if (sources.isEmpty()) {
            System.out.println("No income sources to show.");
        } else {
            System.out.println("\n--- Income Sources ---");
            for (IncomeSource source : sources) {
                System.out.printf("%s → $%.2f (Frequency: %s)%n",
                        source.getSource(),
                        source.getRawAmount(),
                        source.getFrequency() == 1 ? "Weekly" : "Biweekly");
            }
        }
    }

    public void printTotal(double total) {
        System.out.printf("\nTotal Income (monthly adjusted): $%.2f%n", total);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
