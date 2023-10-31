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
    private int accountNumber;
    private String accountName;
    private double balance;
    
    //default constructor
    
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

    //no setter for balance variable, the deposit method will be used
        
    //method to deposit money to the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("\nDeposited $" + amount + " into the account.");
        } else {
            System.out.println("\nInvalid deposit amount. Amount must be greater than 0.");
        }
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

    public static void main(String[] args){
        //creating a bank account
        BankAccount b1 = new BankAccount();

        //assigning account number
        b1.setAccountNumber(696969);

        //assigning account name
        b1.setAccountName("Leander Lorenz Lubguban");

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
