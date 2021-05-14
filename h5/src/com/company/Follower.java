package com.company;

import java.util.Objects;
/**
 *simulates a follower and its identity
 * @author mehranghaffarian
 * */
public class Follower {
    private String firstName;
    private String lastName;
    private long id;

    public Follower(String firstName, String lastName, long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
    }
    /**
     *updates the follower in case of new news
     * */
    public void update(News news){
        System.out.println(firstName + " " + lastName + " you have a new news:");
        news.display();
        System.out.println();
    }
    /**
     *compares two followers based on their ids
     * @return comparison result
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follower follower = (Follower) o;
        return id == follower.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
