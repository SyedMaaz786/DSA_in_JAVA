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
    // bfs for connected components
    public static void bfs(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                bfsUtil(graph, visited);
            }
        }
    }
    //Breadth First Search in graph O(V+E) (check notes for explaination)
    public static void bfsUtil(ArrayList<Edge> graph[], boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
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
    // dfs for connected components
    public static void dfs(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited(i)){
                dfsUtil(graph, i, visited);   
            }
        }
    }
    //Depth First Search in graph O(V+E) (check notes for explaination)
    public static void dfsUtil(ArrayList<Edge> graph[], int curr, boolean visited[]){
        //visit
        System.out.print(curr + " ");
        visited[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfsUtil(graph, e.dest, visited); //recursive call
            }
        }
    }
    //Has Path O(V+E)
    public static boolean hasPath(ArrayList<Edge> graph[], int src, int dest, boolean visited[]){
        //2nd
        if(src == dest){
            return true;
        }
        //1st
        visited[src] = true;
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            if(!visited[e.dest] && hasPath(graph, e.dest, dest, visited)){ //e.dest = neighbor (if neighbor is not visited then recursive call, in recursive call src is my neighbor(e.dest) and dest is same as dest)
                return true;
            }
        }
        return false;
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
       ArrayList<Edge> graph[] = new ArrayList[V]; 

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
    //     Edge e = graph[2].get(i); //gets s,d,w
    //     System.out.println(e.dest);
    //    }


    //    bfsUtil(graph);
    //    dfsUtil(graph, 0, new boolean[V]);


    System.out.println(hasPath(graph, 0, 4, new boolean[V]));


    }
    
}
