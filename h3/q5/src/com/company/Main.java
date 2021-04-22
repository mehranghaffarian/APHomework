package com.company;

import java.time.LocalDate;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory(new HashMap<>());

        inventory.setProducts(new Product(LocalDate.of(2020, 3, 15), LocalDate.of(2021, 3, 15), 20, 5, "Vegetables", "Carrot"), 10);
        inventory.setProducts(new Product(LocalDate.of(2020, 4, 1), LocalDate.of(2020, 8, 1), 50, 10, "Fruits", "Apple"), 50);
        inventory.setProducts(new Product(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 6, 1), 40, 100, "Egg", "12xEgs"), 20);
        inventory.setProducts(new Product(LocalDate.of(2020, 6, 1), LocalDate.of(2021, 1, 1), 100, 70, "Grains", "Oats"), 45);
        inventory.setProducts(new Product(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 2, 1), 250, 150, "seafood", "Salmon"), 5);
        inventory.setProducts(new Product(LocalDate.of(2020, 3, 1), LocalDate.of(2020, 9, 1), 1000, 800, "Meat", "Stake"), 5);
        inventory.setProducts(new Product(LocalDate.of(2020, 1, 10), LocalDate.of(2020, 1, 25), 20, 100, "Diary", "Milk"), 20);
        inventory.setProducts(new Product(LocalDate.of(2020, 2, 1), LocalDate.of(2020, 3, 15), 10, 150, "Diary", "Cheese"), 50);

        System.out.println(inventory);
    }
}
