package com.company;

import java.util.ArrayList;

public class User {
    private final long id;
    private String firstName;
    private String lastName;
    private String password;
    private ArrayList<Account>  accounts = new ArrayList<>();

    public User(long id, String fName, String lName, String password){
        this.id = id;
        firstName = fName;
        lastName = lName;
        this.password = password;
    }

    /*
     * addAccount(Account account)
     * removeAccount(Account account)
     * deposit(Account account int amount)
     * withdrawal(Account account , int amount)
     * transfer(Account srcAccount, Account destAccount, int amount)
     * checkBalance(Account account)
     * printAllAvailableAccount()
     * printUserData()
    * */
}
