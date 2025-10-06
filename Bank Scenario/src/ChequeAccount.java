public class ChequeAccount extends Account implements Withdraw{

    public String CompanyName;
    public String CompanyAddress;
    public ChequeAccount(int AccountNumber, double Balance, String Branch, String CompanyName, String CompanyAddress) {
        super(AccountNumber, Balance, Branch);
        this.CompanyName = CompanyName;
        this.CompanyAddress = CompanyAddress;
    }

    public void Withdraw(double Amount) {
        Balance -= Amount;
    }
}
