package com.company;

import java.time.LocalDate;
import java.util.Objects;

public class Product {
    private LocalDate proTime;
    private LocalDate expTime;
    private double price;
    private double weight;
    private String category;
    private String name;

    public Product(LocalDate proTime, LocalDate expTime, double price, double weight, String category, String name) {
        this.proTime = proTime;
        this.expTime = expTime;
        this.price = price;
        this.weight = weight;
        this.category = category;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.weight, weight) == 0 && Objects.equals(proTime, product.proTime) && Objects.equals(expTime, product.expTime) && Objects.equals(category, product.category) && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(proTime, expTime, weight, category, name);
    }

    @Override
    public String toString() {
        return "\"Product\": {" +
                "\n\"NAME\": \"" + name + '\"' +
                ",\n \"CATEGORY\": \"" + category + '\"' +
                ",\n\"WEIGHT\": \"" + weight + '\"' +
                ",\n\"PRICE\": \"" + price + '\"' +
                ",\n\"MANUFACTURE_DATE\": " + proTime +
                ",\n\"EXPIRATION_DATE\": " + expTime + '\n' +
                '}';
    }
}
