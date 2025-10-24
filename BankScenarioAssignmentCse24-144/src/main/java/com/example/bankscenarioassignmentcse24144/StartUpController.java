package com.example.bankscenarioassignmentcse24144;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StartUpController {
    //All items
    public TabPane TabPaneLogin;
    public TabPane TabPaneCustomer;
    public TabPane TabPaneBankManager;
    public Label TxtStatus;
    public TextField TxtFieldFirstName;
    public TextField TxtFieldSurname;
    public TextField TxtFieldPassword;
    public TextField TxtFNameNewUser;
    public TextField TxtSNameNewUser;
    public TextField TxtPasswordNewUser;
    public TextField TxtAddressNewUser;
    public TextField TxtBankIdNewUser;
    public TextField TxtAccNumberNewAcc;
    public TextField TxtBalanceNewAcc;
    public TextField TxtBranchNewAcc;
    public TextField TxtCompanyNameNewAcc;
    public TextField TxtCompanyAddressNewAcc;
    public TextField TxtAccNumberInterest;
    public TextField TxtAccNumberDeleteAcc;
    public TextField TxtAccNumberDW;
    public TextField TxtBalanceDW;
    public Button BtnNewUser;
    public Button BtnNewAccSvgs;
    public Button BtnNewAccInvs;
    public Button BtnNewAccCheque;
    public Button BtnDeposit;
    public Button BtnWithdraw;
    public Button BtnLogin;
    public Button BtnDeleteAcc;
    public Button BtnApplyInterest;
    public Button BtnLogOut;
    public ListView<String> ListAllAccs;
    public ListView<String> ListCustomerAccounts;
    Customer CurrentCustomer;
    BankManager CurrentBankManager;
    Boolean AccountDeleted=false;

    @FXML
    private Label LabelLogin;
    @FXML
    private Pane PaneLogin;
    @FXML
    public void BtnLoginClick() {
        boolean AccountThere = false;
        //checking if bank manager
        if (TxtFieldFirstName.getText().isEmpty() || TxtFieldSurname.getText().isEmpty() || TxtFieldPassword.getText().isEmpty()){
            Error404();
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader("BankManager.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length == 3) {
                        if (TxtFieldFirstName.getText().equals(parts[0])&TxtFieldSurname.getText().equals(parts[1])&TxtFieldPassword.getText().equals(parts[2]) ){
                            TabPaneLogin.setVisible(false);
                            TabPaneBankManager.setVisible(true);
                            TxtStatus.setText(parts[0]+" Logged In");
                            TxtFieldFirstName.clear();
                            TxtFieldSurname.clear();
                            TxtFieldPassword.clear();
                            AccountThere = true;
                            CurrentBankManager = new BankManager(parts[0],parts[1],parts[2]);
                            loadAllAccsFromFile();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //checking if customer
            try (BufferedReader reader = new BufferedReader(new FileReader("Customer.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(";");
                    if (parts.length >= 5) {
                        if (TxtFieldFirstName.getText().equals(parts[0])&TxtFieldSurname.getText().equals(parts[1])&TxtFieldPassword.getText().equals(parts[2]) ){
                            TabPaneLogin.setVisible(false);
                            TabPaneCustomer.setVisible(true);
                            TxtStatus.setText(parts[0]+" Logged In");
                            TxtFieldFirstName.clear();
                            TxtFieldSurname.clear();
                            TxtFieldPassword.clear();
                            AccountThere = true;
                            CurrentCustomer = new Customer(parts[0],parts[1],parts[2],parts[3],Integer.parseInt(parts[4]));
                            loadAccountsFromFile();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (AccountThere == false) {
                Error67();
            }
        }
    }

    public void BtnNewUserClick() {
        if (TxtFNameNewUser.getText().isEmpty() || TxtSNameNewUser.getText().isEmpty() || TxtPasswordNewUser.getText().isEmpty()){
            Error404();
        } else {
            if(TxtAddressNewUser.getText().isEmpty() || TxtBankIdNewUser.getText().isEmpty()) {
                BankManager newBankManager = new BankManager(TxtFNameNewUser.getText(),TxtSNameNewUser.getText(),TxtPasswordNewUser.getText());
                String line = newBankManager.getFirstName()+";"+newBankManager.getSurName()+";"+newBankManager.getPassword();
                try (FileWriter writer = new FileWriter("BankManager.txt", true)) {
                    writer.write( line + System.lineSeparator());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("New Bank Manager Added");
                    alert.showAndWait();
                    TxtFNameNewUser.clear();
                    TxtSNameNewUser.clear();
                    TxtPasswordNewUser.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else{
                Customer newCustomer = new Customer(TxtFNameNewUser.getText(),TxtSNameNewUser.getText(),TxtPasswordNewUser.getText(),TxtAddressNewUser.getText(),Integer.parseInt(TxtBankIdNewUser.getText()));
                String line = newCustomer.getFirstName()+";"+newCustomer.getSurName()+";"+newCustomer.getPassword()+";"+newCustomer.getAddress()+";"+newCustomer.getBankId();
                try (FileWriter writer = new FileWriter("Customer.txt", true)) {
                    writer.write( line + System.lineSeparator());
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("New Customer Added");
                    alert.showAndWait();
                    TxtFNameNewUser.clear();
                    TxtSNameNewUser.clear();
                    TxtPasswordNewUser.clear();
                    TxtAddressNewUser.clear();
                    TxtBankIdNewUser.clear();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        {

        }
    }

    public void initialize(){
    }

    public void BtnNewAccSvgsClick(ActionEvent actionEvent) {
        if (TxtAccNumberNewAcc.getText().isEmpty() || TxtBalanceNewAcc.getText().isEmpty() || TxtBranchNewAcc.getText().isEmpty()){
            Error404();
        } else {
            SavingsAccount newSavingsAcc = new SavingsAccount(Integer.parseInt(TxtAccNumberNewAcc.getText()),Double.parseDouble(TxtBalanceNewAcc.getText()),TxtBranchNewAcc.getText(),CurrentCustomer);
            String line = newSavingsAcc.getAccountNumber()+";"+newSavingsAcc.getBalance()+";"+newSavingsAcc.getBranch()+";"+CurrentCustomer.getFirstName();
            try (FileWriter writer = new FileWriter("SavingsAcc.txt", true)) {
                writer.write( line + System.lineSeparator());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("New Savings Account Added");
                alert.showAndWait();
                TxtAccNumberNewAcc.clear();
                TxtBalanceNewAcc.clear();
                TxtBranchNewAcc.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadAccountsFromFile();
        }
    }

    public void BtnNewAccInvsClick(ActionEvent actionEvent) {
        if (TxtAccNumberNewAcc.getText().isEmpty() || TxtBalanceNewAcc.getText().isEmpty() || TxtBranchNewAcc.getText().isEmpty()){
            Error404();
        } else {
            InvestmentAccount newInvestmentAcc = new InvestmentAccount(Integer.parseInt(TxtAccNumberNewAcc.getText()),Double.parseDouble(TxtBalanceNewAcc.getText()),TxtBranchNewAcc.getText(),CurrentCustomer);
            String line = newInvestmentAcc.getAccountNumber()+";"+newInvestmentAcc.getBalance()+";"+newInvestmentAcc.getBranch()+";"+CurrentCustomer.getFirstName();
            try (FileWriter writer = new FileWriter("InvestmentAcc.txt", true)) {
                writer.write( line + System.lineSeparator());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("New Investment Account Added");
                alert.showAndWait();
                TxtAccNumberNewAcc.clear();
                TxtBalanceNewAcc.clear();
                TxtBranchNewAcc.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadAccountsFromFile();
        }
    }

    public void BtnNewAccChequeClick(ActionEvent actionEvent) {
        if (TxtAccNumberNewAcc.getText().isEmpty() || TxtBalanceNewAcc.getText().isEmpty() || TxtBranchNewAcc.getText().isEmpty() || TxtCompanyNameNewAcc.getText().isEmpty() || TxtCompanyAddressNewAcc.getText().isEmpty()){
            Error404();
        } else {
            ChequeAccount newChequeAcc = new ChequeAccount(Integer.parseInt(TxtAccNumberNewAcc.getText()),Double.parseDouble(TxtBalanceNewAcc.getText()),TxtBranchNewAcc.getText(),CurrentCustomer,TxtCompanyNameNewAcc.getText(),TxtCompanyAddressNewAcc.getText());
            String line = newChequeAcc.getAccountNumber()+";"+newChequeAcc.getBalance()+";"+newChequeAcc.getBranch()+";"+CurrentCustomer.getFirstName();
            try (FileWriter writer = new FileWriter("ChequeAcc.txt", true)) {
                writer.write( line + System.lineSeparator());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("New Cheque Account Added");
                alert.showAndWait();
                TxtAccNumberNewAcc.clear();
                TxtBalanceNewAcc.clear();
                TxtBranchNewAcc.clear();
                TxtCompanyNameNewAcc.clear();
                TxtCompanyAddressNewAcc.clear();
            } catch (IOException e) {
                e.printStackTrace();
            }
            loadAccountsFromFile();
        }
    }
        //incase i don't finish reminder logic is write everything except the account number's data then update and rewrite
    public void BtnDepositClick(ActionEvent actionEvent) {

    }

    public void BtnWithdrawClick(ActionEvent actionEvent) {

    }

    public void BtnDeleteAccClick(ActionEvent actionEvent) {
        if (TxtAccNumberDeleteAcc.getText().isEmpty()){
            Error404();
        }else{
            deleteAcc("InvestmentAcc.txt");
            deleteAcc("SavingsAcc.txt");
            deleteAcc("ChequeAcc.txt");
            if (AccountDeleted=true) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setHeaderText(null);
                alert.setContentText("Account:" + TxtAccNumberDeleteAcc.getText() + " was successfully deleted");
                alert.showAndWait();
                TxtAccNumberDeleteAcc.clear();
                AccountDeleted = false;
                loadAccountsFromFile();
            } else {
                Error67();
            }
        }
    }

    public void BtnApplyInterestClick(ActionEvent actionEvent) {

    }

    public void BtnLogOutClick(ActionEvent actionEvent) {
        TabPaneBankManager.setVisible(false);
        TabPaneCustomer.setVisible(false);
        TabPaneLogin.setVisible(true);
        TxtStatus.setText("Logged Out");
    }
    //methods being used alot
    public void Error404(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error404");
        alert.setHeaderText(null);
        alert.setContentText("Enter value(s) into all fields");
        alert.showAndWait();
    }
    public void Error67(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error67");
        alert.setHeaderText(null);
        alert.setContentText("Incorrect Values Entered");
        alert.showAndWait();
    }
    private void loadAccountsFromFile() {
        List<String> lines = new ArrayList<>();
        ArrayList<Account> CurrentAccounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("ChequeAcc.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    if (parts[3].equals(CurrentCustomer.getFirstName())) {
                        String display = String.format("Account Number:%s Balance:%s Branch:%s Account Type:Cheque",
                                parts[0], parts[1], parts[2]);
                        lines.add(display);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("InvestmentAcc.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    if (parts[3].equals(CurrentCustomer.getFirstName())) {
                        String display = String.format("Account Number:%s Balance:%s Branch:%s Account Type:Investment",
                                parts[0], parts[1], parts[2]);
                        lines.add(display);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("SavingsAcc.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    if (parts[3].equals(CurrentCustomer.getFirstName())) {
                        String display = String.format("Account Number:%s Balance:%s Branch:%s Account Type:Savings",
                                parts[0], parts[1], parts[2]);
                        lines.add(display);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ListCustomerAccounts.setItems(FXCollections.observableArrayList(lines));
    }
    private void loadAllAccsFromFile() {
        List<String> lines = new ArrayList<>();
        ArrayList<Account> CurrentAccounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("ChequeAcc.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                        String display = String.format("Account Number:%s Balance:%s Branch:%s Account Type:Cheque",
                                parts[0], parts[1], parts[2]);
                        lines.add(display);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("InvestmentAcc.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                        String display = String.format("Account Number:%s Balance:%s Branch:%s Account Type:Investment",
                                parts[0], parts[1], parts[2]);
                        lines.add(display);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("SavingsAcc.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                        String display = String.format("Account Number:%s Balance:%s Branch:%s Account Type:Savings",
                                parts[0], parts[1], parts[2]);
                        lines.add(display);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ListAllAccs.setItems(FXCollections.observableArrayList(lines));
    }
    public void deleteAcc(String filename){
        String line;
        ArrayList<String> lines = new ArrayList<>();
        int count=0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (TxtAccNumberDeleteAcc.getText().equals(parts[0])) {
                    AccountDeleted = true;
                } else {
                    lines.add(line);
                    count += 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(filename, false)) {
            for (String l:lines){
                writer.write(l + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}