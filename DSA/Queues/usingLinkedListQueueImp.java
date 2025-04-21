package DSA.Queues;

public class usingLinkedListQueueImp {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class  Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // add
        public static void add(int data) {
            Node newNode = new Node(data);
            // add first node
            if(head == null) {
                head = tail = newNode;
                return;
            }
            // existing linkedlist in add newnode
            tail.next = newNode;
            tail = newNode;
        }

        // Remove
        public static int remove() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }

            int front = head.data;
            // single element
            if(tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        public static int peek() {
            if(isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(10);
        queue.add(20);
        while(!queue.isEmpty()) {
            System.out.println(queue.peek());
            queue.remove();
        }
        System.out.println("Front element: " + queue.peek());
        System.out.println("Removed element: " + queue.remove());
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
