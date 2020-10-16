package com.codegym.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;

public class FileOperation {
    private ArrayList<Product> products = new ArrayList<>();

    /**
     * loads file into memory
     * @param sourceFile specifies file to read form
     */
    protected ArrayList<Product> loadProducts(String sourceFile){
        /*
        loads lines
         */
        ArrayList<String> lines = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(sourceFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        transforms lines into products
         */
        for (String s: lines
             ) {
            Product product = Utility.lineToProduct(s);
            products.add(product);
        }

        return this.products;
    }

    /**
     * saves data temporarily stored in ArrayList into persisting file
     * @param targetFile the file where data are saved
     * @param products products to be saved
     */
    protected void saveFile(String targetFile, ArrayList<Product> products){
        try {
            FileWriter fileWriter = new FileWriter(targetFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product p: products
                 ) {
                bufferedWriter.write(p.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
