public class Static {
    // Static Keyword: in Java is used to share the same variable or method of a
    // given class.
    /*
     * - Properties: int, float, boolean or more
     * - Function
     * - Blocks
     * - Nested class
     */

    // Static Blocks
    static {
        System.out.println("Static block executed before main()");
    }

    public static void main(String[] args) {
        Student s1 = new Student();
        s1.schoolName = "IIT Mumbai";

        Student s2 = new Student();
        System.out.println(s2.schoolName);

        System.out.println(MathUtils.square(8));

    }
}

// Static variables
class Student {
    String name;
    int roll;

    static String schoolName;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}

// Static methods
class MathUtils {
    static int square(int x) {
        return x * x;
    }
}
