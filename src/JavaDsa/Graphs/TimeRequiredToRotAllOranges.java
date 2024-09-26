package JavaDsa.Graphs;

public class TimeRequiredToRotAllOranges {
    /*
        You are given a 2d matrix for the condition of oranges kept in each Cell.
        A rotten orange adjacent to another fresh orange can rot it.
        conditions:
        0: No orange (Empty cell)
        1: Fresh Orange
        2: Rotten Orange
     */

    static class Node{
        int data;
        int i;
        int j;
        Node left;
        Node right;
        Node up;
        Node down;

        public Node(int data, int i, int j, int maxI, int maxJ){

            this.data= data;
            this.i=i;
            this.j=j;
            this.right= null;
            this.left= null;
            this.up= null;
            this.down= null;

//            this.data= data;
//            this.i= i;
//            this.j= j;
//
//            this.right= j+1;
//            this.
//
//            if(i==0){
//                this.up= null;
//            }
//            if(i==maxI){
//                this.down= null;
//            }
//            if(j==0){
//                this.left= null;
//            }

        }
    }


    public static void createGraph(int[][] arr){

    }

    public static void main(String[] args){
        int arr[][]= { {2, 1, 0, 2, 1},
                       {0, 0, 1, 2, 1},
                       {1, 0, 0, 2, 1}};

        createGraph(arr);
    }
}
