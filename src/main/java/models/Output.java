package models;

public class Output {
    public void generateReport(Income income, Savings savings, Investment investment, Expenditure expenditure) {
        double totalIncome = income.getTotalIncome();
        double totalExpenses = expenditure.getTotalExpenses();
        double projectedReturns = investment.getProjectedReturn();
        double remaining = totalIncome - totalExpenses + projectedReturns;

        System.out.println("\n--- Financial Summary ---");
        System.out.println("Total Income: $" + totalIncome);
        System.out.println("Total Expenses: $" + totalExpenses);
        System.out.println("Projected Investment Returns: $" + projectedReturns);
        System.out.println("Savings Goal: $" + savings.getGoalAmount());
        System.out.println("Can Achieve Savings Goal: " + (savings.isGoalAchievable(remaining) ? "Yes" : "No"));
    }
}
