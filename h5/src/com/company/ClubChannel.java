package com.company;

import java.util.ArrayList;

public class ClubChannel extends NewsChannel{
    private Club club;

    public ClubChannel(ArrayList<News> news, ArrayList<Follower> followers, Club club) {
        super(news, followers);
        this.club = club;
    }

    @Override
    public void showChannelGoal() {System.out.println("Club channel is designed for " + club.getName() + " news.\n");}
}
