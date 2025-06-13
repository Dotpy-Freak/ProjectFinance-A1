package com.example.models;

public class Output {

    public void generateReport(Income income, Savings savings, Investment investment, Expenditure expenditure) {
        double totalIncome = income.getTotalIncome();
        double totalExpenses = expenditure.getTotalExpenses();
        double projectedReturns = investment.getProjectedReturn();
        double remaining = totalIncome - totalExpenses + projectedReturns;

        System.out.println("\n=====================================");
        System.out.println("         FINANCIAL SUMMARY REPORT");
        System.out.println("=====================================");

        System.out.printf("Total Income:                 $%.2f%n", totalIncome);
        System.out.printf("Total Expenses:               $%.2f%n", totalExpenses);
        System.out.printf("Projected Investment Returns: $%.2f%n", projectedReturns);
        System.out.printf("Remaining Available Amount:   $%.2f%n", remaining);

        System.out.println("-------------------------------------");

        System.out.printf("Savings Goal Amount:          $%.2f%n", savings.getGoalAmount());
        boolean canAchieve = savings.isGoalAchievable(remaining);
        System.out.println("Can Achieve Savings Goal:     " + (canAchieve ? "✅ YES" : "❌ NO"));

        System.out.println("=====================================\n");
    }
}
