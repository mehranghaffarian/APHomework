package com.company;

public class Card {
    private String type;
    private Color color;

    public Card(String type, Color color) {
        this.type = type;
        this.color = color;
    }

    public void display(){
        System.out.print("");
    }

    public String getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
