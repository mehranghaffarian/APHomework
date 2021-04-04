package com.company;

import java.util.Iterator;
import  java.util.Scanner;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        BankingSystem bank = new BankingSystem();
        User mehran = new User("9931042", "mehran", "ghaffarian", "12345678");

        bank.addAccount(new Account("Mehran", "Ghaffarian", "sepordeh", 125, "123"));
        bank.addUser(mehran);

        mehran.addAccount(new Account("Mehran", "Ghaffarian", "sepordeh", 125, "123"));
        mehran.addAccount(new Account("Mehran", "Ghaffarian", "sepordeh", 205, "124"));

        int choice = 1;

        while(choice != 4){
            System.out.println("to return to the main menu enter -1 anytime\n");
            System.out.println("1.sign up\n2.log in\n3.System Admin\n4.Exit");
            choice = scan.nextInt();

            if(choice == 1){
                    System.out.println("please enter the first name, last name, id and password respectively");

                    String fName = scan.next();
                    String lName = scan.next();
                    String id = scan.next();
                    String password = scan.next();

                    Iterator<User> it = bank.getUsers().iterator();
                    Boolean isSame = false;

                    if (!fName.equals("-1") && !lName.equals("-1") && !id.equals("-1") && !password.equals("-1")) {
                        while (it.hasNext()) {
                            User user = it.next();

                            if (user.getId().equals(id))
                                isSame = true;
                        }

                        if (isSame)
                            System.out.println("user already exists.");

                        else {
                            bank.getUsers().add(new User(fName, lName, id, password));

                            System.out.println("user created.");
                        }
                    }
            }
            else if (choice == 2){
                System.out.println("please enter the id and password respectively.");

                User user = new User("0", "0", "0", "0");

                String id = scan.next();
                String password = scan.next();

                if (!id.equals("-1") && !password.equals("-1")) {
                    Iterator<User> it = bank.getUsers().iterator();
                    Boolean isIn = false;

                    while (it.hasNext()) {
                        if(!isIn)
                        user = it.next();

                        else
                            it.next();

                        if (user.getId().equals(id))
                            if (user.getPassword().equals(password))
                                isIn = true;
                    }
                    if (!isIn)
                        System.out.println("user doesn't exists or password is incorrect");

                    else {
                        System.out.println("logged in.");

                        Boolean Back = false;

                        while(!Back) {
                            Back = true;
                            System.out.println("1.Existing accounts\n2.Add new account\n3.Log out");
                            choice = scan.nextInt();

                            if (choice == 1) {
                                Iterator<Account> itAccounts = user.getAccountList().iterator();
                                int index = 0;

                                while (itAccounts.hasNext()) {
                                    Account account = itAccounts.next();

                                    System.out.printf("Account %d: ", ++index);

                                    account.printAccountData();
                                }
                                index = scan.nextInt();

                                if (index != -1) {
                                    System.out.println("1.Withdrawal\n2.Deposit\n3.Transfer\n4.Check Balance\n5.Back");
                                    choice = scan.nextInt();

                                    Account account = user.getAccountList().get(index - 1);

                                    if (choice == 1) {
                                        System.out.println("please enter the amount of money to withdrawal.");
                                        int amount = scan.nextInt();

                                        if (account.getBalance() - amount >= 0) {
                                            account.addTransaction(new Transaction(-amount));
                                            account.updateBalance(-amount);
                                            System.out.println("Completed.");
                                        } else
                                            System.out.println("Not enough money.");
                                    } else if (choice == 2) {
                                        System.out.println("please enter the amount of money to deposit.");
                                        int amount = scan.nextInt();

                                        account.addTransaction(new Transaction(amount));
                                        account.updateBalance(amount);

                                        System.out.println("Completed.");
                                    } else if (choice == 3) {
                                        System.out.println("Enter the destination serial and the amount of the money respectively.");
                                        String serial = scan.nextLine();
                                        int amount = scan.nextInt();

                                        if (account.getBalance() - amount < 0)
                                            System.out.println("Destination account doesn’t exist or there is not enough money in your account.");

                                        else {
                                            Iterator<Account> allAccounts = bank.getAccounts().iterator();
                                            isIn = false;
                                            Account destAccount = new Account("0", "0", "0", 0, "0");

                                            while (allAccounts.hasNext()) {
                                                if (!isIn)
                                                    destAccount = allAccounts.next();

                                                else
                                                    allAccounts.next();

                                                if (destAccount.checkSerial(serial))
                                                    isIn = true;
                                            }
                                            if (!isIn)
                                                System.out.println("Destination account doesn’t exist or there is not enough money in your account.");

                                            else {
                                                destAccount.updateBalance(amount);
                                                destAccount.addTransaction(new Transaction(amount));

                                                account.updateBalance(-amount);
                                                account.addTransaction(new Transaction(-amount));

                                                System.out.println("Completed.");
                                            }
                                        }
                                    } else if (choice == 4) {
                                        System.out.println(account.getBalance());
                                    } else if (choice == 5) {
                                        System.out.println("Logged out of account.");
                                        Back = false;
                                    }
                                }
                            }

                            else if (choice == 2) {
//                                System.out.println("Enter User ID and Account type respectively.");
//                                id = scan.nextLine();
//                                String type = scan.nextLine();
//
//                                bank.addAccount(new Account(acc));
                            }
                            else if (choice != -1) {

                            }
                        }
                    }
                }
            } else if (choice == 3) {

            }
        }
    }
}