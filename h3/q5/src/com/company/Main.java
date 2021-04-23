package com.company;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory(new HashMap<>());
        Basket basket = new Basket(new HashMap<Product, Integer>());

        Scanner scan = new Scanner(System.in);

        inventory.setProducts(new Product(LocalDate.of(2020, 3, 15), LocalDate.of(2021, 3, 15), 20, 5, "Vegetables", "Carrot"), 10);
        inventory.setProducts(new Product(LocalDate.of(2020, 4, 1), LocalDate.of(2020, 8, 1), 50, 10, "Fruits", "Apple"), 50);
        inventory.setProducts(new Product(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 6, 1), 40, 100, "Egg", "12xEgs"), 20);
        inventory.setProducts(new Product(LocalDate.of(2020, 6, 1), LocalDate.of(2021, 1, 1), 100, 70, "Grains", "Oats"), 45);
        inventory.setProducts(new Product(LocalDate.of(2020, 1, 1), LocalDate.of(2020, 2, 1), 250, 150, "seafood", "Salmon"), 5);
        inventory.setProducts(new Product(LocalDate.of(2020, 3, 1), LocalDate.of(2020, 9, 1), 1000, 800, "Meat", "Stake"), 5);
        inventory.setProducts(new Product(LocalDate.of(2020, 1, 10), LocalDate.of(2020, 1, 25), 20, 100, "Diary", "Milk"), 20);
        inventory.setProducts(new Product(LocalDate.of(2020, 2, 1), LocalDate.of(2020, 3, 15), 10, 150, "Diary", "Cheese"), 50);

        String command = "start";

        while(!command.equalsIgnoreCase("checkout")){
            System.out.println();
            StringTokenizer tokenizer = new StringTokenizer(scan.nextLine(), " ");
            command = tokenizer.nextToken();

            if(command.equalsIgnoreCase("add")){
                ArrayList<Product> products = new ArrayList<Product>(inventory.getProducts().keySet());
                int index = Integer.parseInt(tokenizer.nextToken()) - 1;

                if(inventory.getProducts().get(products.get(index)) > 0) {
                    basket.purchase(products.get(index));
                    inventory.getProducts().replace(products.get(index), inventory.getProducts().get(products.get(index)) - 1);
                }
                    else
                        System.out.println("Not found in inventory.");
            }
            else if(command.equalsIgnoreCase("remove")){
                basket.remove(Integer.parseInt(tokenizer.nextToken()) - 1, inventory);
            }
            else if(command.equalsIgnoreCase("cart")){
                System.out.println(basket + "\nYour is basket is shown above.");
            }
            else if(command.equalsIgnoreCase("products")){
                System.out.println(inventory + "\nChoose from above:");
            }
            else if(command.equalsIgnoreCase("checkout")){
                System.out.println("It was a pleasure doing business with you.");
            }
        }
    }
}
