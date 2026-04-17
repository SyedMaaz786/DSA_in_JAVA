import java.util.*;

public class v_Graph06 {
    //Connecting Cities (we hvae used prims algo here) (it's easy lecture fir understanding and dryrun)
    static class Edge implements Comparable<Edge>{
        int dest;
        int wt;

        public Edge(int d, int w){
            this.dest = d;
            this.wt = w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }
    public static int connectCities(int cities[][]){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[cities.length];

        pq.add(new Edge(0, 0));
        int finalWeight = 0;

        while(!pq.isEmpty()){
            Edge curr = pq.remove();
            if(!visited[curr.dest]){
                visited[curr.dest] = true;
                finalWeight += curr.wt;

                for(int i=0; i<cities[curr.dest].length; i++){
                    if(cities[curr.dest][i] != 0){ //process only if edge exist if weight is 0 then no edge exist
                        pq.add(new Edge(i, cities[curr.dest][i]));
                    }
                }
            }
        }
        return finalWeight;
    }
    public static void main(String args[]){
        int cities[][] = {{0,1,2,3,4},
                          {1,0,5,0,7},
                          {2,5,0,6,0},
                          {3,0,6,0,0},
                          {4,7,0,0,0}};
        System.out.println(connectCities(cities));
    }
}
