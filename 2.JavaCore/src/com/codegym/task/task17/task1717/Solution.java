package com.codegym.task.task17.task1717;

/* 
Superfluous synchronization

validation
-------------
Your solution to the task was better than 79% other students.
You solved it in 1 attempts. The average number of attempts for this task is 3.06.
This task has been completed by 550 students.

task
----------
The synchronized keyword significantly slows a program,
so remove unnecessary synchronized statements in methods.

Requirements:
1. The Solution class's append(CharSequence s) method should not be synchronized.
2. The Solution class's appendThis(Solution s) method must be synchronized.
3. The Solution class's writeObject(java.io.ObjectOutputStream s) method must be synchronized.
4. The Solution class's readObject(java.io.ObjectInputStream s) method should not be synchronized.
5. The Solution class's main(String[] args) method should not be synchronized.
6. There should not be synchronized blocks in the Solution class.
*/

//There should not be synchronized blocks
public class Solution {
    char[] value;
    int count;

    //should not be synchronized
    public Solution append(CharSequence s) {
//        synchronized (Solution.class) {
            if (s == null) {
//                synchronized (this) {
                    s = "null";
//                }
            }

            if (s instanceof String) {
//                synchronized (this) {
                    return this.append((String) s);
//                }
            }

            if (s instanceof Solution) {
//                synchronized (this) {
                    return this.appendThis((Solution) s);
//                }
            }
//        }
        return this.append(s);
    }

    //must be synchronized
    public synchronized Solution appendThis(Solution s) {
        // Do something here....
//        synchronized (this) {
            return this;
//        }
    }

    private static final java.io.ObjectStreamField[] serialPersistentFields =
            {
                    new java.io.ObjectStreamField("value", char[].class),
                    new java.io.ObjectStreamField("count", Integer.TYPE),
                    new java.io.ObjectStreamField("shared", Boolean.TYPE),
            };

    //must be synchronized
    private synchronized void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        java.io.ObjectOutputStream.PutField fields = s.putFields();
//        synchronized (fields) {
            fields.put("value", value);
            fields.put("count", count);
            fields.put("shared", false);
//        }
//        synchronized (s) {
            s.writeFields();
//        }
    }

    //should not be synchronized
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
//        synchronized (new java.io.IOException()) {
            java.io.ObjectInputStream.GetField fields = s.readFields();
            value = (char[]) fields.get("value", null);
            count = fields.get("count", 0);
//        }
    }

    //should not be synchronized
    public static void main(String[] args) {

    }
}
