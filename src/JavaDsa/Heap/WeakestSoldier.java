package JavaDsa.Heap;

import org.w3c.dom.ls.LSOutput;

import java.util.PriorityQueue;

public class WeakestSoldier {

    static class Array implements Comparable<Array>{
        int arr[];
        int row;
        int soldiers=0;

        Array(int arr[], int row){
            this.row= row;
            this.arr= arr;

            for(int i=0;i<arr.length;i++){
                if(arr[i]==1){
                    soldiers++;
                }
            }
        }

        @Override
        public int compareTo(Array a2){
            if(this.soldiers== a2.soldiers){
                return this.row- a2.row;
            }
            return this.soldiers- a2.soldiers;       //ascending order
        }
    }

    public static int weakestSoldier(PriorityQueue<Array> PQ){
        Array Arr= PQ.remove();
        return Arr.row;
    }

    public static void main(String[] args){
        PriorityQueue<Array> PQ= new PriorityQueue<>();
        PQ.add(new Array(new int[] {1,0,0,0},0));
        PQ.add(new Array(new int[] {1,1,1,1},1));
        PQ.add(new Array(new int[] {1,0,0,0},2));
        PQ.add(new Array(new int[] {1,0,0,0},3));

        int k=2;
        while(k-->0){
            System.out.println("row"+ weakestSoldier(PQ));
        }
    }
}
