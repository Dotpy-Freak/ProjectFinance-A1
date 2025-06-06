package com.example.views;

import java.util.Scanner;

public class UserView {

    private Scanner scanner = new Scanner(System.in);

    public String getUserName() {
        System.out.print("Enter user name: ");
        return scanner.nextLine().trim();
    }

    public void showMainMenu(String userName) {
        System.out.printf("\n===== Main Menu for %s =====%n", userName);
        System.out.println("1. Manage Income");
        System.out.println("2. Manage Savings");
        System.out.println("3. Manage Investments");
        System.out.println("4. Manage Expenditures");
        System.out.println("5. Show Summary");
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

    public void printMessage(String message) {
        System.out.println(message);
    }
}
