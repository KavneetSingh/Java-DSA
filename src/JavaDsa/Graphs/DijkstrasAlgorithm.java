package JavaDsa.Graphs;
import java.util.*;

public class DijkstrasAlgorithm {     //O(V+ElogV)        //can be used for directed and indirected graphs
    //We need to find the min dist from a given source to all the vertices
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
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));

        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }


    public static void dijkstra(ArrayList<Edge>[] graph, int s, int[] cost, int currCost, int currTraversals, int sizeOfGraph){
        if(currTraversals>= sizeOfGraph){   //This is a short method for not letting it go into infinite loop.
                                            //There can be a max of 'V' iterations from a given source so I think that's enough
            return;
        }


        if( graph[s]== null){
            return;
        }

        for(int i=0;i<graph[s].size();i++){
            int d= graph[s].get(i).dest;
            int w= graph[s].get(i).wt;
            if(currCost + w < cost[d]){  // If the currCost from the source is less than already calculated cost, replace it.
                cost[d]= currCost + w;

                dijkstra(graph, d, cost, currCost+w, currTraversals+1, sizeOfGraph);
            }
        }


    }


    public static void main(String[] args){

        /*           1 ----------* 3
                    * |    7      * \
                 2 /  |           |  \ 1                  weighted and directed graph
                  /   |           |   *
                 0    | 1       2 |    5
                  \   |           |   *
                 4 \  |           |  / 5
                    * *    3      | /
                     2 ----------* 4
         */

        int V= 6;
        ArrayList<Edge>[] graph= new ArrayList[V];
        createGraph(graph);
        int source= 0;
        int[] cost= new int[6];

        Arrays.fill(cost, Integer.MAX_VALUE);        //New method

        cost[source]= 0;
        dijkstra(graph, 0, cost, 0, 0, V);
        for (int i=0; i<cost.length; i++) {
            System.out.println("Minimum cost for "+ i + " is=> " + cost[i]);
        }
    }
}
