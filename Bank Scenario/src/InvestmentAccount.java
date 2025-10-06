public class InvestmentAccount extends Account implements MonthlyInterest, Withdraw {

    private final double InvsmtMonthlyInterestRate = 0.05;
    public InvestmentAccount(int AccountNumber, double Balance, String Branch) {
        super(AccountNumber, Balance, Branch);
    }

    public void AddMonthlyInterest() {
        Balance += Balance*InvsmtMonthlyInterestRate;
    }
    public void Withdraw(double Amount) {
        Balance -= Amount;
    }
}
