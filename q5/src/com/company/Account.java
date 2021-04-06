package com.company;

import java.util.ArrayList;
import java.util.UUID;

public class Account {

    private String id;
    private final UUID serial = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String type;
    private int balance;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Account(String fName, String lName, String type, int balance, String id){
        firstName = fName;
        lastName = lName;
        this.type = type;
        this.balance = balance;
        this.id = id;
    }

    /**
     * @param amount used to update balance after transaction
     * */
    public void updateBalance(int amount){balance += amount;}

    /**
     * @param transaction for deposit, withdrawal and transfer
     * */
    public void addTransaction(Transaction transaction){transactions.add(transaction);}

    /**
     * demonstrates the Account Transaction
     * */
    public void printTransactions(){
        for(int i = 0;i < transactions.size();i++)
            transactions.get(i).print();
    }

    /**
     * demonstrates the Account Data
     * */
    public void printAccountData(){System.out.println("id: " + id + ", UUID: " + serial.toString() + ", Name: " + firstName + " " + lastName + ", type: " + type + ", balance: " + balance);}

    /**
     * @return true if the serial match with the account serial otherwise return false
     * */
    public boolean checkSerial(String serial){
        if(this.serial.toString().equals(serial))
            return true;

        return false;
    }

    public int getBalance(){return balance;}

    public String getSerial() {return serial.toString();}
}