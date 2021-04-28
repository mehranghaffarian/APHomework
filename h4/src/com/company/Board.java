package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private ArrayList<Card> inventory;
    private ArrayList<Card> playerCards;
    private Boolean clockwise;
    private Color color;
    private Card lastCard;
    Random rand;

    public Board(ArrayList<Card> inventory, ArrayList<Card> playerCards, Color color, Card lastCard) {
        this.inventory = inventory;
        this.playerCards = playerCards;
        clockwise = true;
        this.color = color;
        this.lastCard = lastCard;
        rand = new Random();
    }

    public static final String ANSI_WHITE = "\u001B[37m";

    public int startGame(int playersNumber) throws InterruptedException {
        System.out.println(ANSI_WHITE + "Lets decide who to starts by Ace.");

        ArrayList<Card> cards = inventory;

        for (int i = 0;!cards.isEmpty();i++, i = i % playersNumber){
            int cardIndex = rand.nextInt(cards.size());

            System.out.println(ANSI_WHITE  + "player" + i + ":\n" + cards.get(cardIndex));
            Thread.sleep(1000);

            if(cards.get(cardIndex).getType().equalsIgnoreCase("A")){
                System.out.println("player" + i + ":\nYou will start the game.");

                return i;
            }
            else
                cards.remove(cardIndex);
        }
        return -1;
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
