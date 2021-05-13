package com.company;

import java.util.ArrayList;

public class PlayerChannel extends NewsChannel{
    private Player player;

    public PlayerChannel(ArrayList<News> news, ArrayList<Follower> followers, Player player) {
        super(news, followers);
        this.player = player;
    }

    @Override
    public void showChannelGoal(){System.out.println("This channel is designed for " + player.getName() + " news.");}
}
