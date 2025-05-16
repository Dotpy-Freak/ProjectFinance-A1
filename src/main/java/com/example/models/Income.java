package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Income {
    private List<IncomeSource> sources = new ArrayList<>();

    public void addSources(String Job, Double amount, String frequency) {
        sources.add(new IncomeSource(Job, amount, frequency));
    }
    public void addSources(String Job, Double amount) {
        sources.add(new IncomeSource(Job, amount, null));
    }

    public double getTotalIncome() {
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
    /*public static void main(String[] args) {


        Income in = new Income();
        System.out.println(in.getTotalIncome());
    }*/
}
