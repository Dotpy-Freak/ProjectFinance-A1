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
        int frequency = 0;
        boolean valid = false;
        while (!valid) {
            try {
                System.out.println("Enter job title:");
                job = scanner1.nextLine();
                /*if (!InputManager.validateStringOnly(job)) continue;*/


                if (job.trim().isEmpty()) {
                    System.out.println("Job title can't be empty. Please try again.");
                    continue;
                }

                System.out.println("Enter the amount you earn:");
                amount = scanner1.nextDouble();
                scanner1.nextLine(); // To clear the Buffer
                if (amount <= 0) {
                    System.out.println("Invalid amount. Please enter a positive number.");
                    continue;
                }

                System.out.println("Enter the frequency of the income you earn(1:weekly, 2:biweekly:");
                frequency = scanner1.nextInt();
                scanner1.nextLine(); // To clear the Buffer
                if (frequency<1 || frequency>2) {
                    System.out.println("Invalid number of frequency. Please enter a valid number (1/2).");
                    continue;
                }

                valid = true;
            } catch (InputMismatchException e) {
                scanner1.nextLine(); // To clear the Buffer
                System.out.println("Invalid input. Please enter valid data. Text for job title and number for amount.");
            }

            if (valid) {
                addSources(job, amount,frequency);
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

    public void addSources(String Job, Double amount, int frequency) {

        sources.add(new IncomeSource(Job, amount,frequency));
    }
    public void addSources(String Job, Double amount) {
        sources.add(new IncomeSource(Job, amount, 1));
    }

    public double getTotalIncome() {
         //initializeIncome();
        return sources.stream().mapToDouble(IncomeSource::getAmount).sum();
    }

    private static class IncomeSource {
        String source;
        double amount;
        int frequency;

        public IncomeSource(String source, double amount, int frequency) {
            this.source = source;
            this.amount = amount;
            this.frequency = frequency;
        }

        public double getAmount() {

            return amount * 4/frequency;
        }


    }
    public static void main(String[] args){
        Income income = new Income();
        income.getTotalIncome();
    }

}
