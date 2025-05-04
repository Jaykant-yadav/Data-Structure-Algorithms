package DSA.Queues;
import java.util.*;

public class QueueQs {
    // First non-repeating letter in a stream of character
    public static void printNonRepeating(String str) {
        int freq[] = new int[26]; // 'a' - 'z'
        Queue<Character> q = new LinkedList<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (!q.isEmpty()) {
                System.out.print(q.peek() + " ");  
            } else {
                System.out.print(-1 + " ");
            }
        }
        System.out.println();
    }

    // InterLeave Two Halves of a Queue
    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
        
        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }
        
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            if (!q.isEmpty()) {
                q.add(q.remove());
            }
        }
    }

    // Queue Reversal 
    public static void queueReversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());  
        }
    }

    public static void reverseFirstKEle(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<k; i++) {
            s.push(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        int size = q.size();
        for(int i=0; i<size-k; i++) {
            q.add(q.remove()); // remove from front and add at back
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";
        // printNonRepeating(str);

        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        // interLeave(q);
        // queueReversal(q);
        reverseFirstKEle(q, 5);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
