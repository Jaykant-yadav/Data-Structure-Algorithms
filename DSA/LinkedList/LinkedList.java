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
    public static int size;

    // Create methods for like :- add(), remove(), print(), search();
    // Add first
    public void addFirst(int data){
        // step1 = create new node
        Node newNode = new Node(data);
        size++;
        // blank node
        if(head == null) {
            head = tail = newNode;
            return;
        }

        // step2 - newNode next = head
        newNode.next = head; //link

        // step3 - head = newNode
        head = newNode;

    }
    // Add Last
    public void addLast(int data) {
        // step - 1 create new node
        Node newNode = new Node(data);
        size++;
        // blank node
        if(head == null) {
            head = tail = newNode;
            return;
        }

        // step - 2 tail.next = newNode
        tail.next = newNode;

        // step - 3 tail = newNode
        tail = newNode;

    }
    // Print LinkedList
    public void printLinkedList() { //O(n)
        // if(head == null){
        //     // System.out.println("LL is empty");
        //     return;
        // }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Add in the middle
    public void add(int idx, int data) {
        if(idx == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while (i < idx-1) {
            temp = temp.next;
            i++;
        }

        // i = idx-1; temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public static void main(String[] args) {
        // Craete Linked List
        LinkedList ll = new LinkedList();
        ll.printLinkedList(); // null
        // add data
        ll.addFirst(2); // 2->null
        ll.printLinkedList();

        ll.addFirst(1); // 1->2->null
        ll.printLinkedList();

        ll.addLast(3); //1->2->3->null
        ll.printLinkedList();

        ll.addLast(4); //1->2->3->4->null
        ll.printLinkedList();
        ll.add(2, 9); //1->2->9->3->4->null
        ll.printLinkedList();
        System.out.println(ll.size);


    }
}
