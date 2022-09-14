package com.example.src;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * This is a class called HelloController
 */
public class HelloController {
    @FXML
    private Label welcomeText;

    /**
     * This is a void method that drives the button on the popup application.
     */
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("What's your name?");
    }
}