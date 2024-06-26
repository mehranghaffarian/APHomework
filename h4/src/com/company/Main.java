package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/**
 * seven devils for playing with other bots or real players
 * @author mehranghaffarian
 * */
public class Main {
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        //number of real players and bots
        System.out.println(ANSI_BLACK_BACKGROUND + ANSI_WHITE + "Hi, it is me mehran.\nLets play seven devils.");
        System.out.println("Please enter the number of human players without counting yourself, and the number of bots respectively.");
        int numberOfPlayers = scan.nextInt() + 1;
        int numberBots = scan.nextInt();

        //number os card sets(each set contains 52 cards)
        System.out.println("Entre the coefficient of 52 in the number of the cards you want to play with(same cards pose no problem).");
        int cardsNumber = scan.nextInt();

        String[] types = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "B", "C", "D"};
        Color[] colors = {Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
        ArrayList<Card> cards = new ArrayList<>();
        ArrayList<Player> players = new ArrayList<>();
        Random rand = new Random();

        //creating cards for given number of sets in usual cards or special cards
        while (cardsNumber-- != 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 1; j < 10; j++) {
                    if (j == 1 || j == 6 || j == 7 || j == 9)
                        cards.add(new SpecialCard(types[j], colors[i]));
                    else
                        cards.add(new UsualCard(types[j], colors[i]));
                }

                for (int j = 10; j < 13; j++)
                    cards.add(new SpecialCard(types[j], colors[i]));

                cards.add(new SpecialCard("A", colors[i]));
            }
        }

        //dummy println
        scan.nextLine();

        //creating players with given names
        ArrayList<Card> cardsToDivide = cards;
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.printf("Please enter the name of player%d: ", (i + 1));
            String name = scan.nextLine();

            ArrayList<Card> playerCards = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                int cardIndex = rand.nextInt(cardsToDivide.size());

                playerCards.add(cardsToDivide.get(cardIndex));
                cardsToDivide.remove(cardIndex);
            }
            players.add(new Player(name, playerCards));
        }

        //creating bots with given names
        for (int i = 0; i < numberBots; i++) {
            System.out.printf("Please enter the name of bot%d: ", (i + 1));
            String name = scan.nextLine();

            ArrayList<Card> botCards = new ArrayList<>();
            for (int j = 0; j < 7; j++) {
                int cardIndex = rand.nextInt(cardsToDivide.size());

                botCards.add(cardsToDivide.get(cardIndex));
                cardsToDivide.remove(cardIndex);
            }
            players.add(new Bot(name, botCards));
        }

        //last card on the board(not special card)
        Card lastCard = cardsToDivide.get(rand.nextInt(cards.size()));

        while (lastCard instanceof SpecialCard)
            lastCard = cardsToDivide.get(rand.nextInt(cards.size()));

        cardsToDivide.remove(lastCard);

        ArrayList<Player> randomOrder = new ArrayList<>();

        while(players.size() != 0){
            int index = rand.nextInt(players.size());

            randomOrder.add(players.get(index));
            players.remove(index);
        }

        Game game = new Game(randomOrder, new Board(cards, cardsToDivide, true, lastCard.getColor(), lastCard));

        game.sevenDevils();

        System.out.println("\n\nGAME IS OVER.\n\nI hope you have enjoyed the game.\n\nSincerely;\nMehran Ghaffarian\n");
    }
}
