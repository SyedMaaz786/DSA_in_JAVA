import java.util.*;

public class v_Graph05 {
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
    //Cheapest Flights within K stops (lecture for understanding and dryrun)
    //1st
    static void createGraph(int flights[][], ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<flights.length; i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];

            graph[u].add(new Edge(u, v, wt));
        }
    }
    //3rd
    static class Info{
        int vertex;
        int cost;
        int stops;

        public Info(int vertex, int cost, int stops){
            this.vertex = vertex;
            this.cost = cost;
            this.stops = stops;
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

                if(curr.cost+wt < dist[v] && curr.stops <= k){ //modified relaxation check lecture once (curr.wt handle's a corner case where stops are respected)
                    dist[v] = curr.cost+wt;

                    q.add(new Info(v, dist[v], curr.stops+1));
                }
            }
        }
        //dist of my dest
        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
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
