package SEMIFINALS.BankAccountSystem;
import java.util.HashMap;

//this class stores all created Bank Accounts
public class BankDataBase {
    private HashMap<Integer, BankAccount> listOfAccounts;
    static int Bankbranch = 600; //for generating account number
    
    public BankDataBase(){
        this.listOfAccounts = new HashMap<>();
    }

    public boolean noAccounts(){
        return listOfAccounts.size() == 0;
    }

    //methods
    public BankAccount createAndAddAccount(String name, double balance){
        int accountNumber = generateAccountNumber();
        BankAccount b = new BankAccount(accountNumber, name, balance);
        listOfAccounts.put(accountNumber, b);
        System.out.println("\nSuccesfully created a bank account!");
        System.out.println("REMEMBER YOUR ACCOUNT NUMBER");
        System.out.println("--------------------------------------");
        System.out.println("Account number: " + accountNumber);
        System.out.println("Account Name: " + name);
        System.out.println("Initial Balance: " + balance);
        System.out.println("--------------------------------------");
        return b;
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
}
