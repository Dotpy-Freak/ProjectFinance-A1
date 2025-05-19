package com.example.models;

import com.example.InputScanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Income {
    private List<IncomeSource> sources = new ArrayList<>();

    public void initializeIncome(){
        Scanner scanner1 = InputScanner.getScanner();
        System.out.println("Enter job title:");
        String job = scanner1.nextLine();
        System.out.println("Enter amount:");
        Double amount = scanner1.nextDouble();
        scanner1.nextLine();
        /*System.out.println("Enter frequency:");
        String frequency = scanner1.nextLine();*/
        addSources(job, amount);
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
