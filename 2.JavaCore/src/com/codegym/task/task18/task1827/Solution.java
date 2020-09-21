package com.codegym.task.task18.task1827;

/* 
Prices

validation
-----------
Your solution to the task was better than 53% other students.
You solved it in 3 attempts. The average number of attempts for this task is 7.33.
This task has been completed by 307 students.

task
----------

CrUD for a table inside a file.
Read a file name for CrUD operations from the console.

The program is started with the following arguments:
-c productName price quantity

Argument values:
where id is 8 characters.
productName is 30 characters.
price is 8 characters.
quantity is 4 characters.
-c adds the product with the specified parameters to the end of the file,
and generates an id by incrementing the maximum id found in the file.

The file data is stored in the following order (without separating spaces):
id productName price quantity

Each data field is padded with spaces up to its length.

Before adding a new line, re-write all of its contents to the file.

Example:
19847   Swim trunks, blue             159.00  12
198479  Swim trunks, black with printe173.00  17
19847983Snowboard jacket with reflecti10173.991234

Requirements:
1. The program should read a file name for CrUD operations from the console.
2. The Solution class should not use static variables.
3. When you run the program without arguments, the product list must remain unchanged.
4. When the program is run with the arguments "-c productName price quantity",
a new line with the corresponding product should be added to the end of the file.
5. The product must have the next id after the maximum id found in the file.
6. The format of the new product line must precisely match that format specified in the task.
7. The file streams must be closed.
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * this is the solution to task no 1827
 *
 * q: what is the most important issue in this task?
 * a: figure out what is the maximum of id
 *
 * steps to find the maximum
 * - read all ids
 * - store it in an array
 * - get the max value
 *
 *
 * @author Paweł Kłodziński
 */
public class Solution {
    public static void main(String[] args) throws Exception {

        // TODO: 9/21/20 rewrite the solution in the fashion of
        //  model i.e. Product()
        //  and persistence i.e. Crud()
        /*
        reads file name from console
         */
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consoleReader.readLine();//"/home/pawel/Desktop/a.txt";//

        //for tests put new data into different file
//        String fileTest = "/home/pawel/Desktop/b.txt";//consoleReader.readLine();//
        consoleReader.close();

        /*
        gets max id
         */
        //storage for all ids
        ArrayList<Integer> ids = new ArrayList<>();

        //reads file by lines
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = fileReader.readLine()) != null){
            // TODO: 9/21/20 catch Exception if there is an empty line in file
            ids.add(Integer.parseInt(line.substring(0, 8).trim()));
        }
        fileReader.close();

        //gets the max
        int max = Collections.max(ids);

        /*
        for test print all ids
         */
//        for (int i: ids
//             ) {
//            System.out.println(i);
//        }

        /*
        ads data to file
        main arguments are separated by spaces
         */

        //creates output stream to write to
        //check first if program arguments are given at all
        if (args.length > 0 && args[0].equals("-c") && args[1] != null && args[2] != null && args[3] != null){

            //put new data into different file - only for tests
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName, true));
            String lineWrite = align(setNext(max), 8)
                    + align(args[1], 30)
                    // TODO: 9/21/20 create a validation methods
                    + align(validatePrice(args[2]), 8)
                    + align(validateQuantity(args[3]), 4);
            fileWriter.newLine();
            fileWriter.write(lineWrite);
            fileWriter.flush();
            fileWriter.close();
        }
    }

    private static String validateQuantity(String arg) {
        String result = arg;
        return result;
    }

    private static String validatePrice(String arg) {
        String result = arg;
        return result;
    }


    /*
    formats data to be written
     */
    //id is 8 characters

    /**
     * formats the id to be written to file
     * @param max is the last id
     * @return returns the formatted id ready to write to file
     * @throws FileFullException fired if the file is full i.e. no more id can be calculated
     */
    private static String setNext(int max) throws FileFullException {
        String result = "";
        int nexId = max + 1;
        if (nexId <= 99999999){
            result = String.valueOf(nexId);
        }else{
            throw new FileFullException("File is full");
        }
        return result;
    }

    /**
     * returns String aligned to right with spaces
     * or trim if String s is longer then total no of characters
     * @param s String to be padded
     * @param n total no of characters
     * @return returns String with padded with spaces to the right
     */
    private static String align(String s, int n){
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
}
