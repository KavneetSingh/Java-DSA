package PracticeQuestions.LeetCode.Graph;

import java.util.ArrayList;

public class ParallelCourses3 {
    //LeetCode   Q)2050

    static class Edge{
        int src;
        int dest;

        Edge(int s, int d){
            this.src= s;
            this.dest= d;
        }
    }

//    static class Node{
//
//    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] relations){
        for(int i=1;i<graph.length;i++){
            graph[i]= new ArrayList<>();
        }

        for(int i=0;i<relations.length;i++){
            int s= relations[i][0];
            int d= relations[i][1];

            graph[s].add(new Edge(s,d));
        }
    }

//    public static int topologicalSort(){
//
//    }

    public static int max= 0;

    public static void dfs(ArrayList<Edge>[] graph, int i, int[] time, int currSum){
        int children= graph[i].size();
        System.out.println(i);
        int timeForCurr= time[i-1];
        max= Math.max(max, currSum+timeForCurr);
        System.out.println("max= " + max);
        if(children==0){
            return;
        }

        for(int j=0;j<children;j++){
            System.out.println("call frm " + i);
            int dest= graph[i].get(j).dest;
//            int timeForCurr= time[i-1];
            max= Math.max(max, currSum+timeForCurr);
            dfs(graph, dest, time, currSum+timeForCurr);
        }
    }


    public static void main(String[] args){
//        int n= 5;
//        int relations[][]= {{1,5}, {2,5}, {3,5}, {3,4}, {4,5}};
//        int time[]= {1,2,3,4,5};

//        int n= 3;
//        int relations[][]= {{1,3}, {2,3}};
//        int time[]= {3,2,5};

        int n= 2;
        int relations[][]= {{1,2}};
        int time[]= {1,1};

        ArrayList<Edge>[] graph= new ArrayList[n+1];

        createGraph(graph, relations);
//        boolean vis[]= new boolean[graph.length+1];      //graph[i] denotes ith node is visited, zero indexed

        System.out.println("g len = " + graph.length);
        for(int i=1;i<graph.length;i++){
            System.out.println("another from " + i);
            dfs(graph, i, time, 0);
        }

        System.out.println(max);
    }
}
