package com.example.controllers;

import com.example.models.Investment;
import com.example.views.InvestmentView;

public class InvestmentController {

    private Investment model;
    private InvestmentView view;

    public InvestmentController(Investment model, InvestmentView view) {
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
                    addInvestment();
                    break;
                case 2:
                    removeInvestment();
                    break;
                case 3:
                    showInvestments();
                    break;
                case 4:
                    showProjectedReturn();
                    break;
                case 5:
                    clearInvestments();
                    break;
                case 6:
                    running = false;
                    view.printMessage("Exiting Investment Tracker... Goodbye!");
                    break;
                default:
                    view.printMessage("Invalid choice! Please try again.");
            }
        }
    }

    private void addInvestment() {
        String type = view.getInvestmentType();
        double amount = view.getInvestmentAmount();
        double rate = view.getInvestmentRate();

        model.addInvestment(type, amount, rate);
        view.printMessage("Investment added successfully!");
    }

    private void removeInvestment() {
        String type = view.getInvestmentType();
        boolean removed = model.removeInvestment(type);
        if (removed) {
            view.printMessage("Investment removed successfully!");
        } else {
            view.printMessage("Investment not found.");
        }
    }

    private void showInvestments() {
        view.printInvestments(model.getInvestments());
    }

    private void showProjectedReturn() {
        double total = model.getProjectedReturn();
        view.printProjectedReturn(total);
    }

    private void clearInvestments() {
        model.clearInvestments();
        view.printMessage("All investments cleared.");
    }
}
