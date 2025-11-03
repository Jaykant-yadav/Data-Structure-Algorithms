package DSA_Sheet.ApnaCollege;

import java.util.*;

import DSA.Arrays.linearSearch;

public class LinkedLists {
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode head;
    public static ListNode tail;

    // Reverse a LL
    public static ListNode reverse(ListNode Node) {
        ListNode prev = null;
        ListNode curr = Node;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }

    // Middle of the Linked List
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge Two Sorted Lists
    // Brute force -> TC - O(n+m) SC - O(n+m)
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode mergeLL = new ListNode(-1, null); //create new temparary node
        ListNode temp = mergeLL;
        while (list1 != null && list2 != null) { // both list != null loop traverse
            if(list1.val < list2.val){ 
                temp.next = list1; //temp of next node list1
                list1 = list1.next; // list1 move on next node
                temp = temp.next; // temp move on next node
            }else {
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }

        while (list1 != null) { //if some node list1 in present then these loop work
            temp.next = list1;
            list1 = list1.next;
            temp = temp.next;
        }

        while (list2 != null) {
            temp.next = list2;
            list2 = list2.next;
            temp = temp.next;
        }

        return mergeLL.next; // merge next return because this node start with -1 
    }

    // optimal Approach
    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode ans = list1;
        while (list1 != null && list2 != null) {
            ListNode temp = list1;
            while (list1 != null && list1.val <= list2.val) {
                temp = list1;
                list1 = list1.next;
            }
            temp.next = list2;

            ListNode t = list1;
            list1 = list2;
            list2 = t;
        }

        return ans;
    }

    // Palindrome Linked List
    public static boolean isPalindrome(ListNode Node){
        if(Node == null && Node.next == null) return true;

        // Step1 :- find Mid
        ListNode midNode = middleNode(Node);

        // Step2 :- reverse 2nd half on right side
        ListNode right = reverse(midNode);
        ListNode left = Node;

        // Step3 - check half left and right half
        while (right != null) {
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head){
        if(head == null && head.next == null){
            return true;
        }

        // Step1: find mid
        ListNode midNode = middleNode(head);

        // Step2: Reverse 2nd half
        ListNode prev = null;
        ListNode curr = midNode;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev;
        ListNode left = head;

        // compare left to right
        while (right != null) {
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // Linked List Cycle
    public static boolean isCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode h1 = new ListNode(1, null);
        // h1.next = new ListNode(2, null);
        // h1.next.next = new ListNode(4, null);

        ListNode h2 = new ListNode(2, null);
        // h2.next = new ListNode(3, null);
        // h2.next.next = new ListNode(4, null);

        ListNode list = mergeTwoLists2(h1, h2);
        printLL(list);
    }

    // Print LL
    public static void printLL(ListNode Node){
        ListNode temp = Node;
        while (temp != null) {
            System.out.print(temp.val + " <-> ");
            temp = temp.next;
        }
        System.out.println( "null");
    }
}
