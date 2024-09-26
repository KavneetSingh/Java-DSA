package PracticeQuestions.LeetCode.Graph;
import java.util.*;

public class DesignGraphWithShortestPathCalculator {

    //LeetCode Q)2642
    //Wrong solution ❌..  Use Dijkstra or simply calculate the dist bw every pair of nodes at the beginning.
    class Graph {

        ArrayList<Edge>[] graph;
        int[][] distance;
        int n;

        public Graph(int n, int[][] edges) {

            this.n = n;
            distance = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Integer.MAX_VALUE;
                }
                distance[i][i] = 0;
            }

            for (int[] edge : edges) {
                distance[edge[0]][edge[1]] = edge[2];
            }

            for (int k = 0; k < n; k++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        distance[i][j] = Math.min(
                                distance[i][j],
                                distance[i][k] + distance[k][j]
                        );
                    }
                }
            }
        }

        public void addEdge(int[] edge) {
            if (distance[edge[0]][edge[1]] <= edge[2]) {
                return;
            }
            distance[edge[0]][edge[1]] = edge[2];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][edge[0]] + edge[2] + distance[edge[1]][j]);
                }
            }
        }

        public int shortestPath(int node1, int node2) {
            if (distance[node1][node2] == Integer.MAX_VALUE) {
                return -1;
            }
            return distance[node1][node2];
        }
    }

//    class Pair{
//        int ch;     //child
//        int par;    //parent
//        int idx;    //which index'th edge of par is the child
//
//        Pair(int c, int p, int i){
//            this.ch= c;
//            this.par= p;
//            this.idx= i;
//        }
//    }

    class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w){
            this.src= s;
            this.dest= d;
            this.wt= w;
        }
    }

}
