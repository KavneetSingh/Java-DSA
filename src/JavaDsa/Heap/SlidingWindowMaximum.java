package JavaDsa.Heap;

import java.util.PriorityQueue;

public class SlidingWindowMaximum {    //Give put the max of window of k initial elements and move the window to right
                                       // and again give max for the next those k elements.
    static class element implements Comparable<element>{
        int i;
        int val;

        element(int i, int val){
            this.i=i;
            this.val= val;
        }

        @Override
        public int compareTo(element e2){
            return e2.val- this.val;         //highest val gets the highest priority
        }
    }
    public static void main(String[] args){          //O( Nlogk ) // can also be done in O(N) using DEqueues
        int arr[]= {9,3,-1,-3,5,3,6,8,5,3,4};
        PriorityQueue<element> pq= new PriorityQueue<>();
        int k=3;

        int arr2[]= new int[arr.length-k+1];

        for(int i=0;i<k;i++){
            pq.add(new element(i, arr[i]));
        }
        arr2[0]= pq.peek().val;

        for(int i=k;i<arr.length;i++){
            while(pq.peek().i <= i-k){
                pq.remove();
            }
            pq.add(new element(i,arr[i]));
            arr2[i-k+1]= pq.peek().val;

        }

        for(int i=0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
    }
}
