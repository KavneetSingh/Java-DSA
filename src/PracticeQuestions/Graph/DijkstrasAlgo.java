package PracticeQuestions.Graph;
import java.util.*;

public class DijkstrasAlgo {

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

    public static void distCalc(ArrayList<Edge> graph[], int curr, int dist[]){
        if(graph[curr].size()==0){
            return;
        }

        for(int i=0;i<graph[curr].size();i++){
            Edge e= graph[curr].get(i);
            if(dist[e.dest] > dist[curr] + e.wt ){
                dist[e.dest]= dist[curr] + e.wt;
                distCalc(graph, e.dest, dist);
            }
        }
    }


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

    public static void main(String[] args){
        int V= 6;
        ArrayList<Edge> graph[]= new ArrayList[V];
        createGraph(graph);

        int minDist[]= new int[V];

        for(int i=0;i<V;i++){
            minDist[i]= Integer.MAX_VALUE;
        }

        int src=0;
        minDist[src]= 0;

        distCalc(graph, src, minDist);

        for(int i=0;i<V;i++){
            System.out.println("dist from 0 to " + i + " is " + minDist[i]);
        }
    }
}
