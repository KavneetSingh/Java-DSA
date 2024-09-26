package AI_External_Practical;

import JavaDsa.Graphs.BFS;
import JavaDsa.Graphs.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DFSBFS {

    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d){
            this.src= s;
            this.dest= d;
        }
    }

    public static void insert(ArrayList<Edge> graph[]){

        // graphs is an array of type arraylist where arraylists are storing the edges of the graph
        for(int i=0;i< graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        // defining the edges
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,4));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,2));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,3));

    }

    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] vis){  //O(E+V)
        // dfs can be implemented using either recursion or stack. we are using recursion
        if(vis[curr]){
            return;
        }
        if(!vis[curr]){
            System.out.println(curr);
            vis[curr]=true;
        }

        for(int i=0;i<graph[curr].size();i++){
            dfs(graph, graph[curr].get(i).dest, vis);
        }

    }

    public static void bfs(ArrayList<Edge> graph[]){    //O(V+E)
        Queue<Integer> q= new LinkedList<>();    // Queues are implemented using LinkedLists (remember)
        int arr[]= new int[5];      // this array keeps track of all the visited vertices;
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
        ArrayList<Edge> graph[]= new ArrayList[5];
        insert(graph);
        System.out.println("DFS:");
        boolean vis[]= new boolean[graph.length];
        dfs(graph, 0, vis);
        System.out.println("BFS:");
        bfs(graph);
    }
}
