/*
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

package SEMIFINALS.SimpleBankAccountSystem;

public class BankAccount {
    private final int accountNumber;                //final para dili na ma modify ang accountnumber
    private final String accountName;               //final para dili sad ma modify ang name
    private double balance;                         //since ang balance ma change paman then dili sya final
    
    //default constructor
    public BankAccount(){
        this.accountNumber = 0;
        this.accountName = "default Name";
        this.balance = 0.0;
    }
        
    //method to deposit money to the account
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("\nInvalid deposit amount. Amount must be greater than 0.");
            return;
        }

        balance += amount;
        System.out.println("\nDeposited $" + amount + " into the account.");
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if(amount <= 0){
            System.out.println("\ninvalid withdrawal. Amount must be greater than 0.");
            return;
        }

        if(amount > balance){
            System.out.println("\nInsufficient balance.");
            return;
        }

        balance -= amount;
        System.out.println("\nWithdrawn $" + amount + " from the account.");
    }

    //method to display Balance
    public void displayBalance() {
        System.out.println("\nBalance: $" + balance);
    }

    //method to display details
    public String toString(){
        return "\nAccount Details" + 
                "\nAccount Number: " + accountNumber + 
                "\nAccount Holder's Name: " + accountName + 
                "\nBalance $: " + balance;
    }

    //main method to demonstrate usage
    public static void main(String[] args){
        //creating a bank account
        BankAccount b1 = new BankAccount();
        //using deposit method
        b1.deposit(50000.0);

        //using withdraw method
        b1.withdraw(1000.0);

        //using methods with invalid values
        b1.deposit(0);
        b1.withdraw(0);

        //using display balance method
        b1.displayBalance();
        
        //displaying account details
        System.out.println(b1.toString());
    }   
}
