import java.util.*;

public class v_Graph07 {
    //Kruskal's algorithm for MST O(ElogE) (it's easy)
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        @Override
        public int compareTo(Edge e2){
            return this.wt - e2.wt;
        }
    }
    static void createGraph(ArrayList<Edge> edges){ //here graph is implemented using edge list
        //edges
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }
    static int n = 4;
    static int par[] = new int[n];
    static int height[] = new int[n];

    public static void init(){
        for(int i=0; i<n; i++){
            par[i] = i;
        }
    }
    public static int find(int x){
        if(x == par[x]){
            return x;
        }
        return par[x] = find(par[x]);
    }
    public static void union(int a, int b){
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
            par[parB] = parB;
        }
    }
    public static void kruskals(ArrayList<Edge> edges, int V){
        init();
        Collections.sort(edges); // we get edges in ascending order
        int finalWeight = 0;
        int count = 0;

        for(int i=0; count<V-1; i++){ // loop runs till total edges if V is 4 then 3 edges to connect them
            Edge e = edges.get(i);
            int parA = find(e.src); // src = a
            int parB = find(e.dest); // dest = b
            if(parA != parB){ // if set1 is not equal to set2 then no cycle.
                union(e.src, e.dest);
                finalWeight += e.wt;
                count++;
            }
        }
        System.out.println(finalWeight);
    }
    //FloodFill Algorithm (it's easy check lecture for understanding and dryrun)
    //2nd
    public static void helper(int[][] image, int sr, int sc, int color, boolean visited[][], int orgCol){
        if(sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length ||
            visited[sr][sc] || image[sr][sc] != orgCol){ // it's easy - lecture if dought
            return;
        }

        image[sr][sc] = color; //fill color + visited true
        visited[sr][sc] = true;

        //up
        helper(image, sr-1, sc, color, visited, orgCol);
        //down
        helper(image, sr+1, sc, color, visited, orgCol);
        //left
        helper(image, sr, sc-1, color, visited, orgCol);
        //right
        helper(image, sr, sc+1, color, visited, orgCol);
        
    }
    //1st
    public static int[][] floodFill(int[][] image, int sr, int sc, int color){
        int orgCol = image[sr][sc]; //this sets orgColor 1 
        boolean visited[][] = new boolean[image.length][image[0].length];
        helper(image, sr, sc, color, visited, orgCol);
        return image;
    }
    public static void main(String args[]){
        // int V = 4;
        // ArrayList<Edge> edges = new ArrayList<>(); //here graph is edge list 
        // createGraph(edges);
        // kruskals(edges, V);


        int[][] image = {{1, 1, 1},
                         {1, 1, 0},
                         {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int color = 2;

        floodFill(image, sr, sc, color);
        //print
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
