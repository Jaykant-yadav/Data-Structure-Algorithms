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
    public static void main(String[] args) {
        String str = "aabccxb";
        // printNonRepeating(str);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interLeave(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
