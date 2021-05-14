package com.company;

import java.util.Date;
/**
 *simulates the reporting news channel for players news
 * @author mehranghaffarian
 * */
public class Match {
    private Date date;
    private String opponentName;

    public Match(Date date, String opponentName) {
        this.date = date;
        this.opponentName = opponentName;
    }
    /**
     * @return the match information as a String
     * */
    @Override
    public String toString() {return "Match date: " + date + ", opponent name: " + opponentName;}
}
