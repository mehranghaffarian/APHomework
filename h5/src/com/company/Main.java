package com.company;

import java.util.ArrayList;
import java.util.Date;
/**
 * reporting news system for a club and its players and matches news
 * @author mehranghaffarian
 * */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Match> matches = new ArrayList<>();
        matches.add(new Match(new Date(2021, 8, 25, 16, 35), "Physics TAs"));
        matches.add(new Match(new Date(2021, 9, 2, 17, 45), "Math TAs"));
        matches.add(new Match(new Date(2021, 9, 5, 19, 55), "Discrete Math TAs"));

        ArrayList<Player> players = new ArrayList<>();
        players.add(new Player("Bardia", "Arakanian", 9731000, 21));
        players.add(new Player("Saman", "Hosseini", 9731001, 21));
        players.add(new Player("Sarvnaz", "Sarvgad", 9731002, 21));

        Club club = new Club("AP TAs", matches, players);

        PlayerChannel playerChannel = new PlayerChannel(new ArrayList<News>(), new ArrayList<Follower>(), players);
        ClubChannel clubChannel = new ClubChannel(new ArrayList<News>(), new ArrayList<Follower>(), club);
        MatchesChannel matchesChannel = new MatchesChannel(new ArrayList<News>(), new ArrayList<Follower>(), matches);

        playerChannel.showChannelGoal();
        clubChannel.showChannelGoal();
        matchesChannel.showChannelGoal();

        //7 followers for any statue
        Follower follower1 = new Follower("Mehran", "Ghaffarian", 1);
        Follower follower2 = new Follower("Me" , "Gh", 2);
        Follower follower3 = new Follower("Meh", "Gha", 3);
        Follower follower4 = new Follower("Mehr", "Ghaf", 4);
        Follower follower5 = new Follower("Mehra", "Ghaff", 5);
        Follower follower6 = new Follower("Mehra", "Ghaffar", 6);
        Follower follower7 = new Follower("Mehra", "Ghaffaria", 7);

        playerChannel.followerJoin(follower1);
        playerChannel.followerJoin(follower2);
        playerChannel.followerJoin(follower3);

        clubChannel.followerJoin(follower1);
        clubChannel.followerJoin(follower2);
        clubChannel.followerJoin(follower4);
        clubChannel.followerJoin(follower5);

        matchesChannel.followerJoin(follower1);
        matchesChannel.followerJoin(follower3);
        matchesChannel.followerJoin(follower4);
        matchesChannel.followerJoin(follower7);
        matchesChannel.followerJoin(follower6);

        //new news to to check accuracy(contents are not written purposefully):D :D
        playerChannel.setNews(new News("Suspicious Death", "Bardia has passed away today, doctors doubt it was because of heart attack or murder."));
        clubChannel.setNews(new News("New player", "The club signed new contract with Parham as the new goalkeeper."));
        matchesChannel.setNews(new News("*_*Derbi*_*", "Tomorrow AP TAs will play across WorkShop TAs."));

        //followers can leave the channels they have joined before
        playerChannel.followerLeft(follower1);
        clubChannel.followerLeft(follower5);
        matchesChannel.followerLeft(follower7);

        Thread.sleep(5000);
        System.out.println("\n\n\n\n");

        //new news for checking accuracy after when followers left some channels(contents are not written purposefully):D :D
        playerChannel.setNews(new News("Suspicious Death", "Saman has passed away today, doctors doubt it was because of heart attack or murder."));
        clubChannel.setNews(new News("New TA", "The club signed new contract with Sina as the goalkeeper."));
        matchesChannel.setNews(new News("*_*Derbi*_*", "Tomorrow AP TAs will play across Math TAs."));
    }
}
