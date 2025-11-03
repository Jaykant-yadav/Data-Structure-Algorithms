public class Abstraction {
    // Hiding all the unnecessary details and showing only the important part to the
    // user
    // Abstract Classes :- Abstraction means hiding the internal implementation
    // details and showing only the essential features of an object.
    // Interfaces:-
    public static void main(String[] args) {
        Horse H = new Horse();
        // Animal -> Horse
        H.eat();
        H.walk();

        Chicken c = new Chicken();
        // Animal -> Chicken
        c.eat();
        c.walk();

        // Animal Dog = new Animal(); // doesn't create a instance of abstract class

        Mustang myHorse = new Mustang();
        // Animal -> Horse -> Mustang
    }
}

abstract class Animal{
    String color;
    // create constructor Animal abstract class
    Animal(){ 
        System.out.println("Animal constructor called.......");
    }

    void eat(){
        System.out.println("animal eats");
    }

    abstract void walk();
}

class Horse extends Animal{
    Horse(){
        System.out.println("Horse constructor called.......");
    }
    void changeColor(){
        color = "dark brown";
    }

    void walk() {
        System.out.println("walks on 4 legs");        
    }
}

class Mustang extends Horse{
    Mustang(){
        System.out.println("Mustang constructor called.........");
    }
}

class Chicken extends Animal{
    Chicken(){
        System.out.println("Chicken constructor called.......");
    }
    void changeColor(){
        color = "yellow";
    }

    void walk(){
        System.out.println("walks on 2 legs");
    }
}
