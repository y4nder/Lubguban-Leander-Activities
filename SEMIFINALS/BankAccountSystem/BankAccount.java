/*
Author: Leander Lorenz Lubguban
Date created: October 31, 2023
Instructions: Create a Java program that models a bank account. 
You should have a Bank Account class with attributes for the account number, account holder's name, and balance. 
The class should include methods to deposit, withdraw, and display the balance.

Please write the Java code for the BankAccount class and demonstrate its usage in the main method.

[Class Bank Account]
Attributes:
- int accountNumber
- String accountName
- double balance

Methods:
- BankAccount (Default constructor)
- deposit 
-  withdraw
- displayBalance
*/

package SEMIFINALS.BankAccountSystem;

public class BankAccount {
    private final int accountNumber;                //final para dili na ma modify ang accountnumber
    private final String accountName;               //final para dili sad ma modify ang name
    private double balance;                         //since ang balance ma change paman then dili sya final
    
    //default constructor
    public BankAccount(int accountNumber, String accountName, double initialDeposit){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }

    //modified getter para dili ang original ma return
    public String getAccountName(){
        return new String(accountName);
    }
            
    //method to deposit money to the account
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Amount must be greater than 0.");
            return false;
        }

        balance += amount;
        System.out.println("Deposited $" + amount + " into the account.");
        return true;
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if(amount <= 0){
            System.out.println("invalid withdrawal. Amount must be greater than 0.");
            return false;
        }

        if(amount > balance){
            System.out.println("Insufficient balance.");
            return false;
        }

        balance -= amount;
        System.out.println("Withdrawn $" + amount + " from the account.");
        return true;
    }

    //method to display Balance
    public void displayBalance() {
        System.out.println("Balance: $" + balance);
    }

}
