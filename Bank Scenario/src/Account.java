public abstract class Account {
    public int AccountNumber;
    public double Balance;
    public String Branch;
    public Account(int AccountNumber, double balance, String branch){
        this.AccountNumber = AccountNumber;
        this.Balance = balance;
        this.Branch = branch;
    }
    public int getAccountNumber() {
        return AccountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }
    public double ViewBalance() {
        return Balance;
    }
    public void setBalance(double balance) {
        this.Balance = balance;
    }
    public String getBranch() {
        return Branch;
    }
    public void setBranch(String branch) {
        this.Branch = branch;
    }
    public void deposit(double amount){
        this.Balance += amount;
    }
}
