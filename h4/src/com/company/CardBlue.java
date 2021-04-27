package com.company;

public class CardBlue extends Card{
    public static final String ANSI_BLUE = "\u001B[34m";

    Color color;

    public CardBlue(String type) {
        super(type, Color.BLUE);
        color = Color.BLUE;
    }

    @Override
    public void display() {
        if(!super.getType().equals("10"))
            System.out.println(ANSI_BLUE + "______\n|" + super.getType() + "   |\n|    |\n|   " + super.getType() + "|\n|____|");

        else
            System.out.println(ANSI_BLUE + "_______\n|10   |\n|     |\n|   10|\n|_____|");
    }
}
