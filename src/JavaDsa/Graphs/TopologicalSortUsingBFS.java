package JavaDsa.Graphs;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortUsingBFS {
    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w){
            this.src= s;
            this.dest=d;
            this.wt= w;
        }
    }
    public static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[2].add(new Edge(2,3,1));

        graph[3].add(new Edge(3,1,1));

        graph[4].add(new Edge(4,0,1));
        graph[4].add(new Edge(4,1,1));

        graph[5].add(new Edge(5,0,1));
        graph[5].add(new Edge(5,2,1));

    }

    public static void topoUsingBFS(ArrayList<Edge>[] graph) {
        int indegree[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {           //O(V+E)
            for (int j = 0; j < graph[i].size(); j++) {
                int n = graph[i].get(j).dest;
                indegree[n]++;
            }
        }
        // Done till here

        for(int i=0; i<indegree.length; i++){             //O(V)
            if(indegree[i]==0){
                q.add(i);
                vis[i]= true;
            }
        }

        while(!q.isEmpty()){                              //O(V+E)
            int n= q.remove();
            System.out.print(n+" ");
            for(int i=0; i<graph[n].size(); i++){
                int d= graph[n].get(i).dest;
                indegree[d]--;
                if(indegree[d]==0){
                    q.add(d);
                    vis[d]= true;
                }
            }
        }

//        for(int i=0; i<graph.length; i++) {
//            if(indegree[i]== 0 && !vis[i]){
//                q.add(i);
//                vis[i]= true;
////                System.out.print(i+ " ");
////                vis[i]= true;
//                for(int j=0; j<graph[i].size(); j++){
//                    int n= graph[i].get(j).dest;
//                    indegree[n]--;
//                    if(indegree[n]==0){
//                        q.add(n);
//                    }
//                }
//            }

//            for(int j=0; j<graph[i].size(); j++){
//                int n= graph[i].get(j).dest;
//                //System.out.print(i+"->i " + n+"->This n ");
//                if(vis[i]){
//                    indegree[n]--;
//                }
//                if(indegree[n]== 0){
//                    System.out.print(n + " ");
//                    vis[n]= true;
//                }
//            }
//        }

    }

    public static void main(String[] args){
        /*
                     5---->0<----4
                     |           |              //Do BFS using normal 'for' loop and queue but here for topological sorting,
                     |           |               we use a special array to store the indegree of all the vertices
                     V           V               Indegree means the number of the in's for the vertex
                     2---->3---->1               eg: Indegree of 1 ,here, is 2 and of 3 is 1
         */

        int V= 6;
        ArrayList<Edge>[] graph= new ArrayList[6];
        createGraph(graph);
        topoUsingBFS(graph);
    }
}
