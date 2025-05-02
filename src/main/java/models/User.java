package models;

public class User {

    // Variables to store the user's name and ID'
    private String name;
    private int Id;
    private static int lastId = 999; // the first user's id starts from 1000


    private Income income;
    private Savings savings;
    private Investment investment;
    private Expenditure expenditure;
    private Output output;

    public User(String name) {
        this.name = name;
        this.income = new Income();
        this.savings = new Savings();
        this.investment = new Investment();

        this.expenditure = new Expenditure();
        this.output = new Output();
        }

        public void collectIncome() {
            income.addSources();
        }

        public void collectSavings() {
            savings.setGoal(income.getTotalIncome());
        }

        public void collectInvestments() {
            investment.addInvestments();
        }

        public void collectExpenditures() {
            expenditure.addExpenses();
        }

        public void showSummary() {
            output.generateReport(income, savings, investment, expenditure);
        }



    // To register a user
    public void registerUser(String name){
        this.name = name;
        this.Id = getNextId(); // Auto-increment the last user's id
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return Id;
    }

    public void changeName(String name){
        if (this.name == null){
            this.name = name;
        }

    }

    public boolean equals(User user){
        return this.name.equals(user.name) && this.Id == user.Id;
    }


    public String toString(){
        return "Name: " + name + "\n"+ " ID: " + Id+"\n";
    }

    private static int getNextId(){
        return lastId++;
    }

}
