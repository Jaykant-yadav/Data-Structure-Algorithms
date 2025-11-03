public class Super {
    // Super keyword is used to refer immediate parent class object
    /* 
     * - to access parent's properties, functions, constructor
     */
    public static void main(String[] args) {
        Horse h = new Horse();
        System.out.println(h.color);
    }
}

class Animal{
    String color;
    Animal(){
        System.out.println("Animal conatructor is called.......");
    }
}

class Horse extends Animal{
    Horse(){
        super.color = "Brown";
        System.out.println("horse constructor is called..........");
    }
}


