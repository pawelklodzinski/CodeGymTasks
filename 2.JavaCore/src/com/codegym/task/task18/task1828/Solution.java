package com.codegym.task.task18.task1828;

/* 
Prices 2

validation
----------------
task failed the validation

task
-------
CrUD for a table inside a file
Read a file name for CrUD operations from the console

The program runs with one of the following sets of arguments:
-u id productName price quantity
-d id

Argument values:
where id is 8 characters
productName is 30 characters
price is 8 characters
quantity is 4 characters
-u updates the data for the product with the specified id
-d performs the physical deletion of the product with the specified id (all data related to the passed id)

The file data is stored in the following order (without separating spaces):
id productName price quantity
Each data field is padded with spaces up to its length

Example:
19847   Swim trunks, blue             159.00  12
198479  Swim trunks, black with printe173.00  17
19847983Snowboard jacket with reflecti10173.991234
         10        10        10        10        10


Requirements:
1. The program should read a file name for CrUD operations from the console.
2. When you run the program without arguments, the product list must remain unchanged.
3. When the program is started with the arguments "-u id productName price quantity",
the product information in the file should be updated.
4. When the program is started with the arguments "-d id",
the line for the product with the specified id should be removed from the file.
5. The file streams must be closed.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * this is the solution to task no 1828 *
 *
 * this tasks is similar to the one solved before i.e task no 1827
 * some of the problems are solved there
 * like aligning the columns in the file - align method.
 * but the solution of previous task has flaws like lack of model of Product
 *
 * steps to the solution:
 *  - create model for products i.e. Product class
 *  - products will be stored in a list
 *    -- q: is possible to read only piece of data from file,
 *          store it in intermediate storage
 *          make operation on the chunk
 *          and then store it to a file?
 *     -- a: for simplicity of solution whole file will be read and then write
 *
 * @author Paweł Kłodziński
 */
public class Solution {
    public static void main(String[] args) {

        /*
        operational storage for products
         */
        ArrayList<Product> products;
        
        /*
        reads the path and file name from keyboard
         */
        BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
        String file = null;
        try {
            file = "/home/pawel/Desktop/a.txt";//keyboardReader.readLine();//
            keyboardReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        decide what to do upon main args submitted
        -u updates the data with specified by id productName price quantity
        -d performs the physical deletion of the product with the specified id
        (all data related to the passed id)
         */
        if (args.length >= 2){
            switch (args[0]){
                case "-u": //update the line with specified id
                    if (args.length == 5){
                        FileOperation fileOperation = new FileOperation();
                        products = fileOperation.loadProducts(file);

                        //updates the product with given id
                        for (Product p: products
                             ) {
                            if((p.getId()) == Integer.parseInt(args[1])){
                                p.setName(args[2]);
                                p.setPrice(Double.parseDouble(args[3]));
                                p.setQuantity(Integer.parseInt(args[4]));
                            }
                        }

                        //for test purposes list all products
                        /*for (Product p: products
                        ) {
                            System.out.println(p);
                        }*/

                        //save changed table into file
                        fileOperation.saveFile(file, products);
                    }
                    break;
                case "-d"://delete line with specified id
                    if (args.length == 2){
                        FileOperation fileOperation = new FileOperation();
                        products = fileOperation.loadProducts(file);

                        //removes the product with given id
                        Iterator iterator = products.iterator();
                        while (iterator.hasNext()){
                            Product p = (Product) iterator.next();
                            if (p.getId() == Integer.parseInt(args[1])){
                                iterator.remove();
                            }
                        }

                        //for test purposes list all products
                        /*for (Product p: products
                        ) {
                            System.out.println(p);
                        }*/

                        //save changed table into file
                        fileOperation.saveFile(file, products);
                    }
                    break;
            }
        }
    }
}
