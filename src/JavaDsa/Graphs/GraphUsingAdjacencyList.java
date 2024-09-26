package JavaDsa.Graphs;
import java.util.ArrayList;

public class GraphUsingAdjacencyList {

    //array of arrayList= arr[AL<edges>]   , ie no. of vertices is fixed and no. of edges is not
    static class Edge{
        int src;      //from source
        int dest;     // to destination
        int wt;       // in time or cost or weight

        public Edge(int s, int d, int w){
            this.dest= d;
            this.src= s;
            this.wt= w;
        }
    }

    public static void main(String[] args){

        /*        (5)
              0-------1                               This is the graph we want to create
                     / \
                (1) /   \  (3)
                   /     \
                  2-------3
                  |    (1)
              (2) |
                  |
                  4
         */

        int V=5;
        ArrayList<Edge> graph[]= new ArrayList[V];   //compare it with--> int arr[]= new int[];
        // for now only null is stored in the array, so the first task is to add empty arraylists in it.
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,5));
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));
        graph[4].add(new Edge(4,2,2));


        //print all neighbours of 2:
        for(int i=0; i<graph[2].size(); i++){
            Edge e= graph[2].get(i);
            System.out.println(e.dest);
        }
    }
}
