package DSA.Stacks;
import java.util.*;

public class stackImplement {
    // ArrayList through implement Stacks

    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();
        // stack is empty check
        public static boolean isEmpty() {
            return list.size() == 0;
        } 
        
        // Push
        public static void push(int data) {
            list.add(data);
        }

        // Pop
        public static int pop() {
            // Stack is empty
            if(isEmpty()) {
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        // peek
        public static int peek() {
            // Stack is empty
            if(isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }
    }


    // LinkedList through implement Stacks
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stacks {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }

        // Push
        public static void push(int data) {
            Node newNode = new Node(data);
            if(isEmpty()) {
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        // POP
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }

            int top = head.data;
            head = head.next;
            return top;
        }

        // Peek
        public static int peek() {
            if(isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stacks s = new Stacks();    
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
