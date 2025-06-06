package com.example.models;

public class User {

    private String name;
    private int Id;
    private static int lastId = 999;

    private Income income;
    private Savings savings;
    private Investment investment;
    private Expenditure expenditure;
    private Output output;

    public User(String name) {
        this.name = name;
        this.Id = getNextId();
        this.income = new Income();
        this.savings = new Savings();
        this.investment = new Investment();
        this.expenditure = new Expenditure();
        this.output = new Output();
    }

    public Income getIncome() {
        return income;
    }

    public Savings getSavings() {
        return savings;
    }

    public Investment getInvestment() {
        return investment;
    }

    public Expenditure getExpenditure() {
        return expenditure;
    }

    public Output getOutput() {
        return output;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return Id;
    }

    public void changeName(String name) {
        if (this.name == null) {
            this.name = name;
        }
    }

    public boolean equals(User user) {
        return this.name.equals(user.name) && this.Id == user.Id;
    }

    public String toString() {
        return "Name: " + name + "\n" + "ID: " + Id + "\n";
    }

    private static int getNextId() {
        return ++lastId;
    }
}
