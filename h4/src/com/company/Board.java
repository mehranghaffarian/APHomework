package com.company;

import java.util.ArrayList;
import java.util.Random;
/**
 * the board of the game and its information
 * @author mehranghaffarian
 * */
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
    /**
     * defines the starter of the game by random cards(Ace defines the starter)
     * @param players in the game
     * @return the index of the person starts the game
     * */
    public int startGame(ArrayList<Player> players) throws InterruptedException {
        System.out.println(ANSI_WHITE + "Lets decide who will start the game by lucky Ace.");
        Thread.sleep(5000);

        ArrayList<Card> cards = inventory;

        for (int i = 0; !cards.isEmpty(); i++, i = i % players.size()) {
            int cardIndex = rand.nextInt(cards.size());

            System.out.println(ANSI_WHITE + players.get(i).getName());

            ArrayList<Card> printCards = new ArrayList<>();
            printCards.add(cards.get(cardIndex));
            cards.get(cardIndex).displayCards(printCards);

            Thread.sleep(1000);

            if (cards.get(cardIndex).getType().equalsIgnoreCase("A"))
                return i;
            else
                cards.remove(cardIndex);
        }
        return -1;
    }
    /**
     *the board information is displayed
     * */
    public void display() {
        System.out.println(ANSI_WHITE + "Board is as below\n" + (clockwise ? "Clockwise" : "Counterclockwise") + "\nRequired color: " + color);

        ArrayList<Card> printCards = new ArrayList<>();
        printCards.add(lastCard);
        lastCard.displayCards(printCards);
    }
    /**
     * @return the theme color
     * */
    public Color getColor() {
        return color;
    }
    /**
     * @return the last card on the board
     * */
    public Card getLastCard() {
        return lastCard;
    }
    /**
     * @param card which the player has choosed
     * @return the validity of the given card
     * */
    public boolean isPlayable(Card card) {
        if (card.getColor() == color || card.getType().equalsIgnoreCase(lastCard.getType()) || card.getType().equalsIgnoreCase("B"))
            return true;

        return false;
    }
    /**
     * @param player who chose the card
     * @param card to be applied to the board(validity is checked in choose method in player)
     * @return the number of the card(Ace -> 1, Jack -> 11, Queen and King have no special effect on the board -> 0)
     * */
    public int applyCard(Player player, Card card) {
        hiddenCards.add(lastCard);
        player.getCards().remove(card);

        //updating the board
        color = card.getColor();
        clockwise = card.getType().equals("10") != clockwise;
        lastCard = card;

        //A->1, B->11
        if (card.getType().equals("A") || card.getType().equals("B")) {
            return card.getType().equals("A") ? 1 : 11;
        } else if (card.getType().equals("C") || card.getType().equals("D")) {
            return 0;
        }

        return Integer.parseInt(card.getType());
    }
    /**
     * @return a random card from the rest of the hidden cards
     * */
    public Card ponish() {
        Card ponishCard = hiddenCards.get(rand.nextInt(hiddenCards.size()));
        hiddenCards.remove(ponishCard);

        return ponishCard;
    }
    /**
     * @param color to be the theme color
     * */
    public void setColor(Color color) {
        this.color = color;
    }
}