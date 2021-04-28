package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private ArrayList<Card> inventory;//just for deciding who to start
    private ArrayList<Card> hiddenCards;
    private Boolean clockwise;
    private Color color;
    private Card lastCard;
    private Random rand;

    public Board(ArrayList<Card> inventory, ArrayList<Card> hiddenCards, Boolean clockwise, Color color, Card lastCard) {
        this.inventory = inventory;
        this.hiddenCards = hiddenCards;
        this.clockwise = clockwise;
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

    public boolean isPlayable(Card card){
        if(card.getColor() == color || card.getType().equalsIgnoreCase(lastCard.getType()) || card.getType().equalsIgnoreCase("B"))
            return true;

        return false;
    }

    public int applyCard(Player player, Card card){
        hiddenCards.add(lastCard);
        player.getCards().remove(card);

        //updating the board
        color = card.getColor();
        clockwise = card.getType().equals("10") != clockwise;
        lastCard = card;

        //A->1, B->11
        if(card.getType().equals("A") || card.getType().equals("B")){
            return card.getType().equals("A") ? 1 : 11;
        }
        return Integer.parseInt(card.getType());
    }

    public Card ponish() {
        Card ponishCard = hiddenCards.get(rand.nextInt(hiddenCards.size()));
        hiddenCards.remove(ponishCard);

        return ponishCard;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
