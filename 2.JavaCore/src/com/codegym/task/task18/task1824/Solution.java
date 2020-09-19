package com.codegym.task.task18.task1824;

/* 
Files and exceptions

validation
------------
Your solution to the task was better than 66% other students.
You solved it in 1 attempts. The average number of attempts for this task is 3.83.
This task has been completed by 435 students.

task
---------
Read file names from the console.
If the file does not exist (i.e. an invalid file name is given),
then catch the FileNotFoundException, display the invalid file name, and exit the program.
Close the streams.
Don't use System.exit();

Requirements:
1. The program should read file names from the console.
2. You need to create an input stream for each file.
3. If the file does not exist, the program must catch the FileNotFoundException.
4. After catching the exception, the program should display the file name and exit.
5. The file input streams must be closed.
6. Don't use "System.exit();".
*/

import java.io.*;

/**
 * this is the solution to task no 1824
 *
 * steps to solution
 * - read in loop file paths and names using BufferedRead
 * - open input streams for all files and close it
 * - if one of file does not exists catch the exception, close reader stream and break the loop
 *
 * @author Paweł Kłodziński
 */
public class Solution {
    public static void main(String[] args) {

        //opens stream to read form keyboard
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String fileName = null;
            FileInputStream fileInputStream;
            try {
                fileName = reader.readLine();//"/home/pawel/Desktop/a.txt";//

                //opens the stream
                fileInputStream = new FileInputStream(fileName);

                //closes the stream
                fileInputStream.close();
            } catch (FileNotFoundException e) {

                //displays file path and name
                System.out.println(fileName);

                //this is exception situation, do not need reader any more
                try {
                    reader.close();
                } catch (IOException ignored) {
                }

                //terminates the loop
                break;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
