public class Account {
    public int AccountNumber;
    public double Balance;
    public String Branch;
    public Customer Customer;
    public Account(int AccountNumber, double balance, String branch, Customer customer) {
        this.AccountNumber = AccountNumber;
        this.Balance = balance;
        this.Branch = branch;
        this.Customer = customer;
        this.Customer.NoOfAccounts += 1;
    }
    public int getAccountNumber() {
        return AccountNumber;
    }
    public void setAccountNumber(int accountNumber) {
        AccountNumber = accountNumber;
    }
    public double getBalance() {
        return Balance;
    }
    public void setBalance(double balance) {
        this.Balance = balance;
    }
    public void ViewBalance() {System.out.println(Balance);};
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
