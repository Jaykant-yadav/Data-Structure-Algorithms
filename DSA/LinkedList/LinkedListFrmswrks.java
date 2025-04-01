package DSA.LinkedList;
import java.util.LinkedList;

public class LinkedListFrmswrks {
    public static void main(String[] args) {
        // Create - Object int, float, boolean -> Integer, Float, Character
        LinkedList<Integer> ll = new LinkedList<>();

        // Add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        // 0-> 1-> 2
        System.out.println(ll);

        // remove
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
    }
}
