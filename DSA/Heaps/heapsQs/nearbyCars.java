import java.util.PriorityQueue;

public class nearbyCars {

    // Inner class to represent a point (car) on the 2D plane
    static class Point implements Comparable<Point> {
        int x;         // x-coordinate
        int y;         // y-coordinate
        int distSq;    // squared distance from origin (0,0)
        int idx;       // original index of the point in the input array

        // Constructor to initialize the Point object
        public Point(int x, int y, int distSq, int idx) {
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        // Override compareTo method to allow sorting by distance
        @Override
        public int compareTo(Point p2) {
            // Sort based on distance (ascending)
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String[] args) {
        // Input array of coordinates for cars
        int pts[][] = {{3, 3}, {5, -1}, {-2, 4}};
        
        // Number of nearest cars to find
        int k = 2;

        // Create a min-heap (PriorityQueue) to store Point objects
        PriorityQueue<Point> pq = new PriorityQueue<>();

        // Insert all points into the priority queue with their distances
        for (int i = 0; i < pts.length; i++) {
            // Calculate squared distance from origin
            int distSq = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            
            // Create and add the Point object to the priority queue
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        // Retrieve and print the indexes of the k nearest cars
        System.out.println("The " + k + " nearest cars are:");
        for (int i = 0; i < k; i++) {
            Point nearest = pq.remove(); // Remove the nearest point
            System.out.println("C" + nearest.idx + " at (" + nearest.x + ", " + nearest.y + ")");
        }
    }
}
