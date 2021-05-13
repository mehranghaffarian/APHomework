package com.company;

import java.util.ArrayList;

public class MatchesChannel extends NewsChannel {
    private ArrayList<Match> matches;

    public MatchesChannel(ArrayList<News> news, ArrayList<Follower> followers, ArrayList<Match> matches) {
        super(news, followers);
        this.matches = matches;
    }

    @Override
    public void showChannelGoal(){System.out.println("This channel is designed for matches news.");}
}
