package com.company;

import java.util.ArrayList;

public class Board {
    public static final String ANSI_WHITE = "\u001B[37m";

    private ArrayList<Card> inventory;
    private Boolean clockwise;
    private Color color;
    private Card lastCard;

    public Board(ArrayList<Card> inventory, Boolean clockwise, Color color, Card lastCard) {
        this.inventory = inventory;
        this.clockwise = clockwise;
        this.color = color;
        this.lastCard = lastCard;
    }

    public void display(){
        System.out.println(ANSI_WHITE + (clockwise ? "Clockwise" : "Counterclockwise" + "\nRequired color:0" + color));

        lastCard.display();
        System.out.println("It is your turn:");
    }

    public Color getColor() {
        return color;
    }

    public Card getLastCard() {
        return lastCard;
    }
}
