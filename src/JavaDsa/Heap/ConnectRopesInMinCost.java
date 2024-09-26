package JavaDsa.Heap;

import java.util.PriorityQueue;

public class ConnectRopesInMinCost {  //connect the ropes to 1, while cost of adding 2 ropes is equal to sum of lengths of both

    public static int connect(PriorityQueue<Integer> pq){
        int i= pq.remove();
        int j= pq.remove();
        pq.add(i+j);
        return i+j;
    }

    public static void main(String[] args){
       int ropes[]= {2,3,3,4,6};

        PriorityQueue<Integer> pq= new PriorityQueue<>();   //int PQ by default gives lower value a higher priority
        for(int i=0;i<ropes.length;i++){
            pq.add(ropes[i]);
        }

        int cost=0;

        while(pq.size()>1){
            cost+= connect(pq);
        }

        System.out.println(pq.peek());
        System.out.println(cost);
    }
}
