package com.example;
import com.example.models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;
    @BeforeEach
    public void setup(){
         user = new User("Test");
    }

    @Test
    public void printName(){
        assertEquals("Test",user.getName());
    }

    @AfterEach
    public void cleanUp(){
        user = null;
    }

}
