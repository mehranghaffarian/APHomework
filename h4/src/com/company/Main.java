package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "Hi, it is me mehran.\nLets play seven devils.");

        System.out.println("Please enter the number of players without counting yourself.");
        int numberOfPlayers = scan.nextInt() + 1;

        System.out.println("If you want to play with bot enter 0, if you want to play with your friends enter 1.");
        int mode = scan.nextInt();

        String[] types = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "C", "D"};
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        Random rand = new Random();

        //creating cards
        for(int i = 0;i < 4;i++) {
            for (int j = 1; j < 10; j++) {
                if(j == 1 || j == 6 || j == 7 || j == 9)
                    cards.add(new SpecialCard(types[j], colors[i]));

                cards.add(new UsualCard(types[j], colors[i]));
            }

            for(int j = 10;j < 13;j++)
                cards.add(new SpecialCard(types[j], colors[i]));

            cards.add(new SpecialCard("A", colors[i]));
        }

        //creating players
        ArrayList<Card> cardsToDivide = cards;
        for(int i = 0;i < numberOfPlayers;i++){
            System.out.println("Please enter the name of player" + (i + 1));
            String name = scan.nextLine();

            ArrayList<Card> playerCards = new ArrayList<>();
            for(int j = 0;j < 7;j++){
                int cardIndex = rand.nextInt(cardsToDivide.size());

                playerCards.add(cardsToDivide.get(cardIndex));
                cardsToDivide.remove(cardIndex);
            }
            players.add(new Player(name, playerCards));
        }
        Card lastCard = cardsToDivide.get(rand.nextInt(cards.size()));
        cardsToDivide.remove(lastCard);

        Game game = new Game(players, new Board(cards, cardsToDivide, true, lastCard.getColor(), lastCard));

        game.sevenDevils();

        System.out.println("I hope you have enjoyed the game");
    }
}
