package com.codegym.task.task17.task1711;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
CRUD 2

validation
-----------
Your solution to the task was better than 78% other students.
You solved it in 2 attempts. The average number of attempts for this task is 6.77.
This task has been completed by 444 students.

task
------------
Batch CrUD: multiple Creations, Updates, Deletions.

The program runs with one of the following sets of arguments:
-c name1 sex1 bd1 name2 sex2 bd2 ... -c Paweł m "06 09 1976"
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ... -u 1 Paweł m "06 09 1976"
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Argument values:
name (String)
sex ("m" or "f")
bd (birth date in the following format: 04 15 1990)
-c (adds all people with the specified arguments to the end of allPeople;
displays their ids in the appropriate order)
-u (updates the corresponding data of people with the specified ids)
-d (performs the logical deletion of the person with the specified id;
replaces all of its data with null)
-i (displays information about all people with the specified ids: name sex bd)

The id corresponds to the index in the list.
The birth date format is Apr 15 1990.
All the people should be stored in allPeople.
The order in which data is displayed corresponds to the order in which is input.
Be sure the program is thread safe (works correctly with multiple threads
without corrupting the data).
Use Locale.ENGLISH as the second argument for SimpleDateFormat.

Example output for the -i argument with two ids:
Washington m Apr 15 1990
Ross f Apr 25 1997

Requirements:
1. The Solution class must contain a public volatile List<Person> field called allPeople.
2. The Solution class must have a static block where two people are added to the allPeople list.
3. With the -c argument, the program must add all people with the specified arguments
to the end of the allPeople list, and display the id of each of them.
4. With the -u argument, the program must update the data of the people
with the specified ids in the allPeople list.
5. With the -d argument, the program must perform the logical deletion of the people
with the specified ids in the allPeople list.
6. With the -i argument, the program should display data about all the people
with the specified ids according to the format specified in the task.
7. The Solution class's main method must contain a switch statement based on args[0].
8. Each case label in the switch statement must have a synchronization block for allPeople.
*/

/**
 * this is the solution to task no 1711
 *
 * @author Paweł Kłodziński
 */
public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Donald Chump", new Date()));  // id=0
        allPeople.add(Person.createMale("Larry Gates", new Date()));  // id=1
    }

    public static void main(String[] args) {
        // Start here

        if(args.length >= 2) {
            switch (args[0]) {
                case "-c":
                    if ((args.length%3-1) == 0){
                        synchronized (allPeople){
                            for (int i = 1; i < args.length; i+=3) {
                                Person person = createPerson(args[i], Util.parseSex(args[i+1]), Util.parseDate(args[i+2]));
                                allPeople.add(person);
                                System.out.println(allPeople.size()-1);
//                                displayPerson(allPeople.size()-1);
                            }
                        }
                    }
                    break;
                case "-u":
                    synchronized (allPeople){
                        if ((args.length%4-1) == 0){
                            try {
                                for (int i = 1; i < args.length; i+=4) {
                                    int id = Integer.parseInt(args[i]);
                                    updatePerson(id, args[i+1], Util.parseSex(args[i+2]), Util.parseDate(args[i+3]));
//                                    displayPerson(1);
                                }
                            } catch (NumberFormatException ignored) {
        //                        ignored.printStackTrace();
                            }
                        }
                    }
                    break;
                case "-d":
                    synchronized (allPeople){
                        if (args.length - 1 <= allPeople.size()){
                            try {
                                for (int i = 1; i < args.length; i++) {
                                    int id = Integer.parseInt(args[i]);
                                    deletePerson(id);
                                }
                            } catch (NumberFormatException ignored) {
                            }
                        }
                    }
                    break;
                case "-i":
                    synchronized (allPeople) {
                        if (args.length - 1 <= allPeople.size()) {
                            try {
                                for (int i = 1; i < args.length; i++) {
                                    int id = Integer.parseInt(args[i]);
                                    displayPerson(id);
                                }
                            } catch (NumberFormatException ignored) {
                            }
                        }
                    }
                    break;
//                default:
//                    System.out.println("give parameter: " +
//                            "-c for create," +
//                            "-u for update," +
//                            "-d for delete," +
//                            "-i for information");
            }
        }
    }


    public static Person createPerson(String name, Sex sex, Date bd){
        Person person;

        if (sex == Sex.MALE){
            person = Person.createMale(name, bd);
        } else if (sex == Sex.FEMALE){
            person = Person.createFemale(name, bd);
        } else person = null;

        return person;
    }

    public static void updatePerson(int id, String name, Sex sex, Date bd){
        Person person = createPerson(name, sex, bd);
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


    public static void displayPerson(int id){
        System.out.println(allPeople.get(id));
    }

}
