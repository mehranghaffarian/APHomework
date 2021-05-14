package com.company;

import java.util.Date;

public class Match {
    private Date date;
    private String opponentName;

    public Match(Date date, String opponentName) {
        this.date = date;
        this.opponentName = opponentName;
    }

    public void display(){System.out.println("Match date: " + date + ", opponent name: " + opponentName);}
}
