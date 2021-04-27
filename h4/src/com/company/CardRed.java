package com.company;

public class CardRed extends Card{
    public static final String ANSI_RED = "\u001B[31m";

    Color color;

    public CardRed(String type) {
        super(type, Color.RED);
        color = Color.RED;
    }

    @Override
    public void display() {
        if(!super.getType().equals("10"))
        System.out.println(ANSI_RED + "______\n|" + super.getType() + "   |\n|    |\n|   " + super.getType() + "|\n|____|");

        else
            System.out.println(ANSI_RED + "_______\n|10   |\n|     |\n|   10|\n|_____|");
    }
}
