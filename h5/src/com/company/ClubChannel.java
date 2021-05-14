package com.company;

import java.util.ArrayList;
/**
 *simulates the reporting news channel for players news
 * @author mehranghaffarian
 * */
public class ClubChannel extends NewsChannel{
    private Club club;

    public ClubChannel(ArrayList<News> news, ArrayList<Follower> followers, Club club) {
        super(news, followers);
        this.club = club;
    }
    /**
     *displays the aim of the channel
     * */
    @Override
    public void showChannelGoal() {
        System.out.print("Club channel is designed for ");
        club.display();
        System.out.println(" news.\n");
    }
}
