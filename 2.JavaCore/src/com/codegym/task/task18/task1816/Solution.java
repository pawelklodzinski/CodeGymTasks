package com.codegym.task.task18.task1816;

/* 
ABCs

validation
----------
Your solution to the task was better than 62% other students.
You solved it in 1 attempts. The average number of attempts for this task is 2.91.
This task has been completed by 549 students.

task
----------
The first parameter of the main method is a file name.
Count the letters of the English alphabet in the file.
Display the number of letters.
Close the streams.

Requirements:
1. You don't need to read anything from the console.
2. Create a stream to read from the file passed as the first argument of the main method.
3. You need to count the letters of the English alphabet in the file and display the number.
4. You must count both uppercase and lowercase letters.
5. The stream used to read the file must be closed.

*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream(args[0]);//args[0] firs argument is a file name
            int i;
            int count = 0;
            while ((i = fis.read()) != -1 ){
                //using ASCII char table to filter only english letters
                //ASCII decimal value between 65 and 90 gives upper case english letter
                //ASCII decimal value between 97 and 122 gives lower case english letter
                if ((((char)i) >= 65 && ((char)i) <= 90) || (((char)i) >= 97 && ((char)i) <= 122)){
                    count++;
//                    System.out.print((char) i);//prints the characters with test passed
                }
            }
            fis.close();//closes the stream
            System.out.println(count);//displays the number of all characters in the file
        } catch (FileNotFoundException ignored) {
            System.out.println("file not found");
        } catch (IOException ignored) {
            System.out.println("cannot read from file");
        }


    }
}
