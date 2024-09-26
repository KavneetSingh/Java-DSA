package JavaDsa.Graphs;
import java.util.*;

public class EveryRouteFromAtoB {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int w){
            this.src= s;
            this.dest= d;
            this.wt= w;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,3,1));
        graph[2].add(new Edge(2,3,1));

        graph[3].add(new Edge(3,1,1));

        graph[4].add(new Edge(4,0,1));
        graph[4].add(new Edge(4,1,1));

        graph[5].add(new Edge(5,0,1));
        graph[5].add(new Edge(5,2,1));
    }

    static HashSet<String> s= new HashSet<>();
    public static void paths(ArrayList<Edge>[] graph, int src, int d, StringBuilder str){    //O(V^V) worst time complexity
        if(src==d){
            str.append(d);
            s.add(str.toString());
            str.deleteCharAt(str.length()-1);         //Important
        }

        for(int i=0; i<graph[src].size(); i++){
            int n= graph[src].get(i).dest;
            str.append(src);
            paths(graph, n, d, str);
            str.deleteCharAt(str.length()-1);         //Important
        }
    }

    public static void main(String[] args){
        /*
                     5---->0<----4
                     |     |     |              We start from source to its neighbour and then recursively to the dest.
                     |     |     |              After reaching the destination add the string to the Set and return
                     V     V     V
                     2---->3---->1
         */

        int V= 6;
        ArrayList<Edge>[] graph= new ArrayList[V];

        int source= 5;
        int destination= 1;
        createGraph(graph);
        paths(graph, source, destination, new StringBuilder(""));
        System.out.println(s);
    }
}
