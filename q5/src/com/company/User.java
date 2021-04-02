package com.company;

import java.util.ArrayList;

public class User {
    private final long id;
    private String firstName;
    private String lastName;
    private String password;
    private ArrayList<Account>  accountList = new ArrayList<>();

    public User(long id, String fName, String lName, String password){
        this.id = id;
        firstName = fName;
        lastName = lName;
        this.password = password;
    }

    public void addAccount(Account account){accountList.add(account);}

    public void removeAccount(Account account){accountList.remove(account);}

    public void deposit(Account account, int amount){
        account.updateBalance(amount);
        account.addTransaction(new Transaction(amount));
    }

    public  void withdrawal(Account account , int amount){
        if(account.getBalance() - amount < 0)
            System.out.println("There is not enough money to withdrawal.");

 //       else if (accountList.)

        else {

        }
    }

    public void transfer(Account srcAccount, Account destAccount, int amount){
        if(srcAccount.getBalance() - amount < 0)
            System.out.println("There is not enough money to transfer.");

        else{

        }
    }
    /*
     *
     *
     * checkBalance(Account account)
     * printAllAvailableAccount()
     * printUserData()
    * */
}
