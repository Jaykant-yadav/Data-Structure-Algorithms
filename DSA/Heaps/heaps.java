package DSA.Heaps;
import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class heaps {
    // Object Store in Priority Queues
    static class Student implements Comparable<Student> { //Overriding
        // Comparable is a Interface and Student Class of Object
        String name;
        int rank;

        public Student(String name, int rank){ // Constructor
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            return this.rank - s2.rank; //compare on the bases of rank
        }
    }
    public static void main(String[] args) {
        // Priority Queues Create
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 1, 2, 3, 4, 5

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 5, 4, 3, 2, 1
        // Comparator defined for element print reverse order sort

        pq.add(3); //O(log n)
        pq.add(5);
        pq.add(1);
        pq.add(4);
        pq.add(2);
        
        
        while (!pq.isEmpty()) {
            // System.out.println(pq.peek()); //O(1)
            // pq.remove(); //O(logn)
        }
        
        // Student Object
        PriorityQueue<Student> pqs = new PriorityQueue<>();
        pqs.add(new Student("A", 4));
        pqs.add(new Student("B", 5));
        pqs.add(new Student("C", 2));
        pqs.add(new Student("D", 12));
        // pqs.add(new Student("E", 6));

        while (!pqs.isEmpty()) {
            System.out.println(pqs.peek().name + " -> " + pqs.peek().rank); // O(1)
            pqs.remove();
        }
    }
}