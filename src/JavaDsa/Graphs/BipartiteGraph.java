package JavaDsa.Graphs;

import java.util.ArrayList;

public class BipartiteGraph {
    //bipartite graphs are graphs which have vertices such that they can be divided into 2 disjoint sets
    // any edge U---V  can only have U and V in set 1 and set 2 and
    // no two vertices lying in the same set can have an edge in between.

    //we can add an array type where initially will be stored -1 and later we can assign it either 0 (yellow or 1 (blue)
    // we can simply check if any two neighbours are assigned the same colour and return unbipartite.
    //if all vertices are of different colour, then the graph is bipartite...
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src=s;
            this.dest= d;
            this.wt= w;

        }

    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }
        //graph with 4 vertices
//        graph[0].add(new Edge(0,1,1));
//        graph[0].add(new Edge(0,2,1));
//
//        graph[1].add(new Edge(1,0,1));
//        graph[1].add(new Edge(1,3,1));
//
//        graph[2].add(new Edge(2,0,1));
//        graph[2].add(new Edge(2,3,1));
//
//        graph[3].add(new Edge(3,1,1));
//        graph[3].add(new Edge(3,2,1));

        // for graph with 5 vertices
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));

        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));

        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));

        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
    }

    public static boolean bipartiteGraphUtil(ArrayList<Edge>[] graph, int arr[], int k, int prevColor){
        boolean ans= true;    // initial assumption: graph is bipartite
        if(arr[k]==-1){
            if(prevColor==-1 || prevColor==1){
                arr[k]= 0;
            }
            else{
                arr[k]= 1;
            }
        }
        for(int i=0;i<graph[k].size();i++){
            int n= graph[k].get(i).dest;
            if(arr[n]==-1){
                ans= ans && bipartiteGraphUtil(graph, arr, n, arr[k]);
            }
            if(arr[n]== arr[k]){
                return false;
            }
        }
        return ans;
    }

    public static boolean bipartiteCheck(ArrayList<Edge>[] graph) {
        boolean ans= true;
        int arr[]= new int[graph.length];
        for(int i=0;i<graph.length;i++){
            arr[i]= -1;
        }
        for(int i=0;i<graph.length;i++){
            if(arr[i]==-1){
                ans= ans && bipartiteGraphUtil(graph, arr, i, -1);
            }
        }
        return ans;
    }

    public static void main(String[] args){     //O(E+V)
        //If graph does not have any cycles then it has to be a bipartite graph
        //Even cycle always means bipartite and odd cycle always has non-bipartite nature

        /*
                      0                   0
                     / \                /   \
                    1   2              1     2
                     \ /               |     |
                      3                3-----4
         */
        int V= 4;
        ArrayList<Edge>[] graph= new ArrayList[V];
        int V2= 5;
        ArrayList<Edge>[] graph2= new ArrayList[V2];

        //createGraph(graph);   // bipartite
        createGraph(graph2);   //not bipartite
        if(bipartiteCheck(graph2)){
            System.out.println("Yes Bipartite");
        }else{
            System.out.println("Not Bipartite");
        }

    }
}
