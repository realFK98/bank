package bankingapplication2;

public class Account {
    private int accountNumber;
    private String accountName;
    private double balance;
    
    public Account(int accountNumber,String accountName,double balance){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount){
        this.balance += amount;
    }
    public void Withdraw(double amount){
        this.balance -= amount;

    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }
  
}
