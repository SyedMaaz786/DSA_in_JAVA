import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class v_Graph05 {
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
    //Cheapest Flights within K stops (lecture for understanding and dryrun)
    //1st
    static void createGraph(int flights[][], ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<flights.length; i++){
            int src = flights[i][0];
            int dest = flights[i][1];
            int wt = flights[i][2];

            Edge e = new Edge(src, dest, wt);
            graph[src].add(e); //adjacency list representation (for a particular src store its dest + wt)
        }
    }
    //3rd
    static class Info{
        int vertex;
        int wt;
        int stops;

        public Info(int v, int w, int s){
            this.vertex = v;
            this.wt = w;
            this.stops = s;
        }
    }
    //2nd
    public static int cheapestFlight(int V, int flights[][], int src, int dest, int k, ArrayList<Edge> graph[]){
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        Queue<Info> q = new LinkedList<>(); // Info class created above stores vertex, weight, stops
        //4th
        q.add(new Info(src, 0, 0));

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr.stops > k){
                break;
            }
            
            for(int i=0; i<graph[curr.vertex].size(); i++){
                Edge e = graph[curr.vertex].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                if(curr.wt+wt < dist[v] && curr.stops <= k){ //modified relaxation check lecture once 
                    dist[v] = curr.wt+wt;

                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }
        //dist of my dest
        if(dist[dest] == Integer.MAX_VALUE){
            return -1;
        }
        else {
            return dist[dest];
        }
    }
    public static void main(String args[]){
        int V = 4;
        int flights[][] = {{0,1,100}, {1,2,100}, {2,0,100}, {1,3,600}, {2,3,200}};
        int src = 0, dest = 3, k = 1;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(flights, graph);
        int ans = cheapestFlight(V, flights, src, dest, k, graph);
        System.out.println(ans);
    }
}
