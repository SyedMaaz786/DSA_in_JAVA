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
    // static void createGraph(ArrayList<Edge> graph[]){
    //     for(int i=0; i<graph.length; i++){
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0, 2));
    //     graph[0].add(new Edge(0, 3));

    //     graph[1].add(new Edge(1, 0));

    //     graph[2].add(new Edge(2, 1));

    //     graph[3].add(new Edge(3, 4));
    // }
    // // Strongly Connected Components - kosaraju algorithm O(V+E) 
    // //2nd 
    // public static void topSort(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s){
    //     visited[curr] = true;

    //     for(int i=0; i<graph[curr].size(); i++){
    //         Edge e = graph[curr].get(i);
    //         if(!visited[e.dest]){
    //             topSort(graph, e.dest, visited, s);
    //         }
    //     }
    //     s.push(curr);
    // }
    // //3rd 
    // public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]){
    //     visited[curr] = true;
    //     System.out.print(curr + " ");

    //     for(int i=0; i<graph[curr].size(); i++){
    //         Edge e = graph[curr].get(i);
    //         if(!visited[e.dest]){
    //             dfs(graph, e.dest, visited);
    //         }
    //     }
    // }
    // //1st
    // public static void kosaraju(ArrayList<Edge> graph[], int V){
    //     //step 1
    //     Stack<Integer> s = new Stack<>();
    //     boolean visited[] = new boolean[V];
    //     for(int i=0; i<V; i++){
    //         if(!visited[i]){
    //             topSort(graph, i, visited, s);
    //         }
    //     }
    //     //step 2
    //     ArrayList<Edge> transpose[] = new ArrayList[V];
    //     for(int i=0; i<graph.length; i++){
    //         visited[i] = false; //to use visited set it back to false
    //         transpose[i] = new ArrayList<>();
    //     }
    //     for(int i=0; i<V; i++){
    //         for(int j=0; j<graph[i].size(); j++){
    //             Edge e = graph[i].get(j); //e.src -> e.dest
    //             transpose[e.dest].add(new Edge(e.dest, e.src)); //reverse (e.dest -> e.src)
    //         }
    //     }
    //     //step 3
    //     while(!s.isEmpty()){
    //         int curr = s.pop();
    //         if(!visited[curr]){
    //             System.out.print("SCC -> ");
    //             dfs(transpose, curr, visited);
    //             System.out.println();
    //         }
    //     }
    // }

    
    // //Bridge in a Graph (Tarjan's Algorithm) (it's easy check lecture for understanding + dryrun)
    // static void createGraph(ArrayList<Edge> graph[]){
    //     for(int i=0; i<graph.length; i++){
    //         graph[i] = new ArrayList<>();
    //     }

    //     graph[0].add(new Edge(0, 1));
    //     graph[0].add(new Edge(0, 2));
    //     graph[0].add(new Edge(0, 3));

    //     graph[1].add(new Edge(1, 0));
    //     graph[1].add(new Edge(1, 2));

    //     graph[2].add(new Edge(2, 0));
    //     graph[2].add(new Edge(2, 1));

    //     graph[3].add(new Edge(3, 0));
    //     graph[3].add(new Edge(3, 4));
    //     graph[3].add(new Edge(3, 5));

    //     graph[4].add(new Edge(4, 3));
    //     graph[4].add(new Edge(4, 5));

    //     graph[5].add(new Edge(5, 3));
    //     graph[5].add(new Edge(5, 4));
    // }
    // //2nd
    // public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int lowdt[], boolean visited[], int time){
    //     visited[curr] = true;
    //     dt[curr] = lowdt[curr] = ++time;

    //     for(int i=0; i<graph[curr].size(); i++){
    //         Edge e = graph[curr].get(i);
    //         int neigh = e.dest; //for simplicity
    //         if(neigh == par){
    //             continue;
    //         }
    //         else if(!visited[neigh]){
    //             dfs(graph, neigh, curr, dt, lowdt, visited, time);
    //             lowdt[curr] = Math.min(lowdt[curr], lowdt[neigh]);
    //             if(dt[curr] < lowdt[neigh]){
    //                 System.out.println("Bridge: " + curr + " ---> " + neigh);
    //             }
    //         }
    //         else{
    //             lowdt[curr] = Math.min(lowdt[curr], dt[neigh]);
    //         }
    //     }
    // }
    // //1st
    // public static void tarjanBridge(ArrayList<Edge> graph[], int V){
    //     int dt[] = new int[V]; // discovery time - dt
    //     int lowdt[] = new int[V];
    //     int time = 0;
    //     boolean visited[] = new boolean[V];

    //     for(int i=0; i<V; i++){
    //         if(!visited[i]){
    //             dfs(graph, i, -1, dt, lowdt, visited, time);
    //         }
    //     }
    // }


    //Articulation Point (Tarjan's algorithm) O(V+E) (it's easy check lecture for understanding + dryrun)
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
    //2nd
    public static void dfs(ArrayList<Edge> graph[], int curr, int par, int dt[], int lowdt[], boolean visited[], boolean ap[], int time){
        visited[curr] = true;
        dt[curr] = lowdt[curr] = ++time;
        int children = 0;

        for(int i=0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            int neigh = e.dest;

            if(par == neigh){
                continue;
            }
            else if(visited[neigh]){
                lowdt[curr] = Math.min(lowdt[curr], dt[neigh]);
            }
            else{
                dfs(graph, neigh, curr, dt, lowdt, visited, ap, time);
                lowdt[curr] = Math.min(lowdt[curr], lowdt[neigh]);
                if(par != -1 && dt[curr] <= lowdt[neigh]){
                    ap[curr] = true; // ap exists
                }
                children++;
            }
        }
        if(par == -1 && children > 1){
            ap[curr] = true; // ap exists
        }
    }
    //1st
    public static void getAP(ArrayList<Edge> graph[], int V){
        int dt[] = new int[V];
        int lowdt[] = new int[V];
        int time = 0;
        boolean visited[] = new boolean[V];
        boolean ap[] = new boolean[V];

        for(int i=0; i<V; i++){
            if(!visited[i]){
                dfs(graph, i, -1, dt, lowdt, visited, ap, time);
            }
        }
        //print all ap's
        for(int i=0; i<V; i++){
            if(ap[i]){ 
                System.out.println("Ap:" + i);
            }
        }
    }
    public static void main(String args[]){
        // int V = 5;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // kosaraju(graph, V);


        // int V = 6;
        // ArrayList<Edge> graph[] = new ArrayList[V];
        // createGraph(graph);
        // tarjanBridge(graph, V);


        int V = 5;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        getAP(graph, V);
    }
}
