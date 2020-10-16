package com.codegym.task.task18.task1828;

/**
 * this class contains state and behaviour for Product
 *
 * state is described by: id productName price quantity
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;

    public Product(int id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * prints the product in a form of table ready to store in text file
     * @return
     */
    @Override
    public String toString() {
        return  Utility.align(String.valueOf(id), 8)
                + Utility.align(name, 30)
                + Utility.align(String.valueOf(price), 8)
                + Utility.align(String.valueOf(quantity), 4);
    }
}
