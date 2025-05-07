package com.example;

import com.example.models.User;

public class Main {
    public static void main(String[] args) {
        User user = new User("Sample User");

        user.collectIncome();
        user.collectSavings();
        user.collectInvestments();
        user.collectExpenditures();
        user.showSummary();
    }
}
