package JavaDsa.Graphs;
import java.util.ArrayList;
import java.util.HashSet;

public class CycleDetectionInDirectedGraph {    //Needs to be reviewed
    // There can be two cases if the vertex we visit is already visited:
    // 1) it does not have any connection to cycle
    // 2) It is a part of the cycle
    //for example:     1----*0*----2                  no cycle exists here as we won't be circling in any loop
    //                       *   *                    * == arrow head
    //                       |  /
    //                        3
    // , here if we start dfs from 0, and then 1,
    // we might see 0 marked visited, but it is not a part of any cycle.

    static class Edge{
        int src;
        int dest;
         int wt;
         public Edge(int s, int d, int w){
             this.src= s;
             this.dest=d;
             this.wt= w;
         }
    }

    public static void constructGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++) {
            graph[i]= new ArrayList<>();
        }
          //graph1:
//        graph[0].add(new Edge(0,1,1));
//        graph[0].add(new Edge(0,3,1));
//
//        graph[2].add(new Edge(2,0,1));
//
//        graph[3].add(new Edge(3,2,1));

        //graph2:
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,3,1));
    }

    public static boolean cycleDetectUtil(ArrayList<Edge>[] graph, boolean arr[], int k, HashSet<Integer> hs){
        boolean ans= false;
        arr[k]= true;
        hs.add(k);
        if(graph[k]== null){
            return false;                          // graph has no more edges
        }
        for(int i=0;i<graph[k].size();i++){
            int n= graph[k].get(i).dest;
            if(arr[n]== true && hs.contains(n)){
                return true;                         // cycle exists
            }
            if(arr[n]== false){
                ans = cycleDetectUtil(graph, arr, n, hs);
            }

        }
        hs.remove(k);          //Very important line... Think over it. You will find the clue written somewhere
                               // in the codes themselves
        return ans;
    }

    public static boolean cycleDetect(ArrayList<Edge> graph[]){        //O(V+E)
        boolean ans= true;    // Putting opposite value of what I have assumed. I assumed no cycle but put true.
                              // same logic as normal CycleDetection question

        boolean arr[]= new boolean[graph.length];     // Array ro denote visited vertices
        for(int i=0;i<graph.length;i++){
            if(!arr[i]){
                ans = ans && !cycleDetectUtil(graph, arr, i, new HashSet<>());
            }
        }
        return !ans;
    }


    public static void main(String[] args){
        /*
             1*----0----*3
                   *    /
                   |   /
                   |  *       here, *== arrowhead
                    2
         */
        /*
                     0
                    / \
                   /   \
                  *     *
                 1       2
                  \     /
                   \   /
                    * *
                     3
         */
        int V= 4;
//        ArrayList<Edge> graph1[]= new ArrayList[V];
//        constructGraph(graph1);

        ArrayList<Edge> graph2[]= new ArrayList[V];
        constructGraph(graph2);
        boolean cycle= cycleDetect(graph2);
        if(cycle){
            System.out.println("Cycle exists");
        }else{
            System.out.println("Cycle doesn't exist");
        }
    }
}
