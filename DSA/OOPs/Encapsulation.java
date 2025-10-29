// Wrapping up of data and method under a single unit
class Student {
    // Step 1: Private variables (data hiding)
    private String name;
    private int age;

    // Step 2: public setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }

    // Step 3: public getter methods
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

/*
 * Encapsulation means binding data (variables) and methods (functions) that
 * operate on that data into a single unit (class) and restricting direct access
 * to the data from outside the class.
 * 
 * Simply put: it’s data hiding + data control inside a class.
 */

public class Encapsulation {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Jay");
        s1.setAge(22);

        System.out.println("Name: " + s1.getName());
        System.out.println("Age: " + s1.getAge());
    }
}

/*
 * Why Encapsulation?
 * 
 * ✅ To protect the data from unauthorized access
 * ✅ To control how data is modified
 * ✅ To make the class easy to maintain and flexible
 * ✅ To achieve data abstraction
 * 
 * 🔹 How Encapsulation Works in Java
 * Declare variables as private (cannot be accessed directly).
 * Provide public getter and setter methods to access and modify them safely.
 */

/*
 * Short Definition for Interview:
 * 
 * Encapsulation in Java is the process of wrapping data and methods into a
 * single unit (class) and restricting direct access to data by making variables
 * private and providing public getter and setter methods.
 */
