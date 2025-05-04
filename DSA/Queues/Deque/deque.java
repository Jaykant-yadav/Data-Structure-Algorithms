package DSA.Queues.Deque;

import java.util.Deque;
import java.util.LinkedList;

import DSA.Queues.QueueQs;

public class deque {
    // Stack Implement Using Deque
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();
        public void push(int data) {
            deque.addLast(data);
        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }

    //  Queue Implement Using Deque
    static class Queue {
        Deque<Integer> deque = new LinkedList<>();
        public void add(int data) {
            deque.addLast(data);
        }

        public int remove() {
            return deque.removeFirst();
        }

        public int peek() {
            return deque.getFirst();
        }
    }
    public static void main(String[] args) {
        // Java Collection Framework using Deque
        /* Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
        System.out.println("first ele : " + deque.getFirst());
        System.out.println("last ele : " + deque.getLast()); */

        // Stack Implement Using Deque
        /*Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Top element: " + s.peek());
        System.out.println("Popped element: " + s.pop());
        System.out.println("Popped element: " + s.pop());
        System.out.println("Popped element: " + s.pop()); */

        //  Queue Implement Using Deque
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("peek : " + q.peek());
        System.out.println("remove : " + q.remove());
        System.out.println("remove : " + q.remove());
        System.out.println("remove : " + q.remove()); 
    }
}
