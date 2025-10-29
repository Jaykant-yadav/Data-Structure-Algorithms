
// Constructors is a special method which is invoked automatically
// at the time of method creation.

// Types of constuctors
/* 1. Non-parameterized
 * 2. Parameterized
 * 3. Copy Constructor
 */

//  Shallow copy -> to copy refferences don't create new object, new address
//  -> changes always reflect
// Deep Copy -> deep copy create new addree, new object, new memory
// -> changes don't reflect

public class Constructors {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Jaykant";
        s1.roll = 88;
        s1.password = "Jay7462@@";
        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 80;

        Student s2 = new Student("Jaykant");
        // System.out.println(s2.name);
        Student s3 = new Student(88);
        // System.out.println(s3.roll);

        Student s4 = new Student(s1);
        s4.password = "XYZ";

        s1.marks[2] = 100; // changes 
        for(int i=0; i<3; i++){
            System.out.println(s4.marks[i]); //100, 90, 100
        }
    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    // Non-parameterized
    Student() {
        marks = new int[3];
        System.out.println("Constructor is called...");
    }

    // Parameterized
    Student(String name){
        marks = new int[3];
        this.name = name;
    }

    Student(int roll){
        marks = new int[3];
        this.roll = roll;
    }

    // Copy constructor -> s1 of object to copy in -> s4 in new object
    // shallow copy constructor
    /* Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        this.marks = s1.marks; 
    } */

    // Deep copy constructor
    Student(Student s1){
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;
        for(int i=0; i<marks.length; i++){
            this.marks[i] = s1.marks[i];
        }
    }
}
