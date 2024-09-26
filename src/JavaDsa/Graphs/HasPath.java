package JavaDsa.Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HasPath { // Search weather any path exists from the source to destination

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

    public static void insert(ArrayList<Edge> graph[]){

        // graphs is an array of type arraylist where arraylists are storing the edges of the graph
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        // defining the edges
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

    }

    public static boolean pathExists(ArrayList<Edge>[] graph, int s, int d){
        if(s==d){
            return true;
        }
        Queue<Integer> q= new LinkedList<>();  // doing the traversal using bfs
        q.add(s);
        boolean arr[]= new boolean[7];
        arr[s]= true;
        while(!q.isEmpty()){
            int t= q.remove();
            for(int i=0;i<graph[t].size();i++){
                int x= graph[t].get(i).dest;
                if(!arr[x]){
                    q.add(x);
                    if(x== d){
                        return true;
                    }
                    arr[x]= true;
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
        ArrayList<Edge> graph[]= new ArrayList[7];
        insert(graph);
        int source= 0;
        int destination= 6;
        System.out.println(pathExists(graph, source, destination));
    }
}
