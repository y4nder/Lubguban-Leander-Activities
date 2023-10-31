package SEMIFINALS.BankAccountSystem;

import java.util.HashMap;

public class BankDataBase {
    private HashMap<Integer, BankAccount> listOfAccounts;
    static int Bankbranch = 600;
    
    public BankDataBase(){
        this.listOfAccounts = new HashMap<>();
    }

    public boolean noAccounts(){
        return listOfAccounts.size() == 0;
    }

    //methods
    public void addAccount(BankAccount b){
        int accountNumber = generateAccountNumber();
        b.setAccountNumber(accountNumber);
        listOfAccounts.put(accountNumber, b);
        displayAddedAccount(b);
    }

    private int generateAccountNumber(){
        int accountNumber = Bankbranch;
        accountNumber *= 1000;
        accountNumber += listOfAccounts.size();
        return accountNumber;
    }

    private boolean accountExists(int accountNumber){
        return listOfAccounts.containsKey(accountNumber);
    }

    public BankAccount geBankAccount(int accountNumber){
        if(accountExists(accountNumber)){
            return listOfAccounts.get(accountNumber);
        }
        else{
            return null;
        }
    }

    private void displayAddedAccount(BankAccount b){
        System.out.println("\nSuccesfully created a bank account!");
        System.out.println("REMEMBER YOUR ACCOUNT NUMBER");
        System.out.println("--------------------------------------");
        b.displayDetails();
        System.out.println("--------------------------------------");
    }
}
