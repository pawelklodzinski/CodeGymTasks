package com.codegym.task.task18.task1828;

import java.util.ArrayList;

/**
 * this class contains various helpful methods for manipulating strings
 * to store data in the file
 */
public class Utility {

    /**
     * returns String aligned to right with spaces
     * or trim if String s is longer then total no of characters
     * @param s String to be padded
     * @param n total no of characters
     * @return returns String with padded with spaces to the right
     */
    protected static String align(String s, int n){
        String pads = "";
        String result = s;
        int noOfSpaces = n - s.length();
        if (noOfSpaces < 0){
            result = s.substring(0, n);
        }else {
            for (int i = 0; i < n - s.length(); i++) {
                pads += " ";
            }
            result += pads;
        }
        return result;
    }

    /*
    transforms file line into product
     */
    protected static Product lineToProduct(String line){
        Product product;
        int id = Integer.parseInt(line.substring(0, 8).trim());
        String name = line.substring(8, 38).trim();//8+30=38
        double price = Double.parseDouble(line.substring(38, 46).trim());//38+8=46
        int quantity = Integer.parseInt(line.substring(46, 50).trim());//46+4=50

        product = new Product(id, name, price, quantity);

        return product;
    }

}
