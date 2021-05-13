package com.company;

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

    public String getName(){return firstName + " " + lastName;}
}
