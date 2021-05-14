package com.company;

import java.util.ArrayList;
/**
 *simulates the reporting news channel for matches news
 * @author mehranghaffarian
 * */
public class MatchesChannel extends NewsChannel {
    private ArrayList<Match> matches;

    public MatchesChannel(ArrayList<News> news, ArrayList<Follower> followers, ArrayList<Match> matches) {
        super(news, followers);
        this.matches = matches;
    }
    /**
     *displays the aim of the channel
     * */
    @Override
    public void showChannelGoal(){System.out.println("Matches channel is designed for matches news.\n" + matches + "\n");}
}
