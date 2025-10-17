package com.example.bankscenarioassignmentcse24144;

public class SavingsAccount extends Account implements MonthlyInterest {

    public SavingsAccount(int AccountNumber, double Balance, String Branch, Customer Customer) {
        super(AccountNumber, Balance, Branch, Customer);
    }

    public void AddMonthlyInterest() {
        double svgsMonthlyInterestRate = 0.0005; //0.05%
        Balance += Balance* svgsMonthlyInterestRate;
    }
}
