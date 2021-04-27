package com.company;

public class CardYellow extends Card{
    public static final String ANSI_YELLOW = "\u001B[33m";

    Color color;

    public CardYellow(String type) {
        super(type, Color.YELLOW);
        color = Color.YELLOW;
    }

    @Override
    public void display() {
        if(!super.getType().equals("10"))
            System.out.println(ANSI_YELLOW + "______\n|" + super.getType() + "   |\n|    |\n|   " + super.getType() + "|\n|____|");

        else
            System.out.println(ANSI_YELLOW + "_______\n|10   |\n|     |\n|   10|\n|_____|");
    }
}
