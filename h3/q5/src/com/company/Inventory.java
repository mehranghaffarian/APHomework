package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

public class Inventory {
    private HashMap<Product, Integer> products;

    public Inventory(HashMap<Product, Integer> products) {this.products = products;}

    public boolean setProducts(Product product, int stock){
        if(isIn(product)) {
            products.replace(product, products.get(product) + stock);
            return true;
        }else {
            products.put(product, stock);
            return false;
        }
    }

    private boolean isIn(Product product){
        Iterator<Product> itr = products.keySet().iterator();

        while(itr.hasNext()){
            if(itr.next().equals(product))
                return true;
        }
        return false;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        Iterator<Product> list = products.keySet().iterator();
        int i = 1;
        String inventory = "";

        while (list.hasNext()){
            Product product = list.next();
            inventory = inventory.concat(i++ + "){\n" + product.toString() + "\n}" +"instock: " + products.get(product) + "\n");
        }
        if(i == 1){
            inventory = "We are out of stock.";
        }
        return inventory;
    }
}
