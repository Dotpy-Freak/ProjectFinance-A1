package com.example;
import com.example.models.*;
import org.junit.jupiter.api.*;

import javax.annotation.processing.Generated;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;
    @BeforeAll
    public static void printInit(){
        System.out.println("Initializing and starting test");
    }

    @BeforeEach
    public void setup(){
         user = new User("Test");
    }

    @Test @DisplayName("printing name test")
    public void printName(){
        assertEquals("Test",user.getName());
    }

    @DisplayName("cleaning test")
    @AfterEach
    public void cleanUp(){
        user = null;
    }

    @AfterAll
    public static void finishedTest(){
        System.out.println("Finished all tests");
    }



}
