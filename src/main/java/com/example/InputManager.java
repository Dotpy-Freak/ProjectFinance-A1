package com.example;

import java.util.Scanner;



public class InputManager {
    private static Scanner scanner = new Scanner(System.in); //single scanner used throughout all classes!

public static Scanner getScanner(){
    return scanner;
}
public static boolean validateStringOnly(String string){
    return string.matches("[a-zA-Z]+");
}
public static boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$");
    }
public <T> boolean validate(T data) {
    String str = String.valueOf(data);
    if (data instanceof Integer) {
        return str.matches("-?\\d+");
    } else if (data instanceof Double) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    return false;
    }

}
