package com.company;

import java.util.ArrayList;
/**
 * simulating a club
 * @author mehranghaffarian
 * */
public class Club {
    private String name;
    private ArrayList<Match> matches;
    private ArrayList<Player> players;

    public Club(String name, ArrayList<Match> matches, ArrayList<Player> players) {
        this.name = name;
        this.matches = matches;
        this.players = players;
    }
    /**
     * displays the name of the club
     * */
    public void display(){System.out.print(name);}
}
