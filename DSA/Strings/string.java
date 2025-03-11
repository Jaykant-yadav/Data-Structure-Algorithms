package DSA.Strings;

import java.util.Scanner;

public class string {

    public static void printLatters(String str){
        for(int i=0; i<str.length(); i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    //Company -> INTUITE
    public static boolean panlindrome(String str){//O(n)
        for(int i=0; i<str.length()/2; i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                //not a palindrome
                return false;
            }
        }
        return true;
    }

    public static float getShortestPath(String str){
        int x = 0, y = 0;

        for(int i=0; i<str.length(); i++) {
            char dir = str.charAt(i);
            //south
            if(dir == 'S') {
                y--;
            } else if(dir == 'W'){ //west
                x--;
            } else if(dir == 'N'){ //North
                y++;
            } else { //East
                x++;
            }
        }

        int X2 = x*x;
        int Y2 = y*y;
        return (float) Math.sqrt(X2 + Y2);
    }

    public static String substring(String str, int si, int ei){
        String substr = "";
        for(int i=si; i<ei; i++) {
            substr += str.charAt(i);
        }
        return substr;
    }

    //Convert first letter of each Word to UPPERCASE -> <CODE NATION>
    public static String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    //String Compression -> (AMAZON)
    public static String compress(String str) { //O(n)
        String newStr = "";
        for(int i=0; i<str.length(); i++) {
            Integer count = 1;
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count > 1) {
                newStr += count.toString();
            }
        }
        return newStr;
    }
    //Using String Builder
    public static String compresses(String str) {
        StringBuilder sb = new StringBuilder("");
        for(int i=0; i<str.length(); i++) {
            Integer count = 1;
            while (i<str.length()-1 && str.charAt(i) == str.charAt(i+1)) {
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1) {
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        char arr[] = {'a', 'b', 'c', 'd'};
        
        //Creation of Strings
        String str = "abcd";
        String str2 = new String("XYZ");

        //Strings are IMMUTABLE

        //Input/Output
        Scanner sc = new Scanner(System.in);
        // String name = sc.next();
        // String names = sc.nextLine();
        // System.out.println(names);

        //Strings Length
        String fullName = "Jaykant Kumar";
        // System.out.println(fullName.length());

        //Concatenation
        String firstName = "Jaykant", lastName = "Kumar";
        // System.out.println(firstName + " " + lastName);
        // System.out.println(firstName.charAt(0));

        // printLatters(fullName);

        // System.out.println(panlindrome("noon"));

        // System.out.println(getShortestPath("WNEENESENNN"));

        //in Strings Equality check
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");

        /* if(s1 == s2){ //equal
            System.out.println("strings are equal");
        }else{
            System.out.println("Strings are not equal");
        }

        if(s1 == s3){// not equal
            System.out.println("strings are equal");
        }else{
            System.out.println("Strings are not equal");
        }

        if(s1.equals(s2)){// equal
            System.out.println("strings are equal");
        }else{
            System.out.println("Strings are not equal");
        } */

        //Strings Functions -> SubString -> str.substring(si, ei);
        String str1 = "HelloWorld";
        // System.out.println(str1.substring(1, 5));


        //Largest String Findout -> O(X * n)
        String fruits[] = {"Apple", "Banana", "Mango"};
        String largest = fruits[0];

        for(int i=0; i<fruits.length; i++) {
            if(largest.compareTo(fruits[i]) < 0){
                largest = fruits[i];
            }
        }
        // System.out.println(largest);

        //String Builder
        StringBuilder sb = new StringBuilder("");
        for(char ch='a'; ch<='z'; ch++) {
            sb.append(ch);
        } //abcdefghijklmnopqrstuvwxyz
        //O(26)
        //O(26 * n^2)
        // System.out.println(sb + " ");

        //Convert a first Charater capital
        String str3 = "hello, i am jaykant";
        // System.out.println(toUpperCase(str3));

        //String Compression
        String strs = "aaaabbbbcccdd";
        System.out.println(compresses(strs));


    }
}
