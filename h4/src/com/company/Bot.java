package com.company;

import java.util.ArrayList;
import java.util.Scanner;
/**
 *simulates the bot as player
 * @author mehranghaffarian
 * */
public class Bot extends Player {
    public Bot(String name, ArrayList<Card> cards) {
        super(name, cards);
    }

    public static final String ANSI_WHITE = "\u001B[37m";
    /**
     * a card is choosen by the board situations or null is returned
     * @param board of the game
     * @return the chosen card
     * */
    @Override
    public Card choose(Board board) throws InterruptedException {
        board.display();

        System.out.println("\n\n" + super.getName() + " is choosing....");
        Thread.sleep(2000);

        for (int i = 0; i < super.getCards().size(); i++) {
            if (board.isPlayable(super.getCards().get(i))) {
                System.out.println(ANSI_WHITE + "\nThe " + super.getName() + " has choosen:");

                ArrayList<Card> card = new ArrayList<>();
                card.add(super.getCards().get(i));
                super.getCards().get(i).displayCards(card);
                Thread.sleep(4000);

                return super.getCards().get(i);
            }
        }
        return null;
    }
    /**
     * a card is choosen by the seven situation
     * @param board of the game
     * @return the choosen card
     * */
    @Override
    public Card chooseSeven(Board board, Game game) {
        System.out.println(getName() + " is in case of *_*SevenDevils*_*....");

        for (int i = 0; i < super.getCards().size(); i++)
            if (super.getCards().get(i).getType().equals("7")) {
                return super.getCards().get(i);
            }

        return null;
    }
}
