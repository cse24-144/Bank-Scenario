package com.example.bankscenarioassignmentcse24144;

import java.util.ArrayList;

public class Customer {
    public String FirstName;
    public String SurName;
    public String Address;
    public int BankId;
    public int NoOfAccounts;
    public ArrayList<Account> Accounts = new ArrayList<Account>();
    private String Password;
    public Customer(String FirstName, String SurName, String Address, int BankId) {
        this.FirstName = FirstName;
        this.SurName = SurName;
        this.Address = Address;
        this.BankId = BankId;
    }
    public String getFirstName(){
        return FirstName;
    }
    public String getSurName(){
        return SurName;
    }
    public String getAddress(){
        return Address;
    }
    public int getBankId(){
        return BankId;
    }
    public int getNoOfAccounts(){return NoOfAccounts; }
    public ArrayList<Account> getAccounts() {return Accounts;}
    public String getPassword() {return Password;}

    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }
    public void setSurName(String SurName){
        this.SurName = SurName;
    }
    public void setAddress(String Address){
        this.Address = Address;
    }
    public void setBankId(int BankId){
        this.BankId = BankId;
    }
    public void setNoOfAccounts(int noOfAccounts) {this.NoOfAccounts = noOfAccounts;}
    public void setAccounts(ArrayList<Account> Accounts){this.Accounts = Accounts;}
    public void setPassword(String Password) {this.Password = Password;}



}
