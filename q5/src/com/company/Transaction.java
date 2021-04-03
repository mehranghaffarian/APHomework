package com.company;

import java.util.Date;

public class Transaction {
    private int amount;
    private Date date = new Date();

    public Transaction(int amount){this.amount = amount;}

    public void print(){System.out.println("transaction data -> amount: " + amount + "date: " + date.toString());}
}