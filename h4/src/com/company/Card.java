package com.company;

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

    public void display(){
        if(color == Color.GREEN) {
            if (!type.equals("10"))
                System.out.format(ANSI_GREEN + "______\n|" + type + "   |\n|    |\n|   " + type + "|\n|____|");
            else
                System.out.format(ANSI_GREEN + "_______\n|10   |\n|     |\n|   10|\n|_____|");
        }
        if(color == Color.RED){
                if(!type.equals("10"))
                    System.out.format(ANSI_RED + "______\n|" + type + "   |\n|    |\n|   " + type + "|\n|____|");

                else
                    System.out.format(ANSI_RED + "_______\n|10   |\n|     |\n|   10|\n|_____|");
        }
        if(color == Color.YELLOW){
            if(!type.equals("10"))
                System.out.format(ANSI_YELLOW + "______\n|" + type + "   |\n|    |\n|   " + type + "|\n|____|");

            else
                System.out.format(ANSI_YELLOW + "_______\n|10   |\n|     |\n|   10|\n|_____|");
        }
        if(color == Color.BLUE){
            if(!type.equals("10"))
                System.out.format(ANSI_BLUE + "______\n|" + type + "   |\n|    |\n|   " + type + "|\n|____|");

            else
                System.out.format(ANSI_BLUE + "_______\n|10   |\n|     |\n|   10|\n|_____|");
        }
    }

    public String getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
