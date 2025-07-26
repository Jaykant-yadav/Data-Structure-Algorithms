package DSA.Heaps;

import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class heaps {
    // Object Store in Priority Queues
    static class Student implements Comparable<Student> { // Overriding
        // Comparable is a Interface and Student Class of Object
        String name;
        int rank;

        public Student(String name, int rank) { // Constructor
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank; // compare on the bases of rank
        }
    }

    // Insert in Heap
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {
            // add at last idx
            arr.add(data);
            int x = arr.size() - 1; // x is child index
            int par = (x - 1) / 2; // parent index

            while (arr.get(x) < arr.get(par)) { // O(logn)
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }

        }

        public int peek() {
            return arr.get(0);
        }

        private void heapify(int i) {
            int left = 2 * i + 1; // left child
            int right = 2 * i + 2; // right child
            int minIdx = i; // assign value in minIdx

            if (left < arr.size() && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            if (minIdx != i) {
                // swap
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove() {
            int data = arr.get(0);

            // step1 - swap first & last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // step2 - delete last
            arr.remove(arr.size() - 1);

            // step3 - heapify
            heapify(0);
            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    // Heap Sort
    public static void heapSort(int arr[]) { //O(n*logn)
        // step1 - build maxHeap
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(arr, i, n);// O(n * logn)
        }

        // step2 - push largest at end
        for (int i = n - 1; i > 0; i--) {
            // swap (largest - first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i); // O(n * logn)
        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if(maxIdx != i){
            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }

    }

    public static void main(String[] args) {
        // Priority Queues Create
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 1, 2, 3, 4, 5

        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        // // 5, 4, 3, 2, 1
        // Comparator defined for element print reverse order sort

        pq.add(3); // O(log n)
        pq.add(5);
        pq.add(1);
        pq.add(4);
        pq.add(2);

        /* while (!pq.isEmpty()) {
            System.out.println(pq.peek()); //O(1)
            pq.remove(); //O(logn)
        } */

        // Student Object
        PriorityQueue<Student> pqs = new PriorityQueue<>();
        pqs.add(new Student("A", 4));
        pqs.add(new Student("B", 5));
        pqs.add(new Student("C", 2));
        pqs.add(new Student("D", 12));
        // pqs.add(new Student("E", 6));
/* 
        while (!pqs.isEmpty()) {
            // System.out.println(pqs.peek().name + " -> " + pqs.peek().rank); // O(1)
            pqs.remove();
        } */

        // ************** Heap ********************

        Heap h = new Heap();
        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        /* while (!h.isEmpty()) {
            // System.out.println(h.peek());
            // h.remove();
        } */

        // Heap Sort
        int arr[] = {1, 2, 4, 5, 3};
        heapSort(arr);

        // print
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}