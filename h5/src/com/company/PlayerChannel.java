package com.company;

import java.util.ArrayList;

public class PlayerChannel extends NewsChannel{
    private ArrayList<Player> players;

    public PlayerChannel(ArrayList<News> news, ArrayList<Follower> followers, ArrayList<Player> players) {
        super(news, followers);
        this.players = players;
    }

    @Override
    public void showChannelGoal(){System.out.println("Player channel is designed for following players news.\n" + players + "\n");}
}
