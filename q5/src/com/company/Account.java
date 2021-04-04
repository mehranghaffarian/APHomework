package com.company;

import java.util.ArrayList;
import java.util.UUID;

public class Account {

    private String id;
    private UUID serial = UUID.randomUUID();
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

    public void updateBalance(int amount){balance += amount;}

    public void addTransaction(Transaction transaction){transactions.add(transaction);}

    public void printTransactions(){
        for(int i = 0;i < transactions.size();i++)
            transactions.get(i).print();
    }

    public void printAccountData(){System.out.println("id: " + id + ", UUID: " + serial.toString() + ", Name: " + firstName + " " + lastName + ", type: " + type + ", balance: " + balance);}

    public int getBalance(){return balance;}

    public boolean checkSerial(String serial){
        if(this.serial.toString().equals(serial))
            return true;

        return false;
    }
}