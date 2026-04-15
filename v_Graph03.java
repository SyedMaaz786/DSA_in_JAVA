import java.util.ArrayList;

public class v_Graph03 {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    // Cycle Detection (Directed Graph DFS) (lecture for understanding and dryrun)
    //2nd
    public static boolean isCycle(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(isCycleUtil(graph, i, visited, stack)){
                    return true;
                }
            }
        }
        return false;
    }
    //1st
    public static boolean isCycleUtil(ArrayList<Edge> graph[], int curr, boolean visited[], boolean stack[]){
        visited[curr] = true;
        stack[curr] = true;
        
        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(stack[e.dest]){ //if neighbor is in stack then cycle exist so return true
                return true;
            }
            else if(!visited[e.dest] && isCycleUtil(graph, e.dest, visited, stack)){
                return true;
            }
        }
        stack[curr] = false;
        return false;
    }
    // static void createGraph(ArrayList<Edge> graph[]){
    //     for(int i=0; i<graph.length; i++){
    //         graph[i] = new ArrayList<>();
    //     }
    //     graph[0].add(new Edge(0, 2));  // TRUE -- Cycle exist

    //     graph[1].add(new Edge(1, 0));

    //     graph[2].add(new Edge(2, 3));

    //     graph[3].add(new Edge(3, 0));
    // }

    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1)); // FALSE -- Cycle doesn't exist
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 3));
    }
    public static void main(String args[]){
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        System.out.println(isCycle(graph));
    }
}
