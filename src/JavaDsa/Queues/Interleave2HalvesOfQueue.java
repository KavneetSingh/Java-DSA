package JavaDsa.Queues;
import java.util.LinkedList;
import java.util.Queue;
public class Interleave2HalvesOfQueue {
    public static void interLeaver(Queue<Integer> q1){
        if(q1.size()%2==1){
            System.out.println("Queue doesn't have even no. of elements");
            return;
        }
        int size= q1.size();
        Queue<Integer> q2= new LinkedList<>();
        for(int i=0;i<size/2;i++){
            q2.add(q1.remove());
        }
        while(!q2.isEmpty()){
            q1.add(q2.remove());
            q1.add(q1.remove());
        }
    }

    public static void main(String[] args){
        Queue<Integer> q= new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        interLeaver(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
