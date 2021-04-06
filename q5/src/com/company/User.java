package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class User {
    private final String id;
    private String firstName;
    private String lastName;
    private String password;
    private ArrayList<Account>  accountList = new ArrayList<>();

    public User(String id, String fName, String lName, String password){
        this.id = id;
        firstName = fName;
        lastName = lName;
        this.password = password;
    }

    public void addAccount(Account account){accountList.add(account);}

    public void removeAccount(String serial){
        Iterator<Account> accounts = accountList.iterator();

        while (accounts.hasNext()){
            Account account = accounts.next();

            if(account.checkSerial(serial))
                accountList.remove(account);
        }
    }

    public void deposit(Account account, int amount){
        account.updateBalance(amount);
        account.addTransaction(new Transaction(amount));
    }

    public  void withdrawal(Account account , int amount){
        if (!accountList.contains(account))
            System.out.println("The account does not belong to you.");

        else if(account.getBalance() - amount < 0)
            System.out.println("There is not enough money to withdrawal.");

        else {
            account.addTransaction(new Transaction(-amount));
            account.updateBalance(-amount);

            System.out.println("Completed.");
        }
    }

    public void transfer(Account srcAccount, Account destAccount, int amount){
        if(!accountList.contains(srcAccount))
            System.out.println("the account does not belong to you.");

        else if(srcAccount.getBalance() - amount < 0)
            System.out.println("There is not enough money to transfer.");

        else{
            srcAccount.addTransaction(new Transaction(-amount));
            srcAccount.updateBalance(-amount);

            destAccount.updateBalance(amount);
            destAccount.addTransaction(new Transaction(amount));

            System.out.println("Completed.");
        }
    }

    public void checkBalance(Account account) {System.out.println("balance: " + account.getBalance());}

    public void printAllAvailableAccount(){
        for (int i = 0;i < accountList.size();i++){
            System.out.printf("Account %d: ", 1 + i);
            accountList.get(i).printAccountData();
        }
    }

    public void printUserData(){System.out.println("id: " + id + ", Name: " + firstName + " " + lastName + ", password: " + password + ", Number of accounts: " + accountList.size());}

    public Boolean notBack(){
        if(firstName.equals("-1") || lastName.equals("-1") || id.equals("-1") || password.equals("-1"))
            return false;

        return true;
    }

    public String getId(){return id;}

    public String getPassword(){return password;}

    public ArrayList<Account> getAccountList(){return accountList;}

    public String getFirstName(){return firstName;}

    public String getlastName(){return lastName;}
}