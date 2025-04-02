package DSA.LinkedList;

public class LinkedListQS {
    // Create a Node class
    public static class Node {
        int data;
        Node next;

        // Constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // single head & tail
    public static Node head;
    public static Node tail;
    public static int size;

    // Add first
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    // Search (Iterative) key
    public static int iterSearch(int key) { // O(n)
        int i = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == key) { // key found
                return i;
            }
            temp = temp.next;
            i++;
        }

        // key not found
        return -1;

    }

    // Search(Recursive)
    public static int helper(Node head, int key) { // O(n)
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public static int recusiveSearch(int key) {
        return helper(head, key);
    }

    // Reverse Linked List
    public void reverse() { // O(n)
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // Find & Remove Nth Node From End -> O(n)
    public void deleteNthFromEnd(int n) {
        // Size Calculate
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (n == size) {
            head = head.next; // removeFirst
            return;
        }

        // size - n
        int i = 1;
        int idxToFind = size - n;
        Node prev = head;
        while (i < idxToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    // Find Mid in Linked List -> slow-fast approach
    public static Node findMid(Node head) { // Helper fnx
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow; // slow is my midNode
    }

    // Check if LL is a palindrome
    public static boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // Step1 - find mid
        Node midNode = findMid(head);

        // step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head;
        Node left = head;

        // step3 - check left half & right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // Detect a loop/cycle in a Linked list
    public static boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if (slow == fast) {
                return true; // cycle exists
            }
        }
        return false; // cycle doesn't exists
    }

    // Remove Cycle in Linked List
    public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (cycle == false) {
            return;
        }

        // find meeting point
        slow = head;
        Node prev = null; // last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle -> last.next = null
        prev.next = null;

    }

    // Merge Sort on a Linked List
    // Mid Find
    public Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // mid Node
    }

    // Merge Fnx
    public Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedLL.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // find mid
        Node mid = getMid(head);

        // Left & right half for mergeSort Call
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        // Merge
        return merge(newLeft, newRight);
    }

    // print
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListQS ll = new LinkedListQS();

        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(2);
        // ll.addFirst(1);

        // ll.print();

        // System.out.println(ll.iterSearch(3));
        // System.out.println(recusiveSearch(3));

        // ll.reverse();
        // ll.deleteNthFromEnd(3);
        // System.out.println(ll.checkPalindrome());
        // Cycle Linked List
        /* head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp; */
        // 1->2->3->1
        /* System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle()); */
        ll.print();

        ll.head = ll.mergeSort(ll.head);  

        ll.print();

    }
}
