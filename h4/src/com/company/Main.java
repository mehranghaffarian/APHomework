package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";

    //A 2345678910 B C D
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the number of players without you.");
        int numberOfPlayers = scan.nextInt() + 1;
        System.out.println("If you want to play with bot enter 0, if you want to play with your friends enter 1.");
        int mode = scan.nextInt();

        System.out.println(ANSI_BLACK_BACKGROUND + Color.GREEN);
        String[] types = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "C", "D"};
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        Random rand = new Random();

        //creating cards
        for(int i = 0;i < 13;i++) {
            for (int j = 0; j < 4; j++)
                cards.add(new Card(types[i], colors[j]));
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


    }
}
