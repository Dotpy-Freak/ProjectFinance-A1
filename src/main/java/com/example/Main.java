package com.example;

import com.example.controllers.UserController;
import com.example.models.User;
import com.example.views.UserView;

public class Main {
    public static void main(String[] args) {

        // Welcome message
        System.out.println("=====================================");
        System.out.println("    Welcome to Personal Finance App");
        System.out.println("=====================================");

        // Create UserView
        UserView userView = new UserView();

        // Get user name from view
        String userName = userView.getUserName();

        // Create User model
        User user = new User(userName);

        // Create UserController and run the app
        UserController userController = new UserController(user, userView);
        userController.run();

        // Exit message
        System.out.println("=====================================");
        System.out.println("Thank you for using Personal Finance App!");
        System.out.println("Goodbye " + user.getName() + "!");
        System.out.println("=====================================");
    }
}
