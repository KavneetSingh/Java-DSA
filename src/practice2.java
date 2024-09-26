import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class practice2 {

    static class pair implements Comparable<pair>{
        int val;
        int idx;

        pair(int v, int i){
            this.val= v;
            this.idx= i;
        }
        @Override
        public int compareTo(pair p1){
            if(this.val==p1.val){
                return this.idx-p1.idx;
            }
            return p1.val-this.val;
        }

    }

    public static void main(String[] args){

        // 5 3 3 4 3    //ans= 19

        Scanner sc= new Scanner(System.in);
        long k= sc.nextInt();
        int n= sc.nextInt();
        int arr[]= new int[n];

        for(int i=0;i<arr.length;i++){
            arr[i]= sc.nextInt();
        }

        long ans=0;

        PriorityQueue<pair> pq= new PriorityQueue<>();
        int[] left= new int[arr.length];
        Arrays.fill(left, -1);

        Stack<Integer> s= new Stack();
        s.push(arr.length);
        int[] next= new int[arr.length];
        Arrays.fill(next, arr.length);
        for(int i=arr.length-1;i>=0;i--){
            while(s.peek()!=arr.length && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            next[i]= s.peek();
            s.push(i);
        }

        s.empty();
        s.push(-1);
        for(int i=0;i<arr.length;i++){
            while(s.peek()!=-1 && arr[s.peek()] < arr[i]){
                s.pop();
            }
            left[i]= s.peek();
            s.push(i);
        }

//        for(int i=0;i<next.length;i++){
//            System.out.print(left[i] + "  ");
//        }

//        System.out.println();

//        for(int i=0;i<next.length;i++){
//            System.out.print(next[i] + "  ");
//        }
//
        for(int i=0;i<arr.length;i++) {
            pq.add(new pair(arr[i], i));
        }


        while(!pq.isEmpty() && k>0){
            pair rem= pq.remove();
            int val= rem.val;
            int idx= rem.idx;
            long size= Math.min((long)(next[idx]-idx) * (long)(idx-left[idx]), k);
            ans+= (size*val)%1000000007;
            k-= size;
        }

        int res= (int) (ans%1000000007);
        //return res
        System.out.println(res);


    }
}
