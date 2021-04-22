package com.company;

import java.util.HashMap;
import java.util.Iterator;

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
}
