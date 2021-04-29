package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Card {
    private String type;
    private Color color;

    public Card(String type, Color color) {
        this.type = type;
        this.color = color;
    }
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public void displayCards(ArrayList<Card> cards){
        HashMap<Color, String> colorsMap = new HashMap<>();

        colorsMap.put(Color.RED, ANSI_RED);
        colorsMap.put(Color.BLUE, ANSI_BLUE);
        colorsMap.put(Color.GREEN, ANSI_GREEN);
        colorsMap.put(Color.YELLOW, ANSI_YELLOW);

            Random rand = new Random();

            for (int i = 1; i <= 5; i++) {
                System.out.println();
                for (int j = 0; j < cards.size(); j++) {
                    System.out.format(colorsMap.get(cards.get(j).getColor()));

                    if (i == 1)
                        System.out.print("_______");
                    else if (i == 2) {
                        System.out.printf("|%s   |", !cards.get(j).getType().equals("10") ? cards.get(j).getType().concat(" ") : cards.get(j).getType());
                    } else if (i == 3)
                        System.out.print("|     |");
                    else if (i == 4)
                        System.out.printf("|   %2s|", cards.get(j).getType());
                    else if (i == 5)
                        System.out.print("|_____|");

                    System.out.print("  ");
                }
            }
            System.out.println();
    }

    public String getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
