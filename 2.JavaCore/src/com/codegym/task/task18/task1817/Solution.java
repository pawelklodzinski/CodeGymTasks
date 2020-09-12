package com.codegym.task.task18.task1817;

/* 
Spaces

validation
----------
Your solution to the task was better than 86% other students.
You solved it in 1 attempts. The average number of attempts for this task is 6.08.
This task has been completed by 499 students.

task
-------------
The first parameter of the main method is a file name.
Display the ratio of the number of spaces to the number of all characters. For example, 10.45.
1. Count all the characters (n1).
2. Count the spaces (n2).
3. Display n2/n1*100, rounding to 2 decimal places.
4. Close the streams.

Requirements:
1. You don't need to read anything from the console.
2. Create a stream to read from the file passed as the first argument of the main method.
3. Calculate and display the ratio of the spaces to all characters in the file.
4. The displayed value must be rounded to 2 decimal places.
5. The stream used to read the file must be closed.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try {
            //args[0] is the first parameter of main method
            //run the program with file path and file name as one parameter
            FileInputStream fis = new FileInputStream(args[0]);
            int totalCount = 0;
            int spaceCount = 0;
            int i;
            while ((i = fis.read()) != -1){//-1 if the end of the file is reached
                if (i >= 32) {//all characters except auxiliary ones like CR (carriage return)
                    totalCount++;
                    if (i == 32) {//space
                        spaceCount++;
                    }
//                    System.out.print((char) i);//comment before validation
                }
            }
            fis.close();
//            System.out.println();//comment before validation
//            System.out.println(spaceCount);//comment before validation
//            System.out.println(totalCount);//comment before validation
            double result = spaceCount /(double) totalCount* 100;
            System.out.printf("%.2f", result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
