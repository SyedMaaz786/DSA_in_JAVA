import java.util.*;

public class v_Graph08 {
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

        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 4));
    }
    // Strongly Connected Components - kosaraju algorithm O(V+E) 
    //2nd 
    public static void topSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s){
        visited[curr] = true;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSort(graph, e.dest, visited, s);
            }
        }
        s.push(curr);
    }
    //3rd 
    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]){
        visited[curr] = true;
        System.out.print(curr + " ");

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                dfs(graph, e.dest, visited);
            }
        }
    }
    //1st
    public static void kosaraju(ArrayList<Edge> graph[], int V){
        //step 1
        Stack<Integer> s = new Stack<>();
        boolean visited[] = new boolean[V];
        for(int i=0; i<V; i++){
            if(!visited[i]){
                topSort(graph, i, visited, s);
            }
        }
        //step 2
        ArrayList<Edge> transpose[] = new ArrayList[V];
        for(int i=0; i<graph.length; i++){
            visited[i] = false; //to use visited set it back to false
            transpose[i] = new ArrayList<>();
        }
        for(int i=0; i<V; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j); //e.src -> e.dest
                transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse (e.dest -> e.src)
            }
        }
        //step 3
        while(!s.isEmpty()){
            int curr = s.pop();
            if(!visited[curr]){
                System.out.print("SCC -> ");
                dfs(transpose, curr, visited);
                System.out.println();
            }
        }
    }
    public static void main(String args[]){
        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        kosaraju(graph, V);
    }
}
