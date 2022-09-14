package com.example.src;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This is the main class called HelloApplication
 */
public class HelloApplication extends Application {
    /**
     * This function sets the stage and calls other functions to produce effects
     * @param stage is a variable of the Stage data type.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Disco");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args This is the main function, and it is a standard function used to run code.
     */
    public static void main(String[] args) {
        launch();
    }
}