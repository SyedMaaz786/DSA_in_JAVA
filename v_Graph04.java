import java.util.*;

public class v_Graph04 {
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
    static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // graph[0].add(new Edge(0, 1, 2)); // dijkstra
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 3, 7));
        // graph[1].add(new Edge(1, 2, 1));

        // graph[2].add(new Edge(2, 4, 3));

        // graph[3].add(new Edge(3, 5, 1));

        // graph[4].add(new Edge(4, 3, 2));
        // graph[4].add(new Edge(4, 5, 5));




        // graph[0].add(new Edge(0, 1, 2)); // Bellman ford
        // graph[0].add(new Edge(0, 2, 4));

        // graph[1].add(new Edge(1, 2, -4));

        // graph[2].add(new Edge(2, 3, 2));

        // graph[3].add(new Edge(3, 4, 4));

        // graph[4].add(new Edge(4, 1, -1));




        graph[0].add(new Edge(0, 1, 10));  // Prim's 
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }
    // Dijkstra's Algorithm (to find shortest distance from src to dest) O(V+ElogV) (lecture for understanding and dryrun)
    static class Pair implements Comparable<Pair>{
        int node;
        int path;

        public Pair(int node, int path){
            this.node = node;
            this.path = path;
        }
        @Override
        public int compareTo(Pair p2){
            return this.path - p2.path; //path based sorting
        }
    }
    public static void dijkstra(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(i != src){  //stare or lecture you will get (konsa idx mere src k equal nai hata use infinity se init krna)
                dist[i] = Integer.MAX_VALUE; // infinity se initialise krna sabku
            }
        }
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){ //if not visted
                visited[curr.node] = true; // visited ku banadal true
            }
            for(int i=0; i<graph[curr.node].size(); i++){
                Edge e = graph[curr.node].get(i);
                int u = e.src;
                int v = e.dest;
                int wt = e.wt;

                //relaxation
                if(dist[u]+wt < dist[v]){ //formula remember this notes mai bi likhko hu
                    dist[v] = dist[u]+wt;
                    pq.add(new Pair(v, dist[v])); //pq mai add krna node bi path
                }
            }
        }
        //print shortest distance 
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    //BellmanFord Algorith (-ve weights) O(V*E) (it's easy check lecture for understanding and dryrun)
    public static void bellmanFord(ArrayList<Edge> graph[], int src){
        int dist[] = new int[graph.length];
        for(int i=0; i<dist.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int V = graph.length;  //defined V for simplicity or else graph.length-1 would also work same
        for(int i=0; i<V-1; i++){ //O(V)
            //edges O(E)
            for(int j=0; j<graph.length; j++){ //loop -> vertices
                for(int k=0; k<graph[j].size(); k++){ //loop -> edges
                    Edge e = graph[j].get(k);
                    int u = e.src;
                    int v = e.dest;
                    int wt = e.wt;
                    if(dist[u] != Integer.MAX_VALUE && dist[u]+wt < dist[v]){ //relaxation with modified
                        dist[v] = dist[u]+wt;
                    } 
                }
            }
        }
        //print
        for(int i=0; i<dist.length; i++){
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
    //Prim's Algorithm (MST) (it's easy cheack lecture for understanding and dryrun)
    static class Pair2 implements Comparable<Pair2>{
        int vertex;
        int weight;

        public Pair2(int vertex, int weight){
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override 
        public int compareTo(Pair2 p2){
            return this.weight - p2.weight; //ascending
        }
    }
    public static void prims(ArrayList<Edge> graph[]){
        boolean visited[] = new boolean[graph.length];
        PriorityQueue<Pair2> pq = new PriorityQueue<>();
        pq.add(new Pair2(0, 0));
        int finalWeight = 0; //total weight

        while(!pq.isEmpty()){
            Pair2 curr = pq.remove();
            if(!visited[curr.vertex]){
                visited[curr.vertex] = true;
                finalWeight += curr.weight;

                for(int i=0; i<graph[curr.vertex].size(); i++){
                    Edge e = graph[curr.vertex].get(i);
                    pq.add(new Pair2(e.dest, e.wt));
                }
            }

        }
        System.out.println("Total(min) weight of MST: " + finalWeight);
    }
    public static void main(String args[]){
        // int V = 6;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // dijkstra(graph, 0);


        // int V = 5;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // bellmanFord(graph, 0);


        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        prims(graph);


    }
}
