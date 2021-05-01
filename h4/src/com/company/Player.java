package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
/**
 * simulates a player(human or bot)
 * @author mehranghaffarian
 * */
public class Player {
    private String name;
    private ArrayList<Card> cards;
    private Scanner scan;

    public Player(String name, ArrayList<Card> cards) {
        this.name = name;
        this.cards = cards;
        this.scan = new Scanner(System.in);
    }
    /**
     * the card is checked to be playable or null is returned
     * @param board of the game
     * @return a card base on the situation and by the choice of the player
     * */
    public Card choose(Board board) throws InterruptedException {
        System.out.println(name);

        cards.get(0).displayCards(cards);

        board.display();
        System.out.println("Enter the index of your card(count from left to right from 1 to end) or if you can not choose any card enter 0.");

        int index = scan.nextInt() - 1;

        if (index >= 0 && index < cards.size()) {
            Card card = cards.get(index);

            if (card.getColor() == board.getColor() || card.getType().equalsIgnoreCase(board.getLastCard().getType()) || card.getType().equalsIgnoreCase("B"))
                return card;

        } else if (index == -1) {
            //cards are checked to make sure they are not playable
            for (int i = 0; i < cards.size(); i++) {
                if (board.isPlayable(cards.get(i))) {
                    System.out.println("You can choose the card " + (i + 1));
                    return choose(board);
                }
            }
            return null;
        }
        //the player has to choose agian
        return choose(board);
    }
    /**
     * returns card with seven or returns null
     * @param board of the game
     * @return the card which is playable or null
     * */
    public Card chooseSeven(Board board, Game game) {
        System.out.println(name + " You are in case of *_*sevenDevil*_* you can only choose seven or you will be ponished.");

        cards.get(0).displayCards(cards);

        System.out.println("You can choose only seven, Choose from the above(enter the index(left to right->1 to end)) or if you can not enter 0");

        int choice = scan.nextInt() - 1;

        if (choice < cards.size() && choice >= 0 && cards.get(choice).getType().equals("7"))
            return cards.get(choice);

        else {
            for (Card card : cards)
                if (card.getType().equals("7")) {
                    System.out.println("You can choose the seven you have in your cards.");
                    return chooseSeven(board, game);
                }
            return null;
        }
    }
    /**
     * @return the name of the player
     * */
    public String getName() {
        return name;
    }
    /**
     * @return cards ArrayList
     * */
    public ArrayList<Card> getCards() {
        return cards;
    }
}
