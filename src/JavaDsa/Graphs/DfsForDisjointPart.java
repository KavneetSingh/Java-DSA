package JavaDsa.Graphs;

import java.util.ArrayList;

public class DfsForDisjointPart {    //Explained in the main function.
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

    public static void create(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,8,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,7,1));

        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,9,1));

        graph[3].add(new Edge(3,2,1));
        graph[3].add(new Edge(3,9,1));

        graph[4].add(new Edge(4,5,1));
        graph[4].add(new Edge(4,7,1));
        graph[4].add(new Edge(4,8,1));

        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));
        graph[5].add(new Edge(5,7,1));

        graph[6].add(new Edge(6,5,1));

        graph[7].add(new Edge(7,1,1));
        graph[7].add(new Edge(7,4,1));
        graph[7].add(new Edge(7,5,1));

        graph[8].add(new Edge(8,0,1));
        graph[8].add(new Edge(8,4,1));

        graph[9].add(new Edge(9,2,1));
        graph[9].add(new Edge(9,3,1));
    }

    public static void dfsUtil(ArrayList<Edge>[] graph,boolean arr[], int k){
        arr[k]= true;
        System.out.print(k + " ");
        for(int i=0;i<graph[k].size();i++){
            int n= graph[k].get(i).dest;
            if(!arr[n]){
                dfsUtil(graph, arr, n);
            }
        }

    }

    public static void dfs(ArrayList<Edge>[] graph){
        boolean arr[]= new boolean[graph.length];
        for(int i=0; i<graph.length; i++){
            if(!arr[i]){
                dfsUtil(graph, arr, i);
            }
        }
    }

    public static void main(String[] args){
        /*
        Let's say there is a graph which has disjoint parts in it.

                1------7
               /       | \
              0        |  5----6       2---3
               \       | /             |  /
                8------4               | /
                                       9
           So we need a different dfs function for traversal in this case.
           what we do is we traverse through the visited array (boolean) and perform dfs for all the vertices
           which are unvisited.
         */

        int V= 10;
        ArrayList<Edge>[] graph= new ArrayList[V];
        create(graph);
        dfs(graph);


    }
}
