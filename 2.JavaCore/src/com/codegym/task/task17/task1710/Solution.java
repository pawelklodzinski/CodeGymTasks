package com.codegym.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD

validation
-----------
Your solution to the task was better than 81% other students.
You solved it in 2 attempts. The average number of attempts for this task is 8.54.
This task has been completed by 456 students.

task
----------
CrUD: Create, Update, Delete.

The program runs with one of the following sets of arguments:
-c name sex bd
-u id name sex bd
-d id
-i id

Argument values:
name (String)
sex ("m" or "f")
bd (birth date in the following format: "04 15 1990")
-c (adds a person with the specified arguments to the end of allPeople; displays the id on the screen)
-u (updates the data of the person with the specified id)
-d (performs the logical deletion of the person with the specified id; replaces all of its data with null)
-i (displays information about the person with the specified id: name sex (m/f) bd (format Apr 15 1990))

The id corresponds to the index in the list.
All the people should be stored in allPeople.
Use Locale.ENGLISH as the second argument for SimpleDateFormat.

Example arguments:
-c Washington m "04 15 1990"

Example output for the -i argument:
Washington m Apr 15 1990


Requirements:
1. The Solution class must contain a public static List<Person> field called allPeople.
2. The Solution class must have a static block where two people are added to the allPeople list.
3. When you start the program with the -c argument, the program should add the person
with the specified arguments to the end of the allPeople list and display the id (index).
4. When you run the program with the -u argument, the program must update the data of the person
with the specified id in the allPeople list.
5. When you run the program with the -d argument, the program must perform the logical deletion
the person with the specified id in the allPeople list.
6. When you run the program with the -i argument, the program should display the data
about the person with the specified id in accordance with the format given in the task.
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<>();
    public static DateFormat parseDateFormat = new SimpleDateFormat("MM dd yyyy", Locale.ENGLISH);
    public static DateFormat displayDateFormat = new SimpleDateFormat("MMM dd yyyy", Locale.ENGLISH);

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        // Start here

        if(args.length != 0) {
            switch (args[0]) {
                case "-c":
                    createPerson(args[1], args[2], args[3]);
                    break;
                case "-u":
                    try {
                        int id = Integer.parseInt(args[1]);
                        updatePerson(id, args[2], args[3], args[4]);
                    } catch (NumberFormatException ignored) {
                    }
                    break;
                case "-d":
                    try {
                        int id = Integer.parseInt(args[1]);
                        deletePerson(id);
                    } catch (NumberFormatException ignored) {
                    }
                    break;
                case "-i":
                    try {
                        int id = Integer.parseInt(args[1]);
                        displayPerson(id);
                    } catch (NumberFormatException ignored) {
                    }
                    break;
                default:
                    System.out.println("give parameter: " +
                            "-c for create," +
                            "-u for update," +
                            "-d for delete," +
                            "-i for information");
            }
        }


 /*       //test for -c
        addPerson("Paweł", "m", "06 09 1976");

        //test for -u
        //-u id name sex bd
        updatePerson(0, "Ewa", "f", "08 08 1976");

        //test for -d
        deletePerson(1);

        //test for -i
        displayPerson(1);*/
    }

    //Argument values:
    //name (String)
    //sex ("m" or "f")
    //bd (birth date in the following format: "04 15 1990")
    //-c Washington m "04 15 1990"
    public static void createPerson(String name, String sex, String bd){
        Person person;
        Date date;
        try {
            date = parseDateFormat.parse(bd);
        } catch (ParseException e) {
            return;
        }
        if (sex.equals("m")){
            person = Person.createMale(name, date);
        }else if (sex.equals("f")){
            person = Person.createFemale(name, date);
        } else return;

        allPeople.add(person);
        System.out.println(allPeople.indexOf(person));
    }


    public static void updatePerson(int id, String name, String sex, String bd){
        Date date;
        try {
            date = parseDateFormat.parse(bd);
        } catch (ParseException e) {
            System.out.println("cannot read date");
            return;
        }
        Person person = sex.equals("m")? Person.createMale(name, date): Person.createFemale(name, date);
        allPeople.set(id, person);
//        System.out.println(allPeople.get(id).toString());//for test purposes
    }

    public static void deletePerson(int id){
        Person person = allPeople.get(id);
        person.setName(null);
        person.setSex(null);
        person.setBirthDate(null);
        allPeople.set(id, person);
    }

    //-i id
    //Washington m Apr 15 1990
    public static void displayPerson(int id){
        Person p = allPeople.get(id);
        System.out.println(p.toString());
    }
}
