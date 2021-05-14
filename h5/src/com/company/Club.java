package com.company;

import java.util.ArrayList;

public class Club {
    private String name;
    private ArrayList<Match> matches;
    private ArrayList<Player> players;

    public Club(String name, ArrayList<Match> matches, ArrayList<Player> players) {
        this.name = name;
        this.matches = matches;
        this.players = players;
    }

    public String getName(){return name;}
}
