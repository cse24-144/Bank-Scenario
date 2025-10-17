package com.example.bankscenarioassignmentcse24144;

public class ChequeAccount extends Account implements Withdraw{

    public String CompanyName;
    public String CompanyAddress;
    public ChequeAccount(int AccountNumber, double Balance, String Branch, Customer Customer, String CompanyName, String CompanyAddress) {
        super(AccountNumber, Balance, Branch, Customer);
        this.CompanyName = CompanyName;
        this.CompanyAddress = CompanyAddress;
    }

    public void Withdraw(double Amount) {
        Balance -= Amount;
    }
}
