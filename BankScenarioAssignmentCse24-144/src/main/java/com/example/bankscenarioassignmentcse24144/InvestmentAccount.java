package com.example.bankscenarioassignmentcse24144;

public class InvestmentAccount extends Account implements MonthlyInterest, Withdraw {

    public InvestmentAccount(int AccountNumber, double Balance, String Branch, Customer Customer) {
            super(AccountNumber, Balance, Branch, Customer);
    }

    public void AddMonthlyInterest() {
        double invsmtMonthlyInterestRate = 0.05; //5%
        Balance += Balance* invsmtMonthlyInterestRate;
    }
    public void Withdraw(double Amount) {
        Balance -= Amount;
    }
}
