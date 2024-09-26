package JavaDsa.Graphs;
import java.util.*;

public class BFS {

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

    static void createGraph(ArrayList<Edge> graph[]){
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

    public static void bfs(ArrayList<Edge> graph[]){    //O(V+E)
        Queue<Integer> q= new LinkedList<>();    // Queues are implemented using LinkedLists (remember)
        int arr[]= new int[7];      // this array keeps track of all the visited vertices;
        //Let's say we start with 0;
        q.add(0);
        arr[0]=1;
        while(!q.isEmpty()){
            int x= q.remove();
            System.out.println(x);
            for(int i=0;i<graph[x].size();i++){
                int j= graph[x].get(i).dest;
                if(arr[j]==0){
                    q.add(j);
                    arr[j]=1;     // This step is the most imp;
                }
                else{
                    // it is already visited or added in the queue so sit back and relax bro;
                }
            }
        }
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
        createGraph(graph);
        bfs(graph);
        //learn bfs again if you need to;
    }
    
}
