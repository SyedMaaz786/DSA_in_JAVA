import java.util.*;

public class v_Graph06 {
    //Connecting Cities (we have used prims algo here) (it's easy lecture for understanding and dryrun)
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
    //Disjoint Set Union (imp - check lecture for understanding and lecture)
    static int n = 7;
    static int par[] = new int[n];
    static int height[] = new int[n]; // no need to init this arr because is will be 0 default at the starting

    public static void init(){ //fnx for init values in par with itself
        for(int i=0; i<n; i++){
            par[i] = i;
        } 
    }
    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = find(par[x]); //keep finding recursively until we get with path compression
    }
    public static void union(int a, int b){ //check lecture once and stare run the pipeline in mind you got this in the 2nd time
        int parA = find(a);
        int parB = find(b);

        if(height[parA] == height[parB]){
            par[parB] = parA;
            height[parA]++;
        }
        else if(height[parA] < height[parB]){
            par[parA] = parB;
        }
        else{
            par[parB] = parA;
        }
    }
    public static void main(String args[]){ 
        // int cities[][] = {{0,1,2,3,4},
        //                   {1,0,5,0,7},
        //                   {2,5,0,6,0},
        //                   {3,0,6,0,0},
        //                   {4,7,0,0,0}};
        // System.out.println(connectCities(cities));


        init();
        System.out.println(find(2));
        union(1, 3);
        System.out.println(find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println(find(3));
        System.out.println(find(4));
        union(1, 5);
    }
}
