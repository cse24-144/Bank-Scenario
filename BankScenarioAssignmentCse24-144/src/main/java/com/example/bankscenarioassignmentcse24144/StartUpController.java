package com.example.bankscenarioassignmentcse24144;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StartUpController {
    public TabPane TabPaneLogin;
    public TabPane TabPaneCustomer;
    public TextField TxtFieldFirstName;
    public TextField TxtFieldSurname;
    public TextField TxtFieldPassword;
    public Button BtnLogin;
    public Label TxtStatus;
    public Button BtnLoginBankManager;
    public TabPane TabPaneBankManager;
    @FXML
    private Label LabelLogin;
    @FXML
    private Pane PaneLogin;
    @FXML
    public void BtnLoginClick() {
        TabPaneLogin.setVisible(false);
        TabPaneCustomer.setVisible(true);
        TxtStatus.setText("Customer Logged In");
    }
    public void BtnLoginBankManagerClick() {
        TabPaneLogin.setVisible(false);
        TabPaneBankManager.setVisible(true);
        TxtStatus.setText("Bank Manager Logged In");
    }
    public void initialize(){
        TabPaneLogin.setVisible(true);
    }

}