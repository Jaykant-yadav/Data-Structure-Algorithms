public class Interfaces {
    // Interface: Interface is a blueprint of a class
    // - Achieve Multiple Inheritance -> (A, B -> extends C)
    // - Total Abstraction (Interfaces)

    // Properties
    /* 
     * - All Methods are public, abstact & without implementation
     * - Used to achieve total abstraction
     * - Variables in the interface are final, public and static
     */
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();

        Rook r = new Rook();
        r.moves();

        // Multiple Inheritance
        C obj = new C();
        obj.display();
        obj.show();
    }
}

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal (in all 4 dirns)");
    }
}

class Rook implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right");
    }
}

class King implements ChessPlayer{
    public void moves(){
        System.out.println("up, down, left, right, diagonal - (by 1 step)");
    }
}


// Multiple Inheritance
interface A{
    void display();
}

interface B{
    void show();
}

class C implements A, B{
    public void display(){
        System.out.println("Display from A");
    }

    public void show(){
        System.out.println("show from B");
    }
}
