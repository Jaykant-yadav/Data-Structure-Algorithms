package plusLibrary.Amazon;

public class LinkedList {
    public static class Node {
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    // Helper function to create a linked list from an array
    public static Node createList(int arr[]) {
        if(arr == null || arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]); // first Node
        Node curr = head; // pointer to the current node
        for(int i=1; i<arr.length; i++) { 
            curr.next = new Node(arr[i]);//create the next node
            curr = curr.next; // Move to the next node
        }
        return head; //Return the head of the linked list
    }

    // Merge function of two list -> Brute Force
    public static Node mergeSortedLists(Node l1, Node l2) {
        // Dummy node to help with the merge process
        Node dummy = new Node(0);
        Node curr = dummy;

        // Two pointer to traverse both lists
        while (l1 != null && l2 != null) {
            if(l1.data <= l2.data) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if(l1 != null) {
            curr.next = l1;
        } else {
            curr.next = l2;
        }

        return dummy.next;
    }

    // Optimal Approach
    public static Node mergeSortedNode2(Node l1, Node l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        Node ans = l1;

        while (l1 != null && l2 != null) {
            Node temp = l1;
            while (l1 != null && l1.data <= l2.data) {
                temp = l1;
                l1 = l1.next;
            }
            temp.next = l2;

            Node t = l1;
            l1 = l2;
            l2 = t;
        }

        return ans;
    }

    // Print Linked List
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int list1[] = {1, 3, 5, 7};
        int list2[] = {2, 4, 6, 8};

        Node l1 = createList(list1);
        Node l2 = createList(list2);

        // Node mergedNode = mergeSortedLists(l1, l2);
        Node mergedNode = mergeSortedNode2(l1, l2);
        printLL(mergedNode);
        
    }
}


