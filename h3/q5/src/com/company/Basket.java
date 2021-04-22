package com.company;

import java.util.HashMap;

public class Basket {
    private HashMap<Product, Integer> shoppingProducts;

    public Basket(HashMap<Product, Integer> shoppingProducts) {this.shoppingProducts = shoppingProducts;}

    @Override
    public String toString() {
        return "Basket{" +
                "shoppingProducts=" + shoppingProducts +
                '}';
    }
}
