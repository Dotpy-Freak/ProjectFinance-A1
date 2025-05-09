package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Investment {
    private List<InvestmentItem> investments = new ArrayList<>();

    public void addInvestments() {
        investments.add(new InvestmentItem("Stocks", 500, 7.0));
    }

    public double getProjectedReturn() {
        return investments.stream()
                .mapToDouble(inv -> inv.amount * (inv.rate / 100.0))
                .sum();
    }

    private static class InvestmentItem {
        String type;
        double amount;
        double rate;

        public InvestmentItem(String type, double amount, double rate) {
            this.type = type;
            this.amount = amount;
            this.rate = rate;
        }
    }
}
