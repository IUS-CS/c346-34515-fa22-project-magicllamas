package com.example.src;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class HelloApplicationTest {

    /**
     * This is a test case for the setUp function
     */
    @BeforeEach
    void setUp() {
        System.out.println("I am a method in HelloApplication.java");

    }

    /**
     * This is a test case for the start() function.
     */
    @Test
    void start() {
        System.out.println("This is a test for a test");
    }
}