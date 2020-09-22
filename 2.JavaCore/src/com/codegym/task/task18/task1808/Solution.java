package com.codegym.task.task18.task1808;

/* 
Splitting a file

validation
-----------
Your solution to the task was better than 65% other students.
You solved it in 2 attempts. The average number of attempts for this task is 6.65.
This task has been completed by 556 students.

task
-----------
Read 3 file names from the console: file1, file2, file3.
Split file1 as follows:
Write the first half of its bytes to file2,and write the second half of its bytes to file3.
If the number of bytes in file1 is odd, then file2 should contain the larger half.
Close the streams.

Requirements:
1. The program should read a file name three times from the console.
2. Use FileInputStream to read from a file, and use FileOutputStream to write to files.
3. The first half of the bytes in the first file must be written to the second file.
4. The second half of the bytes in the first file must be written to the third file.
5. The FileInputStream and FileOutputStream must be closed.
*/

import java.io.*;

/**
 * this is the solution to task 1808
 *
 * steps to solve the task
 *  - get the total no of bytes noOfBytes using available{} method of FileInputStream
 *  - check if the noOfBytes is odd or even
 *  - simplify the process by reading and writing to streams with only one buffer which probably limits
 *  the solution to small files what contradicts with using the buffer
 *
 * @author Paweł Kłodziński
 */
public class Solution {
    public static void main(String[] args) {

        /*
        get the paths and file names to read from and write to from keyboard
         */
        BufferedReader keyboardReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = null;
        String file2 = null;
        String file3 = null;
        try {
            file1 = keyboardReader.readLine();//"/home/pawel/Desktop/a.txt";//
            file2 = keyboardReader.readLine();//"/home/pawel/Desktop/b.txt";//
            file3 = keyboardReader.readLine();//"/home/pawel/Desktop/c.txt";//
            keyboardReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
        open the streams
         */
        FileInputStream fileInputStream1 = null;
        FileOutputStream fileOutputStream2 = null;
        FileOutputStream fileOutputStream3 = null;
        try {
            fileInputStream1 = new FileInputStream(new File(file1));
            fileOutputStream2 = new FileOutputStream(new File(file2));
            fileOutputStream3 = new FileOutputStream(new File(file3));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            // get the no of bytes and calculate split
            int noOfBytes = fileInputStream1.available();//total no of bytes
            int secondHalf = noOfBytes / 2;//the smaller half
            int firstHalf = noOfBytes - secondHalf;//the bigger half

            //create a buffer
            byte[] byteBuffer = new byte[noOfBytes];
            //fill the buffer
            fileInputStream1.read(byteBuffer);
            fileInputStream1.close();

            //write the first half
            fileOutputStream2.write(byteBuffer, 0, firstHalf);
            fileOutputStream2.flush();
            fileOutputStream2.close();

            //write the second half
            fileOutputStream3.write(byteBuffer, firstHalf, secondHalf);
            fileOutputStream3.flush();
            fileOutputStream3.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
