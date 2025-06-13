package com.example.views;

import java.util.List;
import java.util.Scanner;
import com.example.models.Investment.InvestmentItem;

public class InvestmentView {

    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n===== Investment Menu =====");
        System.out.println("1. Add investment");
        System.out.println("2. Remove investment");
        System.out.println("3. Show all investments");
        System.out.println("4. Show projected return");
        System.out.println("5. Clear all investments");
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

    public String getInvestmentType() {
        System.out.print("Enter investment type: ");
        return scanner.nextLine().trim();
    }

    public double getInvestmentAmount() {
        while (true) {
            System.out.print("Enter investment amount: ");
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

    public double getInvestmentRate() {
        while (true) {
            System.out.print("Enter investment rate (annual %, e.g. 5 for 5%): ");
            if (scanner.hasNextDouble()) {
                double rate = scanner.nextDouble();
                scanner.nextLine();
                return rate;
            } else {
                System.out.println("Invalid value! Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    public void printInvestments(List<InvestmentItem> investments) {
        if (investments.isEmpty()) {
            System.out.println("No investments to show.");
        } else {
            System.out.println("\n--- Investments ---");
            for (InvestmentItem item : investments) {
                System.out.println(item.toString());
            }
        }
    }

    public void printProjectedReturn(double total) {
        System.out.printf("\nProjected Monthly Return: $%.2f%n", total);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
