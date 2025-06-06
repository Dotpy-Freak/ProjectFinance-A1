package com.example.models;

import java.util.ArrayList;
import java.util.List;

public class Investment {

    private List<InvestmentItem> investments = new ArrayList<>();

    public void addInvestment(String type, double amount, double rate) {
        investments.add(new InvestmentItem(type, amount, rate));
    }

    public boolean removeInvestment(String type) {
        return investments.removeIf(inv -> inv.getType().equalsIgnoreCase(type));
    }

    public void clearInvestments() {
        investments.clear();
    }

    public double getProjectedReturn() {
        return investments.stream()
                .mapToDouble(inv -> inv.getAmount() * (inv.getRate() / 1200.0))
                .sum();
    }

    public List<InvestmentItem> getInvestments() {
        return new ArrayList<>(investments);
    }

    public static class InvestmentItem {
        private String type;
        private double amount;
        private double rate;

        public InvestmentItem(String type, double amount, double rate) {
            this.type = type;
            this.amount = amount;
            this.rate = rate;
        }

        public String getType() {
            return type;
        }

        public double getAmount() {
            return amount;
        }

        public double getRate() {
            return rate;
        }

        @Override
        public String toString() {
            return String.format("InvestmentItem[type=%s, amount=%.2f, rate=%.2f%%]", type, amount, rate);
        }
    }
}
