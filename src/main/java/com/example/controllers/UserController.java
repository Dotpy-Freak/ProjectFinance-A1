package com.example.controllers;

import com.example.models.User;
import com.example.views.UserView;
import com.example.views.IncomeView;
import com.example.views.SavingsView;
import com.example.views.InvestmentView;
import com.example.views.ExpenditureView;

public class UserController {

    private User user;
    private UserView userView;

    private IncomeController incomeController;
    private SavingsController savingsController;
    private InvestmentController investmentController;
    private ExpenditureController expenditureController;

    public UserController(User user, UserView userView) {
        this.user = user;
        this.userView = userView;

        // Create sub-controllers for each module → SavingsController gets User!
        incomeController = new IncomeController(user.getIncome(), new IncomeView());
        savingsController = new SavingsController(user.getSavings(), new SavingsView(), user);
        investmentController = new InvestmentController(user.getInvestment(), new InvestmentView());
        expenditureController = new ExpenditureController(user.getExpenditure(), new ExpenditureView());
    }

    public void run() {
        boolean running = true;

        while (running) {
            userView.showMainMenu(user.getName());
            int choice = userView.getUserChoice();

            switch (choice) {
                case 1:
                    incomeController.run();
                    // No need to recreate savingsController anymore!
                    break;
                case 2:
                    savingsController.run();
                    break;
                case 3:
                    investmentController.run();
                    break;
                case 4:
                    expenditureController.run();
                    break;
                case 5:
                    user.getOutput().generateReport(user.getIncome(), user.getSavings(), user.getInvestment(), user.getExpenditure());
                    break;
                case 6:
                    running = false;
                    userView.printMessage("Goodbye " + user.getName() + "!");
                    break;
                default:
                    userView.printMessage("Invalid choice! Please try again.");
            }
        }
    }
}
