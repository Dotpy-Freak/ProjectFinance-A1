package com.example.controllers;

import com.example.models.Savings;
import com.example.models.User;
import com.example.views.SavingsView;

public class SavingsController {

    private Savings model;
    private SavingsView view;
    private User user; // reference to User (for dynamic totalIncome)

    public SavingsController(Savings model, SavingsView view, User user) {
        this.model = model;
        this.view = view;
        this.user = user;
    }

    public void run() {
        boolean running = true;

        while (running) {
            view.showMenu();
            int choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    setGoalByAmount();
                    break;
                case 2:
                    setGoalByPercent();
                    break;
                case 3:
                    showGoalAmount();
                    break;
                case 4:
                    checkGoalAchievability();
                    break;
                case 5:
                    running = false;
                    view.printMessage("Exiting Savings Tracker... Goodbye!");
                    break;
                default:
                    view.printMessage("Invalid choice! Please try again.");
            }
        }
    }

    private void setGoalByAmount() {
        double amount = view.getGoalAmountInput();
        model.setGoalByAmount(amount);
        view.printMessage("Saving goal (fixed amount) set successfully!");
    }

    private void setGoalByPercent() {
        double percent = view.getGoalPercentInput();
        double currentTotalIncome = user.getIncome().getTotalIncome(); // Read dynamically here!
        model.setGoalByPercent(percent, currentTotalIncome);
        view.printMessage("Saving goal (percentage) set successfully!");
    }

    private void showGoalAmount() {
        view.printGoalAmount(model.getGoalAmount());
    }

    private void checkGoalAchievability() {
        double remaining = view.getRemainingAmount();
        boolean achievable = model.isGoalAchievable(remaining);
        view.printGoalAchievability(achievable);
    }
}
