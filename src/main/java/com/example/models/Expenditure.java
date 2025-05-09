package com.example.models;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Expenditure {
    private Map<String, Double> expenses = new HashMap<>();

    public void addExpenses() {
        Scanner scanner = new Scanner(System.in);
        char choice = '\0';
        do {
            System.out.println("You want to add any expenditure thing (Y/N)? Press 'N' to stop!");
            choice = scanner.next().toUpperCase().charAt(0);
            scanner.nextLine();
        }
        while (Character.isAlphabetic(choice)||choice!='N');
        expenses.put("Rent", 1000.0);
        expenses.put("Food", 300.0);
        expenses.put("Transport", 150.0);
    }

    public double getTotalExpenses() {
        return expenses.values().stream().mapToDouble(Double::doubleValue).sum();
    }
}
