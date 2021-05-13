package com.company;

public class Follower {
    private String firstName;
    private String lastName;
    private long id;

    public Follower(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void update(News news){
        System.out.println(firstName + " " + lastName + " you have a new news:");
        news.display();
    }

    public long getId(){return id;}

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Follower){
            return ((Follower) obj).getId() == id;
        }
        else
            return false;
    }
}
