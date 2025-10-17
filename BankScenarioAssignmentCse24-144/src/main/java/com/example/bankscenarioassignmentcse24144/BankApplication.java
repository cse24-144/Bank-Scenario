package com.example.bankscenarioassignmentcse24144;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BankApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BankApplication.class.getResource("BankView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 670, 360);
        stage.setTitle("Bank System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}