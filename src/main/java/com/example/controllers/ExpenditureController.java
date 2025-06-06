package com.example.controllers;

import com.example.models.Expenditure;
import com.example.views.ExpenditureView;

public class ExpenditureController {

    private Expenditure model;
    private ExpenditureView view;

    public ExpenditureController(Expenditure model, ExpenditureView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean running = true;

        while (running) {
            view.showMenu();
            int choice = view.getUserChoice();

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    removeExpense();
                    break;
                case 3:
                    showExpenses();
                    break;
                case 4:
                    showTotalExpenses();
                    break;
                case 5:
                    clearExpenses();
                    break;
                case 6:
                    running = false;
                    view.printMessage("Exiting... Goodbye!");
                    break;
                default:
                    view.printMessage("Invalid choice! Please try again.");
            }
        }
    }

    private void addExpense() {
        String name = view.getExpenseName();
        double value = view.getExpenseValue();
        model.addExpense(name, value);
        view.printMessage("Expense added successfully!");
    }

    private void removeExpense() {
        String name = view.getExpenseName();
        boolean removed = model.removeExpense(name);
        if (removed) {
            view.printMessage("Expense removed successfully!");
        } else {
            view.printMessage("Expense not found.");
        }
    }

    private void showExpenses() {
        view.printExpenses(model.getExpenses());
    }

    private void showTotalExpenses() {
        double total = model.getTotalExpenses();
        view.printTotal(total);
    }

    private void clearExpenses() {
        model.clearExpenses();
        view.printMessage("All expenses cleared.");
    }
}
