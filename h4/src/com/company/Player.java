package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    String name;
    ArrayList<Card> cards;
    Scanner scan;

    public Player(String name, ArrayList<Card> cards) {
        this.name = name;
        this.cards = cards;
        this.scan = new Scanner(System.in);
    }

    public Card choose(Board board){
        for (Card card : cards) {
            card.display();
            System.out.println(cards.indexOf(card) + 1);
        }
        System.out.println("Choose from indexes above.");

        int index = scan.nextInt() + 1;

        if(index >= 0 && index < cards.size()){
            Card card = cards.get(index);

            if(card.getColor() == board.getColor() || card.getType().equalsIgnoreCase(board.getLastCard().getType()) || card.getType().equalsIgnoreCase("B"))
                return card;
        }
        choose(board);
        return null;
    }

    public String getName() {
        return name;
    }

    public int cardsNumber(){
        return cards.size();
    }
}
