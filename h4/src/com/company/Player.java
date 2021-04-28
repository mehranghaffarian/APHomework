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
        System.out.println(name);

        for (Card card : cards) {
            card.display();
            System.out.println();
        }
        board.display();
        System.out.println("Enter the index of your card(count from left to right from 1 to end) or if you can not choose any card enter 0.");

        int index = scan.nextInt() - 1;

        if(index >= 0 && index < cards.size()){
            Card card = cards.get(index);

            if(card.getColor() == board.getColor() || card.getType().equalsIgnoreCase(board.getLastCard().getType()) || card.getType().equalsIgnoreCase("B"))
                return card;
        }
        else if(index == -1){
            for (int i = 0;i < cards.size();i++) {
                if (board.isPlayable(cards.get(i))) {
                    System.out.println("You can choose the card " + (i + 1));
                    return choose(board);
                }
            }
            return null;
        }

        return choose(board);
    }

    public Card chooseSeven(Board board, Game game){
        System.out.println("Your in case of *_*sevenDevil*_* you can only choose seven or you will be ponished.");

        for (Card card : cards)
            card.display();

        System.out.println("Choose from the above(enter the index(left to right->1 to end)) or if you can not enter 0");

        int choice = scan.nextInt();

        if(choice < cards.size() && choice >= 0 && cards.get(choice).getType().equals("7"))
                return cards.get(choice);

            else{
                for(Card card : cards)
                    if(card.getType().equals("7")) {
                        System.out.println("You can choose the seven you have in your cards.");
                        return chooseSeven(board, game);
                    }
                return null;
            }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    //for(int i = 1;i <= 5;i++){
    //            System.out.println();
    //            for(int j = 0;j < size;j++) {
    //                if(i == 1)
    //                System.out.printf("______");
    //                else if (i == 2)
    //                    System.out.printf("|%s   |", strs[rand.nextInt(strs.length)]);
    //                else if(i == 3)
    //                    System.out.printf("|    |");
    //                else if(i == 4)
    //                    System.out.printf("|   %s|", strs[rand.nextInt(strs.length)]);
    //                else if(i == 5)
    //                    System.out.print("|____|");
    //
    //                System.out.printf("  ");
    //            }
    //        }
}
