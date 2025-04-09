package DSA.Stacks;
import java.util.*;
public class stack {
    // Amazon -> O(n) - Using Recursion
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // Reverse a string using a stack - O(n) -> `Amazon, Microsoft, Adobe, Flipkart, Paytm`
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.length()) {
            s.push(str.charAt(idx));
            idx++;
        }

        StringBuilder res = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            res.append(curr);
        }

        return res.toString();
    }

    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }

        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    // Stock Span Problem
    public static void stockSpan(int Stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(1);

        for(int i=1; i<Stock.length; i++) {
            int currPrice = Stock[i];
            while (!s.isEmpty() && currPrice > Stock[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i+1;
            }
            else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // pushAtBottom(s, 4);

        // while(!s.isEmpty()) {
        //     System.out.println(s.pop());
        // }
        // String str = "jkjkjk";
        // String s1 = reverseString(str);
        // System.out.println(s1);
        // reverseStack(s); //3, 2, 1
        // printStack(s);//1, 2, 3

        int Stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[Stocks.length];
        stockSpan(Stocks, span);
        for(int i=0; i<span.length; i++) {
            System.out.print(span[i] + " ");
        }
    }
}
