package SEMIFINALS.BankAccountSystem;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount() {
        accountNumber = 0;
        accountName = "";
        balance = 0.0;
    }

    //getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    //setters
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    //method to deposit money to the account
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nDeposited $" + amount + " into the account.");
            return true;
        } else {
            System.out.println("\nInvalid deposit amount. Amount must be greater than 0.");
            return false;
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("\nWithdrawn $" + amount + " from the account.");
            return true;
        } else {
            System.out.println("\nInvalid withdrawal amount or insufficient balance.");
            return false;
        }
    }

    public void displayBalance() {
        System.out.println("Balance: $" + balance);
    }

    public void displayDetails(){
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Holder's Name: " + accountName);
        System.out.println("Balance: $" + balance);
        System.out.println();
    }
}
