package com.company;
/**
 * simulates player of the club and its identity
 * @author mehranghaffarian
 * */
public class Player {
    private String firstName;
    private String lastName;
    private long id;
    private int age;

    public Player(String firstName, String lastName, long id, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.age = age;
    }
    /**
     * @return the player name
     * */
    @Override
    public String toString() {return firstName + " " + lastName;}
}
