public class SavingsAccount extends Account implements MonthlyInterest {

    private final double SvgsMonthlyInterestRate = 0.0005;
    public SavingsAccount(int AccountNumber, double Balance, String Branch) {
        super(AccountNumber, Balance, Branch);
    }

    public void AddMonthlyInterest() {
        Balance += Balance*SvgsMonthlyInterestRate;
    }
}
