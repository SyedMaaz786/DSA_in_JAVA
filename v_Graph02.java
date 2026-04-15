import java.util.*;

public class v_Graph02 {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }
    // Cycle Detection (Undirected DFS) O(V+E) (it's easy, lecture for understanding and dryrun)
    //2nd
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!visited[i]){
                if(detectCycleUtil(graph, visited, i, -1)){ // -1 because for 1st vertex their is no parent so we start with -1
                    return true;
                }
            }
        }
        return false;
    }
    //1st
    public static boolean detectCycleUtil(ArrayList<Edge> graph[], boolean visited[], int curr, int par){
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            //case 3
            if(!visited[e.dest]){
                if(detectCycleUtil(graph, visited, e.dest, curr)){
                    return true;
                }
            }
            //case 1
            else if(visited[e.dest] && e.dest != par){ //if visited is true and neighbor is not my parent  
                return true;
            }
            //case 2 - do nothing (continue) for this condition check notes
        }
        return false;
    }
    //Bipartile Graph O(L+E) (it's easy lecture for understanding and dryrun)
    public static boolean isBipartile(ArrayList<Edge> graph[]){
        int col[] = new int[graph.length]; // array of colors (col is color)
        for(int i=0; i<col.length; i++){
            col[i] = -1; // no color
        }
        Queue<Integer> q = new LinkedList<>(); // BFS 
        for(int i=0; i<graph.length; i++){
            if(col[i] == -1){
                q.add(i);
                col[i] = 0; // yellow color assigned
                while(!q.isEmpty()){
                    int curr = q.remove();
                    for(int j=0; j<graph[curr].size(); j++){
                        Edge e = graph[curr].get(j);
                        if(col[e.dest] == -1){
                            int nextCol = col[curr] == 0 ? 1 : 0;
                            col[e.dest] = nextCol;
                            q.add(e.dest);
                        }
                        else if(col[curr] == col[e.dest]){
                            return false; // NOT BIPARTILE
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String args[]){
    /*  Important - If cycle doesn't exist in the graph it is BIPARTILE.
                    If cycle exist and it should be of odd length, it is NOT BIPARTILE. (for even length it is BIPARTILE)

            0 ------- 3
           /|         |
          / |         |
         1  |         4
          \ |
           \|
            2
    */
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        // System.out.println(detectCycle(graph));


        System.out.println(isBipartile(graph));
    }
}
