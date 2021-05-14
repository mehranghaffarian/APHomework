package com.company;

import java.util.ArrayList;
/**
 *simulates the reporting news channel for players news
 * @author mehranghaffarian
 * */
public abstract class NewsChannel {
    private ArrayList<News> news;
    private ArrayList<Follower> followers;

    public NewsChannel(ArrayList<News> news, ArrayList<Follower> followers) {
        this.news = news;
        this.followers = followers;
    }

    public abstract void showChannelGoal();
    /**
     *adds followers to the list of the followers if it is not in the list
     * @param follower to be added to the list
     * @return true if the follower did not exist in the list before otherwise returns false
     * */
    public boolean followerJoin(Follower follower) {
        boolean isIn = false;

        for(Follower follow : followers) {
            if (follow.equals(follower))
                isIn = true;
        }

        if (isIn)
            return false;
        else {
            followers.add(follower);
            return true;
        }
    }
    /**
     *removes followers from the list of the followers if it is in the list
     * @param follower to be removed from the list
     * @return true if the follower existed in the list before otherwise returns false
     * */
    public boolean followerLeft(Follower follower) {
        boolean isIn = false;

        for(Follower follow : followers) {
            if (follow.equals(follower))
                isIn = true;
        }

        if (!isIn)
            return false;
        else {
            followers.remove(follower);
            return true;
        }
    }
    /**
     *adds a news to the news list if it did not exist and calls followers
     * @param newNews to be added
     * @return true if it did not exist before otherwise returns false
     * */
   public boolean setNews(News newNews){
        boolean isIn = false;

        for(News checkNews : news) {
            if (checkNews == newNews)
                isIn = true;
        }

        if (isIn)
            return false;
        else {
            news.add(newNews);
            tellFollowers(newNews);
            return true;
        }
    }
    /**
     *calls followers to update themselves because of a new news
     * @param newNews is a new news
     * */
    public void tellFollowers(News newNews){
        for(Follower follower : followers)
            follower.update(newNews);
    }
}
