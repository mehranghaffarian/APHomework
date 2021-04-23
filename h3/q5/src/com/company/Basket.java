package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Basket {
    private HashMap<Product, Integer> shoppingProducts;

    public Basket(HashMap<Product, Integer> shoppingProducts) {this.shoppingProducts = shoppingProducts;}

    public void purchase(Product product){
        if(shoppingProducts.containsKey(product))
        shoppingProducts.replace(product, shoppingProducts.get(product) + 1);

        else
            shoppingProducts.put(product, 1);
    }

    public void remove(int index, Inventory inventory){
        ArrayList<Product> products = new ArrayList<Product>(shoppingProducts.keySet());
        int instock = shoppingProducts.get(products.get(index));

        products.remove(products.get(index));
        inventory.setProducts(products.get(index), instock);
    }

    @Override
    public String toString() {
        Iterator<Product> list = shoppingProducts.keySet().iterator();
        int i = 1;
        String basket = "";

        while (list.hasNext()){
            Product product = list.next();
            basket = basket.concat(i++ + "){\n" + product.toString() + "\n}" +"instock: " + shoppingProducts.get(product) + "\n");
        }
        if(i == i){
            basket = "List is empty.";
        }
        return basket;
    }
}
