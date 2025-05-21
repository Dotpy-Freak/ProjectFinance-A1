package com.example.models;

import com.example.InputManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Income {
    private List<IncomeSource> sources = new ArrayList<>();

    public void initializeIncome(){
        Scanner scanner1 = InputManager.getScanner();
        String job = "";
        Double amount = 0.0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println("Enter job title:");
                job = scanner1.nextLine();
                if (!InputManager.validateStringOnly(job)) continue;


                if (job.trim().isEmpty()) {
                    System.out.println("Job title can't be empty. Please try again.");
                    continue;
                }

                System.out.println("Enter amount:");
                amount = scanner1.nextDouble();
                scanner1.nextLine(); // To clear the Buffer
                if (amount <= 0) {
                    System.out.println("Invalid amount. Please enter a positive number.");
                    continue;
                }

                valid = true;
            } catch (InputMismatchException e) {
                scanner1.nextLine(); // To clear the Buffer
                System.out.println("Invalid input. Please enter valid data. Text for job title and number for amount.");
            }

            if (valid) {
                addSources(job, amount);
                valid = false; // Reset for next entry
                System.out.println("Do you want to add more income sources? Press Y for Yes and N for No.");
                String response = scanner1.nextLine().trim().toUpperCase();

                if (response.equals("N")) {
                    // user wants to exit
                    break;
                } else if (!response.equals("Y")) {
                    System.out.println("Invalid response. Assuming you want to add more income sources.");
                }
            }
        }
        //scanner1.close();
    }

    public void addSources(String Job, Double amount, String frequency) {
        sources.add(new IncomeSource(Job, amount, frequency));
    }
    public void addSources(String Job, Double amount) {
        sources.add(new IncomeSource(Job, amount, null));
    }

    public double getTotalIncome() {
         //initializeIncome();
        return sources.stream().mapToDouble(IncomeSource::getAmount).sum();
    }

    private static class IncomeSource {
        String source;
        double amount;
        String frequency;

        public IncomeSource(String source, double amount, String frequency) {
            this.source = source;
            this.amount = amount;
            this.frequency = frequency;
        }

        public double getAmount() {
            return amount;
        }


    }
    public static void main(String[] args){
        Income income = new Income();
        income.getTotalIncome();
    }

}
