package DSA.Arrays;

import java.util.*;

public class BasicArrays {
    // Insertion
    public static void insertion(int arr3[], int newArr[], int n) {
        /*
         * Types of Insertion
         * At the end (append)
         * At the beginning
         * At a specific index
         */

        // Create a new array with one extra slot
        int pos = 2;
        int element = 30;

        // Copy elements before position
        for (int i = 0; i < pos; i++) {
            newArr[i] = arr3[i];
        }

        for (int i = n; i > pos; i--) {
            newArr[i] = arr3[i - 1];
        }
        // Insert the element
        newArr[pos] = element;
    }

    // Deletion in Array
    public static void deletion(int arr[], int pos, int newArr[]) {
        int n = arr.length;
        // Copy all elements before pos
        for(int i=0; i<pos; i++) {
            newArr[i] = arr[i];
        }
        // Copy all elements after pos, shifted one index to the left
        for(int i=pos; i<n-1; i++){
            newArr[i] = arr[i+1];
        }

    }

    public static void update(int arr[], int nonChangable) {
        nonChangable = 10;
        for(int i=0; i<arr.length; i++) {
            arr[i] = arr[i] + 1;
        }
    }
    public static void main(String args[]) {

        //Crearting An Array
        int array[];
        int arr[] = new int[5];
        int arr1[] = {1, 2, 3, 4, 5}; 

        //Input & Output
        int marks[] = new int[50];
        Scanner sc = new Scanner(System.in);

        //Arrays length
        System.out.println(marks.length);

        marks[0] = sc.nextInt(); //phy
        marks[1] = sc.nextInt(); //math
        marks[2] = sc.nextInt(); //chem
        
        System.out.println("phy : " + marks[0]);
        System.out.println("math : " + marks[1]);
        System.out.println("chem : " + marks[2]); 

        //update
        marks[1] = 100;
        System.out.println("math : " + marks[1]); 

        //calculate percentage
        int total = marks[0] + marks[1] + marks[2];
        float percentage = (total/300.0f) * 100;    
        System.out.println("Percentage : " + percentage + "%"); 

        //Passing Array to a argument
        // -> Array is passed by reference -> that means if we change the array in the function it will also change in the main function
        // -> pass by value -> copy of the value is passed to the function but not reflected in the main function
        int num[] = {98, 87, 56};
        int nonChangable = 5;
        update(num, nonChangable); //pass by reference -> 99, 88, 57
        for(int i=0; i<num.length; i++) {
            System.out.println(num[i] + " ");
        }
        System.out.println(nonChangable); //5 -> pass by value

    }

}