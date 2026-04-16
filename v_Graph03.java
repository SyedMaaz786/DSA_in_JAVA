import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    // //Topological Sorting (using DFS) O(L+E) (it's easy)
    // //2nd
    // public static void topSort(ArrayList<Edge> graph[]){
    //     boolean visited[] = new boolean[graph.length];
    //     Stack<Integer> s = new Stack<>();

    //     for(int i=0; i<graph.length; i++){
    //         if(!visited[i]){
    //             topSortUtil(graph, i, visited, s);
    //         }
    //     }
    //     while(!s.isEmpty()){
    //         System.out.print(s.pop() + " ");
    //     }
    // }
    // //1st
    // public static void topSortUtil(ArrayList<Edge> graph[], int curr, boolean visited[], Stack<Integer> s){
    //     visited[curr] = true;

    //     for(int i=0; i<graph[curr].size(); i++){
    //         Edge e = graph[curr].get(i);
    //         if(!visited[e.dest]){
    //             topSortUtil(graph, e.dest, visited, s);
    //         }
    //     }
    //     s.push(curr);
    // }
    //Topological Sorting (using BFS) O(L+E) (lecture for understanding and dryrun)
    //2nd
    public static void calcIndeg(ArrayList<Edge> graph[], int indeg[]){
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].size(); j++){
                Edge e = graph[i].get(j);
                indeg[e.dest]++;
            }
        }
    }
    //1st
    public static void topSort(ArrayList<Edge> graph[]){
        int indeg[] = new int[graph.length];
        calcIndeg(graph, indeg);
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<indeg.length; i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        //3rd
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr + " "); //topological sort print
            
            for(int i=0; i<graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                indeg[e.dest]--;
                if(indeg[e.dest] == 0){
                    q.add(e.dest);
                }
            }
        }
    }
    //All paths from source to destination TC-exponential O(2^V × V) (it's easy lecture for understanding and dryrun)
    public static void printAllPath(ArrayList<Edge> graph[], int src, int dest, String path){
        if(src == dest){
            System.out.print(path + dest);
            return;
        }
        for(int i=0; i<graph[src].size(); i++){
            Edge e = graph[src].get(i);
            printAllPath(graph, e.dest, dest, path + src);
        }
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
        // System.out.println(isCycle(graph));


        // topSort(graph);

        int src = 0, dest = 3;
        printAllPath(graph, src, dest, " ");
    }
}
