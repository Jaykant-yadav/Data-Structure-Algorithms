package DSA.LinkedList;

// create a Node class
public class LinkedList {
    // create a Node class
    public static class Node {
        int data;
        Node next;
        // Constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // single Head & tail
    public static Node head;
    public static Node tail;

    // Create methods for like :- add(), remove(), print(), search();
    public static void main(String[] args) {
        // Craete Linked List
        LinkedList ll = new LinkedList();
        // new node create
        ll.head = new Node(1);
        ll.head.next = new Node(2);
    }
}
