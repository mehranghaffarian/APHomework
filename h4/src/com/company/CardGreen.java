package com.company;

public class CardGreen extends Card{
    public static final String ANSI_GREEN = "\u001B[32m";

    Color color;

    public CardGreen(String type) {
        super(type, Color.GREEN);
        this.color = Color.GREEN;
    }

    @Override
    public void display() {
        if(!super.getType().equals("10"))
            System.out.println(ANSI_GREEN + "______\n|" + super.getType() + "   |\n|    |\n|   " + super.getType() + "|\n|____|");

        else
            System.out.println(ANSI_GREEN + "_______\n|10   |\n|     |\n|   10|\n|_____|");
    }
}
