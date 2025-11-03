public class Inheritance {
    // Inheritance is when properties & methods of base class are passed on to a drived class.

    // Types of Inheritance
    // 1. Single Level Inheriteance -> One class inherits from another (class B extends A)
    // 2. Multi Level Inheritance -> Chain of inheritance (A -> B -> C)
    // 3. Hierarchial Inheritance -> Multiple classes inherit from the same parent (B extends A, C extends A)
    // 4. Hybrid Inheritance -> A class implements multiple interfaces (class C implements A, B)
    public static void main(String[] args) {
        Fish sharks = new Fish();// |
        sharks.eat();            // |  Single Level Inheritance
        sharks.breathe();        // |

        Dog dobby = new Dog();   // |
        dobby.eat();             // |  Multi Level Inheritance
        dobby.legs = 4;          // |
        System.out.println(dobby.legs);

        Bird peacock = new Bird();          //|
        peacock.eat(); // animal class      //| Hierarchial Inheritance
        peacock.breathe(); //animal class   //|
        peacock.fly();
    }
}

// Base Class
class Animal{
    String color;

    void eat(){
        System.out.println("eats");
    }

    void breathe(){
        System.out.println("breathe");
    }
}

// Drived Class
class Mammal extends Animal{
    int legs;

    void walk(){
        System.out.println("walks");
    }
}


class Bird extends Animal{
    void fly(){
        System.out.println("fly");
    }
}

// Drived Class
class Fish extends Animal{
    int fins;
    
    void swim(){
        System.out.println("swin in water");
    }
}

class Dog extends Mammal{
    String breed;
}