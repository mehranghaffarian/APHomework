package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    ArrayList<Card> cards;
    Scanner scan;

    public Player(ArrayList<Card> cards) {
        this.cards = cards;
        scan = new Scanner(System.in);
    }

    public Card choose(Board board){
        for (Card card : cards) {
            card.display();
            System.out.println(cards.indexOf(card) + 1);
        }
        System.out.println("Choose from indexes above.");

        int index = scan.nextInt();

        if(index >= 0 && index < cards.size()){
            Card card = cards.get(index);

            if(card.getColor() == board.getColor() || card.getType().equalsIgnoreCase(board.getLastCard().getType()) || card.getType().equalsIgnoreCase("Jack"))
                return card;
        }
        return null;
    }
}
