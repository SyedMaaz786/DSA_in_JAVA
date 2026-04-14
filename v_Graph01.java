import java.util.*;

public class v_Graph01 {
    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    //Breadth First Search in graph O(V+E)
    public static void bfs(ArrayList<Edge>[] graph){
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[graph.length];
        q.add(0); //source 0

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }
    //Depth First Search in graph O(V+E)
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]){
        //visit
        System.out.print(curr + " ");
        visited[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited); //recursive call
            }
        }
    }
    public static void main(String args[]){
        /*
                (5)
            0 ------- 1
                     / \
                    /   \
               (1) /     \(3)
                  /       \
                 /         \
               2 ----------  3
               |    (1)
            (2)|
               |
               4
        */
       int V = 5; //vertex
       ArrayList<Edge>[] graph = new ArrayList[V]; //empty arraylist

       for(int i=0; i<V; i++){ //loop for creating new arraylist to store s,d,w of that particular edge
        graph[i] = new ArrayList<>();
       }

       // 0 - vertex
       graph[0].add(new Edge(0, 1, 5));

       // 1 - vertex
       graph[1].add(new Edge(1, 0, 5));
       graph[1].add(new Edge(1, 2, 1));
       graph[1].add(new Edge(1, 3, 3));

       // 2 - vertex
       graph[2].add(new Edge(2, 1, 1));
       graph[2].add(new Edge(2, 3, 1));
       graph[2].add(new Edge(2, 4, 2));

       // 3 - vertex
       graph[3].add(new Edge(3, 1, 3));
       graph[3].add(new Edge(3, 2, 1));

       //4 - vertex
       graph[4].add(new Edge(4, 2, 2));

    //    //printing 2's neighbors
    //    for(int i=0; i<graph[2].size(); i++){
    //     Edge e = graph[2].get(i); // gets s,d,w
    //     System.out.println(e.dest);
    //    }

    //    bfs(graph);
       dfs(graph, 0, new boolean[V]);




    }
    
}
