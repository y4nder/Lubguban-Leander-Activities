package SEMIFINALS.BankAccountSystem;

import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        BankDataBase bankDataBase = new BankDataBase();

        boolean exitFlag = false;
        while(!exitFlag){
            clear();
            System.out.println("-----JAVA BANKING SYSTEM-----");
            System.out.println("[1] log in to your bank account");
            System.out.println("[2] create a bank account");
            System.out.println("[0] exit");
            System.out.print("option: ");
            int choice = scan.nextInt();

            switch(choice){
                case 1: 
                    logIn(bankDataBase);
                    break;
                case 2:
                    bankAccountCreation(bankDataBase);
                    break;
                case 0:
                    exitFlag = true;
                    break;
                default:
                    System.out.println("invalid choice");
            }
        }

    }

    static void bankAccountCreation(BankDataBase bankDataBase){
        BankAccount newAcc = createBankAccount();
        clear();
        bankDataBase.addAccount(newAcc);
        while(true){
            System.out.print("Enter '1' to proceed: ");
            int x = scan.nextInt();
            if(x == 1){
                UserMenu(newAcc);
                break;
            }
        }
    }

    //log in method
    public static void logIn(BankDataBase bankDataBase){
        separate();
        int input;
        boolean exitFlag = false;
        BankAccount b;

        while(!exitFlag){
            System.out.println("[0] - cancel");
            System.out.print("Acccount number: ");
            input = scan.nextInt();

            if(input == 0){
                System.out.println("exiting...");
                exitFlag = true;
            }

            b = bankDataBase.geBankAccount(input);

            if(b != null){
                System.out.println("\nLogged In!");
                UserMenu(b);
                return;
            }
            else{
                System.out.println("account does not exist\n");
            }
        }
        return;
    }

    public static void UserMenu(BankAccount b){
        boolean exitFlag = false;
        while(!exitFlag){
            clear();
            separate();
            System.out.println("What would you like to do today " + b.getAccountName());
            System.out.println("[1] deposit");
            System.out.println("[2] withdraw");
            System.out.println("[3] display Balance");
            System.out.println("[0] logOut");
            System.out.print("option: ");

            int choice;
            choice = scan.nextInt();
    
            switch (choice) {
                case 1:
                    depositToAccount(b, "Enter amount to deposit: ");
                    break;
                case 2:
                    withdrawFromAccount(b);
                    break;
                case 3:
                    displayBalance(b);
                    break;
                case 0:
                    exitFlag = true;
                    break;
                default:
                    System.out.println("invalid choice");
            }
            if(!exitFlag)
                exitFlag = doAnotherTransaction();
        }
        return;
    }

    //helper methods
    static boolean doAnotherTransaction(){
        separate();
        while(true){
            System.out.println("Would you like to do another transaction?");
            System.out.println("[1] yes");
            System.out.println("[2] no");
            System.out.print("option: ");

            int option = scan.nextInt();
            if(option == 1){
                return false;
            }
            else if(option == 2){
                return true;
            }
            else System.out.println("invalid choice");

        }
    }

    //deposit method
    static void depositToAccount(BankAccount b, String instructions){
        separate();
        boolean flag = false;
        while(!flag){
            System.out.print(instructions);
            double amount = scan.nextDouble();
            flag = b.deposit(amount);
        }
    }

    //withdraw account
    static void withdrawFromAccount(BankAccount b){
        separate();
        boolean flag = false;
        while(!flag){
            System.out.println("Enter amount to withdraw");
            double amount = scan.nextDouble();
            flag = b.withdraw(amount);
        }
    }

    //display account
    static void displayBalance(BankAccount b){
        separate();
        b.displayBalance();
    }

    //create a bank account method
    static BankAccount createBankAccount(){
        clear();
        separate();
        BankAccount b = new BankAccount();
        scan.nextLine();

        System.out.println("Creating bank account details");
        
        System.out.print("Enter your full name: ");
        b.setAccountName(scan.nextLine());
        
        depositToAccount(b, "Enter initial deposit: ");
        
        return b;
    }

    static void clear(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void separate(){
        System.out.println("-----------------------------------");
    }

}