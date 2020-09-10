package com.codegym.task.task18.task1815;

import java.util.List;

/* 
Table

validation
-------------
Your solution to the task was better than 72% other students.
You solved it in 1 attempts. The average number of attempts for this task is 3.93.
This task has been completed by 503 students.

task
------------
Change the TableInterfaceWrapper class so that it wraps TableInterface.
The setModel method should display the number of elements in the new list before updating the model.
The getHeaderText method should return the text in upper case. Use the toUpperCase() method.

Requirements:
1. The TableInterfaceWrapper class must implement the TableInterface interface.
2. The TableInterfaceWrapper class must initialize a TableInterface field in the constructor.
3. The setModel() method should display the number of elements in the new list before updating the model.
4. The getHeaderText() method must return the text in uppercase.
5. The setHeaderText() method must set the header text without making changes.
*/


/**
 * Solution to task 1815
 *
 * Decorator pattern (wrapper) implementation. Here {@code TableInterfaceWrapper}
 * decorates the interface {@code TableInterface}
 *
 * @author Paweł Kłodziński
 */
public class Solution {
    public class TableInterfaceWrapper implements TableInterface {

        /* the wrapped object of type {@code TableInterface} */
        TableInterface tableInterface;

        /**
         * Constructor initializes the {@code TableInterface} field
         * @param tableInterface the object to be decorated
         */
        public TableInterfaceWrapper(TableInterface tableInterface) {
            this.tableInterface = tableInterface;
        }

        /**
         * Displays the number of elements in the new list before updating the model
         * @param rows number of elements in the list
         */
        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());//displays the number of elements
            tableInterface.setModel(rows);
        }

        /**
         * Returns the text in uppercase
         * @return the text in uppercase
         */
        @Override
        public String getHeaderText() {
            return tableInterface.getHeaderText().toUpperCase();//text in uppercase
        }

        /**
         * Sets the header text without making changes
         * @param newHeaderText the original header text
         */
        @Override
        public void setHeaderText(String newHeaderText) {
            tableInterface.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}