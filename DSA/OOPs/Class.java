
// A class is a blueprint or template of objects
class Pen { //pen class
    String color;   //attributes
    int tip;
    
    void setColor(String newColor){ //functions
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }
}

class Student { //student class
    String name;
    int age;
    float percentage; //cgpa

    void calcPercentage(int phy, int chem, int math){
        percentage = (phy + chem + math) / 3;
    }
}

public class Class {
    public static void main(String[] args) {
        Pen p1 = new Pen(); // to create in memory place
        // p1 a pen object
        p1.setColor( "Blue");
        p1.setTip(5);
        System.out.println(p1.color);
        System.out.println(p1.tip);

        // Student object
        Student s1 = new Student();
        s1.calcPercentage(49, 88, 95);
        System.out.println(s1.percentage);
    }
}
