class Pen { //pen class
    private String color;   //attributes
    private int tip;
    
    // Setter -> to set value means modifies values
    void setColor(String newColor){ //functions
        color = newColor;
    }

    void setTip(int newTip){
        tip = newTip;
    }

    // Getter -> to get value means return values
    String getColor(){
        return this.color;
    }

    int getTip(){
        return this.tip;
    }

    // this keyword is used to refer current object 
}

class Student{
    int age;
    String name;

    Student(String name, int age){
        this.name = name; //refer to student object
        this.age = age;
    }

    void display(){
        System.out.println("Name: " + this.name + ", Age: " + this.age);
    }
}

public class GetAndSet {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        p1.setTip(8);
        System.out.println(p1.getTip());


        Student s = new Student("Jaykant", 22);
        s.display();
    }
}
