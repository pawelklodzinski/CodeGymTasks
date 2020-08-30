package com.codegym.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
AmigoOutputStream

validation
-------------
Your solution to the task was better than 78% other students.
You solved it in 1 attempts. The average number of attempts for this task is 4.47.
This task has been completed by 511 students.

task
---------
1 Change the AmigoOutputStream class so that it wraps the FileOutputStream class. Use inheritance.
2 When the close() method is called, perform the following sequence of actions:
2.1 Call the flush() method.
2.2 Append the following text "CodeGym © All rights reserved." Use the getBytes() method.
2.3 Close the stream using the close() method.


Requirements:
1. Don't change the main method.
2. The AmigoOutputStream class must inherit the FileOutputStream class.
3. The AmigoOutputStream class's constructor should accept a FileOutputStream object.
4. All write(), flush(), and close() methods in the AmigoOutputStream class
must be delegated to the FileOutputStream object.
5. The close() method must first call the flush() method, append the additional text, and then close the stream.
*/

public class AmigoOutputStream extends FileOutputStream {
    //path and file name changed to test the solution
    public static String fileName = "//home//pawel//Desktop//a.txt"; //"C:/tmp/result.txt" //this is the original file path and name;

    //text to be appended to fulfill the 5th requirement
    public static String appendText = "CodeGym © All rights reserved.";

    //the object to be wrapped
    FileOutputStream fileOutputStream;

    public static void main(String[] args) throws FileNotFoundException{
        new AmigoOutputStream(new FileOutputStream(fileName));
        //the close() method below is used to test the functionality of modified version of method
       /* try {
            new AmigoOutputStream(new FileOutputStream(fileName)).close();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /**
     * Constructor of a wrapper (decorator) accepts the wrapped object
     * @param fileOutputStream the stream to be wrapped
     * @throws FileNotFoundException declared in {@code FileOutputStream}
     */
    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = fileOutputStream;
    }

    //below are the methods that this task requires to override
    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    /**
     * The modified version of close method defined in {@code FileOutputStream}
     * @throws IOException declared in {@code FileOutputStream}
     */
    @Override
    public void close() throws IOException {
        flush();
        write(appendText.getBytes());
        fileOutputStream.close();
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }
}
