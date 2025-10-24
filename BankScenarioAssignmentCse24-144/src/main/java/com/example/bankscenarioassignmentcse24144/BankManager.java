package com.example.bankscenarioassignmentcse24144;

public class BankManager {
    public String FirstName;
    public String SurName;
    private String Password;
// meant to add interest to accounts
    public BankManager(String FirstName, String SurName, String Password) {
        this.FirstName = FirstName;
        this.SurName = SurName;
        this.Password = Password;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getSurName() {
        return SurName;
    }
    public void setSurName(String surName) {
        SurName = surName;
    }
    public String getPassword() {
        return Password;
    }
    public void setPassword(int password) {
        this.Password = Password;
    }
}
