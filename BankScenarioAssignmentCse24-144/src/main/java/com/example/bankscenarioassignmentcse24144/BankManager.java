package com.example.bankscenarioassignmentcse24144;

public class BankManager {
    public String FirstName;
    public String SurName;
    private int password;
// meant to add interest to accounts
    public BankManager(String FirstName, String SurName, int password) {
        this.FirstName = FirstName;
        this.SurName = SurName;
        this.password = password;
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
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
}
