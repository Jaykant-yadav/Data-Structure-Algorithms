package DSA.Graph;
import java.util.*;
public class graphTraversalBFS {
    /* *********** Breadth First Search (BFS) ************* */
    // Edge class
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src, int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    // Create Graph fnx
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));

    }

    public static void bfs(ArrayList<Edge>[] graph){ //O(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[graph.length];
        q.add(0); // source = 0

        while (!q.isEmpty()) {
            int curr = q.remove(); // curr remove

            if(!visit[curr]){ //if not visit curr
                System.out.print(curr+ " ");
                visit[curr] = true; // put on visit array on true
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i); // current edge
                    q.add(e.dest); // store in queue edge neighbour
                }
            }
        }
    }
    public static void main(String[] args) {
        /* 
         *      1 --- 3
         *     /      |  \
         *    0       |    5 -- 6
         *     \      |  /
         *      2 --- 4
         */

        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        bfs(graph);
    }
}
