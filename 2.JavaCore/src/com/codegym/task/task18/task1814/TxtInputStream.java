package com.codegym.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;

/* 
UnsupportedFileName

validation
-------------
Your solution to the task was better than 64% other students.
You solved it in 1 attempts. The average number of attempts for this task is 3.69.
This task has been completed by 502 students.

task
-------------
Change the TxtInputStream class so that it only works with txt files (* .txt).
For example, first.txt or name.1.part3.txt.
If a non-txt file is passed (e.g. file.txt.exe), then the constructor should throw
an UnsupportedFileNameException.
Think about what else you need to do if an exception is thrown.

Requirements:
1. The TxtInputStream class must inherit the FileInputStream class.
2. If a txt file is passed to the constructor, TxtInputStream should behave like a regular FileInputStream.
3. If a non-txt file is passed to the constructor, an UnsupportedFileNameException should be thrown.
4. If an exception is thrown, then you must also call super.close().
*/

/**
 * Solution to task 1814
 * @author Paweł Kłodziński
 */
public class TxtInputStream extends FileInputStream {

    /**
     * Constructor redefined to accept only *.txt files
     * @param fileName the system dependent file name
     * @throws IOException if the file does not exists or can not close the stream
     * @throws UnsupportedFileNameException if a non-txt file is passed
     */
    public TxtInputStream(String fileName) throws IOException, UnsupportedFileNameException {
        super(fileName);
        if (!fileName.endsWith(".txt")){
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) {
    }
}

