package JavaDsa.Graphs;
import java.util.ArrayList;

public class CycleDetectionInGraph {
    // We can detect the cycle by dfs and checking visited neighbours. there can be three cases:
    // 1) either the neighbour won't be visited
    // 2) or it won't be visited but it was the parent (ie the neighbour from which we came to this vertex
    // 3) or it is visited and it is not the parent. This is case which tells us of cyclicity.

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

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }
        //graph1:
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

        graph[6].add(new Edge(6,5,1));

        //graph2:
//        graph[0].add(new Edge(0,1,1));
//
//        graph[1].add(new Edge(1,0,1));
//        graph[1].add(new Edge(1,2,1));
//        graph[1].add(new Edge(1,3,1));
//
//        graph[2].add(new Edge(2,1,1));
//        graph[2].add(new Edge(2,4,1));
//
//        graph[3].add(new Edge(3,1,1));
//
//        graph[4].add(new Edge(4,2,1));
    }

    public static boolean cycleDetector(ArrayList<Edge>[] graph, boolean arr[], int k, int par){    //O(V+E)
        arr[k]= true;
        boolean ans= false;
        for(int i=0;i<graph[k].size();i++){
            int n= graph[k].get(i).dest;
            if(arr[n]== true && n!=par){
                ans= true;            // cycle exists
            }
            if(!arr[n]){
                ans= cycleDetector(graph, arr, n, k);
            }
        }
        return ans;      // So in order to work with initial assumption, we return the opposite of that
    }

    public static boolean utilCycleDetection(ArrayList<Edge>[] graph){
        boolean arr[]= new boolean[graph.length];
        boolean ans= true;               // This is opposite to what I should assume but using false as intial assumption
                                         // will need other ideas and take longer.

        for(int i=0; i<graph.length; i++){
            if(!arr[i]){
                ans = ans && !cycleDetector(graph, arr, i, 0);   // if there is a false, the value of ans will change
                                                                     //ie, cycleDetector returned true, which means cycle-> YES
            }
        }
        return !ans;             // same analogy as above. If cycle exists, the value of ans would be false so
                                 // so, return opposite of it
    }


    public static void main(String[] args){
        /*
                1------3
               /       | \
              0        |  5----6
               \       | /
                2------4

         */
        /*
           0---1-----2-----4
               |
               |
               3
         */

        ArrayList<Edge> graph1[]= new ArrayList[7];

        ArrayList<Edge> graph2[]= new ArrayList[5];
        createGraph(graph1);
        System.out.println( utilCycleDetection(graph1) );
    }
}
