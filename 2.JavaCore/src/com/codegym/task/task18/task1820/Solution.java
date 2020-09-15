package com.codegym.task.task18.task1820;

/* 
Rounding numbers

validation
-----------
Your solution to the task was better than 72% other students.
You solved it in 1 attempts. The average number of attempts for this task is 4.73.
This task has been completed by 439 students.

task
------------
Read 2 file names from the console.
The first file contains real (fractional) numbers, separated by spaces. For example, 3.1415.
Round the numbers to integers and write them, separated by spaces, to the second file.
Close the streams.

The rounding should work like this:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4

Requirements:
1. The program should read a file name twice from the console.
2. Create an input stream for the first file. Create an output stream for the second file.
3. Read the numbers from the first file, round them, and write them to the second file, separated by spaces.
4. The rounding must be performed as indicated in the task.
5. The file streams must be closed.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sourceFile = "";
        String targetFile = "";
        try {
            //read paths and file names
            sourceFile = reader.readLine();//"//home//pawel//Desktop//a.txt";//reader.readLine();//
            targetFile = reader.readLine();//"//home//pawel//Desktop//b.txt";//reader.readLine();//
            reader.close();
        } catch (IOException e) {
            System.out.println("cannot read from console");
        }

        /**
         * how to separate the numbers? recognizing the space character from bytes being streamed
         * what ready to use class converts bytes into characters? Readers like FileReader or InputStreamReader
         * what is the auxiliary storage to save the numbers in before converting? ArrayList<Double>
         * how to convert the numbers? try casting to int but is truncates only the fractions, better use Math.round
         */


        //container to store original fraction numbers
        ArrayList<Double> fractions = new ArrayList<>();
        //container to store integers after conversion from Doubles
        ArrayList<Integer> integers = new ArrayList<>();

        FileReader fr = null;
        try {
            fr = new FileReader(sourceFile);
        } catch (FileNotFoundException e) {
            System.out.println("cannot find file at given location");
        }

        String source = "";
        int i;
        try {
            while ((i = fr.read()) != -1){
                if (i != 32){
                    source += (char) i;//completes the whole number
                }else {
                    fractions.add(Double.parseDouble(source));//stores number
                    source = "";//resets string
                }
            }
            fractions.add(Double.parseDouble(source));//saves last faction
            fr.close();//closes the stream

        }
        catch (IOException e) {
            System.out.println("cannot read from file");
        }
        /**
         * test if the source is saved
         */
//        for (Double d: fractions
//             ) {
//            System.out.println(d);
//        }

        //convert Doubles into int
        for (double d: fractions
             ) {
            integers.add((int) Math.round(d));//and saves to integers
        }

        /**
         * test the results
         */
//        for (int j: integers
//             ) {
//            System.out.println(j);
//        }

        /**
         * save data to target file
         */

        String target = "";
        for (int k: integers
        ) {
            target += k + " ";
        }

//        System.out.println(target);//tests if target is complete

        FileWriter fw = null;
        try {
            fw = new FileWriter(targetFile);
            fw.write(target);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            System.out.println("cannot write to target file");
        }



    }
}
