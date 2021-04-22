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

    public void printProducts(){
        Iterator<Product> list = products.keySet().iterator();
        int i = 1;

        while (list.hasNext()){
            Product product = list.next();

            System.out.println(i++ + "){");
            System.out.println("\"Product\": {");
            System.out.println("\"NAME\": \"");
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

    @Override
    public String toString() {
        return "Inventory{" +
                "products=" + products +
                '}';
    }
}
