package JavaDsa.Graphs;
import java.util.*;

public class DetectCycleUsingBFS {
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

    }

//    public static boolean helper(ArrayList<Edge>[] graph, int parent, int curr, boolean[] vis){
//
//    }

    public static boolean detectUsingBFS(ArrayList<Edge>[] graph){
        boolean visited[]= new boolean[graph.length];
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        visited[0]= true;
        int par= -1;     //parent

        while(!q.isEmpty()){
            int n= q.remove();

            for(int i=0;i<graph[n].size();i++){
                int d= graph[n].get(i).dest;

                //Case 1: d is not visited
                if(!visited[d]){
                    q.add(d);
                    visited[d]= true;
                }
                //Case 2: d is visited
                else if(visited[d] && d!=n){
                    return true;
                }
                else{                         //visited 'd' but it is the parent.
                    // Eat 5 star. DO NOTHING.
                }
            }
        }
        return false;
    }

    public static void main(String[] args){

        /*
                1------3
               /       | \
              0        |  5----6
               \       | /
                2------4

         */

        int V= 7;
        ArrayList<Edge>[] graph= new ArrayList[V];
        createGraph(graph);

        boolean ans= detectUsingBFS(graph);
        System.out.println(ans);
    }
}
