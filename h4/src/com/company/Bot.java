package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Bot extends Player{
    public Bot(String name, ArrayList<Card> cards) {
        super(name, cards);
    }

    public static final String ANSI_WHITE = "\u001B[37m";

    public Card choose(Board board) throws InterruptedException {
        board.display();

        System.out.println("\n\n" + super.getName() + " is choosing");
        Thread.sleep(1000);

        for (int i = 0; i < super.getCards().size(); i++) {
            if (board.isPlayable(super.getCards().get(i))) {
                System.out.println(ANSI_WHITE + "\nThe " + super.getName() + "has choosen:");

                ArrayList<Card> card = new ArrayList<>();
                card.add(super.getCards().get(i));
                super.getCards().get(i).displayCards(card);
                Thread.sleep(1000);

                return super.getCards().get(i);
            }
        }
        return null;
    }

    public Card chooseSeven(Board board, Game game) {
        for (int i = 0; i < super.getCards().size(); i++)
            if (super.getCards().get(i).getType().equals("7")) {
                return super.getCards().get(i);
            }
        return null;
    }
}
