package JavaDsa.Graphs;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSorting {         //time complexity= O(V+E)    and space complexity= O(V)

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
        for(int i=0; i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        graph[2].add(new Edge(2,3,1));

        graph[3].add(new Edge(3,1,1));

        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,4,1));

        graph[5].add(new Edge(5,0,1));
        graph[5].add(new Edge(5,2,1));
    }

    public static void topoUtil(ArrayList<Edge>[] graph, boolean[] arr, Stack<Integer> s, int curr){
        arr[curr]= true;
        for(int i=0;i<graph[curr].size();i++){
            int n= graph[curr].get(i).dest;
            if(!arr[n]){
                topoUtil(graph, arr, s, n);
            }
        }
        s.add(curr);
    }

    public static void topologicalSort(ArrayList<Edge>[] graph){
        boolean vis[]= new boolean[graph.length];
        Stack<Integer> s= new Stack<>();

        for(int i=0;i<vis.length;i++){
            if(!vis[i]){
                topoUtil(graph, vis, s, i);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.remove(s.size()-1) + " ");      //or simply use function=> s.pop();
        }
    }

    public static void main(String[] args){
        //Topological sorting is done only for Directed Acyclic Graphs (DAG)
        /*
            DAG like:       A            A--->B
                           / \           A--->C
                          /   \          C--->B
                         *     *
                        B*------C
             Topological sorting is done by putting all the vertices in an order such that vertex which are destination
             come after the source vertex

             The answer of Topological sort for the above graph will be:    A, C, B.   Here C comes before B and
             A comes before both of them because an edge goes from C to B and 2 edges go from A to B and C
             There can be more than one solution to the Topological sort for bigger graphs.
             There is no solution for cyclic directed graphs as they cannot determine which vertex to put first and not

             Topological sort is implemented mostly for the tasks of dependency where a vertex is dependent on a previous
             vertex and its results.
         */

        /*
                     5---->0<----1
                     |           |              Use DFS along with a stack to give out the answer.
                     |           |
                     V           V
                     2---->3---->4
         */

        int V = 6;
        ArrayList<Edge>[] graph= new ArrayList[V];

        createGraph(graph);
        topologicalSort(graph);
        System.out.println();
        System.out.println("As I said there can be multiple solutions to topological sort.");
    }
}
