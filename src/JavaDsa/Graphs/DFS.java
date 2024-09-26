package JavaDsa.Graphs;
import java.util.ArrayList;

public class DFS {    //working fine... quality check ✅

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w){
            this.src= s;
            this.dest= d;
            this.wt= w;
        }
    }

    public static void insert(ArrayList<Edge> graph[]){

        // graphs is an array of type arraylist where arraylists are storing the edges of the graph
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        // defining the edges
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));

        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));

    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, int[] arr){  //O(E+V)
        // dfs can be implemented using either recursion or stack. we are using recursion
        if(arr[curr]==1){
            return;
        }
        if(arr[curr]==0){
            System.out.println(curr);
            arr[curr]=1;
        }

        for(int i=0;i<graph[curr].size();i++){
            dfs(graph, graph[curr].get(i).dest, arr);
        }

    }

    public static void main(String[] args){
        /*
                1------3f
               /       | \
              0        |  5----6
               \       | /
                2------4

         */
        ArrayList<Edge> graph[]= new ArrayList[7];
        insert(graph);
        int arr[]= new int[7];     // we can use boolean array which uses less memory but I am lazy.
        dfs(graph, 0, arr);
    }
}
