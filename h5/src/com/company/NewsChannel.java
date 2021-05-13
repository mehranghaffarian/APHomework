package com.company;

import java.util.ArrayList;

public abstract class NewsChannel {
    private ArrayList<News> news;
    private ArrayList<Follower> followers;

    public NewsChannel(ArrayList<News> news, ArrayList<Follower> followers) {
        this.news = news;
        this.followers = followers;
    }

    public abstract void showChannelGoal();

    public boolean addFollower(Follower follower) {
        boolean isIn = false;

        for(Follower follow : followers)
            if(follow.equals(follow))
                isIn = true;

        if (isIn)
            return false;
        else {
            followers.add(follower);
            return true;
        }
    }

    public boolean removeFollower(Follower follower) {
        boolean isIn = false;

        for(Follower follow : followers)
            if(follow.equals(follow))
                isIn = true;

        if (!isIn)
            return false;
        else {
            followers.remove(follower);
            return true;
        }
    }

    public boolean setNews(News newNews){
        boolean isIn = false;

        for(News checkNews : news)
            if(checkNews.equals(newNews))
                isIn = true;

        if (isIn)
            return false;
        else {
            news.add(newNews);
            tellFollowers();
            return true;
        }
    }

    public void tellFollowers(){
        for(Follower follower : followers)
            follower.update(news.get(news.size()));
    }
}
