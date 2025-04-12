package DSA.Stacks;

import java.util.*;

public class stack {
    // Amazon -> O(n) - Using Recursion
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    // Reverse a string using a stack - O(n) -> `Amazon, Microsoft, Adobe, Flipkart,
    // Paytm`
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
        if (s.isEmpty()) {
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

    // Stock Span Problem -> O(n)
    public static void stockSpan(int Stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(1);

        for (int i = 1; i < Stock.length; i++) {
            int currPrice = Stock[i];
            while (!s.isEmpty() && currPrice > Stock[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }

            s.push(i);
        }
    }

    // Next Greater Element - O(n)
    public static int[] nextGreater(int arr[]) {
        int nextGreater[] = new int[arr.length];
        Stack<Integer> s2 = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            // 1 while
            while (!s2.isEmpty() && arr[s2.peek()] <= arr[i]) {
                s2.pop();
            }

            // 2 if-else
            if (s2.isEmpty()) {
                nextGreater[i] = -1;
            } else {
                nextGreater[i] = arr[s2.peek()];
            }

            // 3 push in s
            s2.push(i);
        }
        return nextGreater;
    }

    // Valid Parentheses -> O(n)
    public static boolean validParenthese(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Opening
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(ch);
            } else {
                // Closing
                if (s.isEmpty()) {
                    return false;
                }

                if ((s.peek() == '(' && ch == ')') || // ()
                        (s.peek() == '{' && ch == '}') || // {}
                        (s.peek() == '[' && ch == ']')) {// []
                    s.pop();
                } else {
                    return false;
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // Duplicate Parentheses -> O(n)
    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();

        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);

            // Closing
            if(ch == ')') {
                int count = 0;
                while (s.pop() != '(') {
                    count++;
                }

                if(count < 1) {
                    return true; //duplicate
                }
            } else {
                // Opening
                s.push(ch);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        // pushAtBottom(s, 4);

        // while(!s.isEmpty()) {
        // System.out.println(s.pop());
        // }
        // String str = "jkjkjk";
        // String s1 = reverseString(str);
        // System.out.println(s1);
        // reverseStack(s); //3, 2, 1
        // printStack(s);//1, 2, 3

        /*
         * int Stocks[] = {100, 80, 60, 70, 60, 85, 100};
         * int span[] = new int[Stocks.length];
         * stockSpan(Stocks, span);
         * for(int i=0; i<span.length; i++) {
         * System.out.print(span[i] + " ");
         * }
         */

        /*
         * int arr[] = { 6, 8, 0, 1, 3 };
         * int nextGreaters[] = nextGreater(arr);
         * for (int i = 0; i < nextGreaters.length; i++) {
         * System.out.print(nextGreaters[i] + " ");
         * }
         * System.out.println();
         */

         /* String str = "({{}}[]";
         System.out.println(validParenthese(str)); */

         String str = "((a+b))"; //true
         String str2 = "(a-b)";//false
         System.out.println(isDuplicate(str));
    }
}
