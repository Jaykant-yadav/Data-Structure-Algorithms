package DSA.Graph;
import java.util.*;

public class graphTraversalDFS {
    /* *********** Depth First Search (DFS) ************* */
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

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visit[]){ //O(V+E)
        // visit
        System.out.print(curr + " "); //print curr
        visit[curr] = true; // put on true visit curr vertices for

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i); // curr edges
            if(!visit[e.dest]){ // neighbour visit or not
                dfs(graph, e.dest, visit); //call recursively
            }
        }
    }

    // O(V+E)
    public static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean visit[]){
        if(src == dest){
            return true;
        }
        visit[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            // e.dest = neighbour
            if(!visit[e.dest] && hasPath(graph, e.dest, dest, visit)){
                return true;
            }
        }

        return false;
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
        dfs(graph, 0, new boolean[V]); //0 1 3 4 2 5 6
        System.out.println(hasPath(graph, 0, 5, new boolean[V])); // true
    }
}
