// polymorphism allows a single entity (method, object, or reference) to behave differently based on the context.
// Polymorphism literally means “many forms.”

// Types of Polymorphism in Java
// Compile-time Polymorphism (Method Overloading)
// Runtime Polymorphism  (Method Overriding)
public class Polymorphism {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(4, 8));
        System.out.println(calc.sum(4.8f, 7.9f));
        System.out.println(calc.sum(4, 8, 4));

        Dear d = new Dear();
        d.eats();
    }
}

// Method overloading:- Multiple functions with the same name but different parameters
class Calculator{
    int sum(int a, int b){
        return a + b;
    }

    float sum(float a, float b){
        return a + b;
    }

    int sum(int a, int b, int c){
        return a + b + c;
    }
}

// Method overriding:- Parent and child classes both contain the same function with a different definiton
class Animal{
    void eats(){
        System.out.println("eats everything");
    }
}

class Dear extends Animal{
    void eats(){
        System.out.println("eats grass");
    }
}


// Packages in Java :- Packages is a group of similar types of classes, Interfaces and sub-packages
