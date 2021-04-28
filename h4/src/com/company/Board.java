package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private ArrayList<Card> inventory;
    private Boolean clockwise;
    private Color color;
    private Card lastCard;
    Random rand;

    public Board(ArrayList<Card> inventory, Boolean clockwise, Color color, Card lastCard) {
        this.inventory = inventory;
        this.clockwise = clockwise;
        this.color = color;
        this.lastCard = lastCard;
        rand = new Random();
    }

    public static final String ANSI_WHITE = "\u001B[37m";

    public int startGame(ArrayList<Player> players) throws InterruptedException {
        System.out.println(ANSI_WHITE + "Lets decide who to start by Ace.");

        ArrayList<Card> cards = inventory;

        for (int i = 0;!cards.isEmpty();i++, i = i % players.size()){
            int cardIndex = rand.nextInt(cards.size());

            System.out.println(ANSI_WHITE + players.get(i).getName() + ":\n" + cards.get(cardIndex));
            Thread.sleep(1000);

            if(cards.get(cardIndex).getType().equalsIgnoreCase("A")){
                System.out.println(players.get(i).getName() + ":\nYou will start the game.");

                return i;
            }
            else
                cards.remove(cardIndex);
        }
        return 0;
    }

    public void display(){
        System.out.println(ANSI_WHITE + (clockwise ? "Clockwise" : "Counterclockwise" + "\nRequired color:0" + color));

        lastCard.display();
        System.out.println(ANSI_WHITE + "It is your turn:");
    }

    public Color getColor() {
        return color;
    }

    public Card getLastCard() {
        return lastCard;
    }
}
