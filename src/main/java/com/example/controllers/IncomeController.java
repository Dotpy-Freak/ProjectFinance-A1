package com.example.controllers;

import com.example.models.Income;
import com.example.views.IncomeView;

public class IncomeController {

    private Income model;
    private IncomeView view;

    public IncomeController(Income model, IncomeView view) {
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
                    addIncomeSource();
                    break;
                case 2:
                    removeIncomeSource();
                    break;
                case 3:
                    showIncomeSources();
                    break;
                case 4:
                    showTotalIncome();
                    break;
                case 5:
                    clearIncomeSources();
                    break;
                case 6:
                    running = false;
                    view.printMessage("Exiting Income Tracker... Goodbye!");
                    break;
                default:
                    view.printMessage("Invalid choice! Please try again.");
            }
        }
    }

    private void addIncomeSource() {
        String name = view.getIncomeSourceName();
        double amount = view.getIncomeAmount();
        int freq = view.getIncomeFrequency();

        model.addSource(name, amount, freq);
        view.printMessage("Income source added successfully!");
    }

    private void removeIncomeSource() {
        String name = view.getIncomeSourceName();
        boolean removed = model.removeSource(name);
        if (removed) {
            view.printMessage("Income source removed successfully!");
        } else {
            view.printMessage("Income source not found.");
        }
    }

    private void showIncomeSources() {
        view.printSources(model.getSources());
    }

    private void showTotalIncome() {
        double total = model.getTotalIncome();
        view.printTotal(total);
    }

    private void clearIncomeSources() {
        model.clearSources();
        view.printMessage("All income sources cleared.");
    }
}
