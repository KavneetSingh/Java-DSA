package JavaDsa.Queues;
import java.util.*;
import java.util.LinkedList;

public class QueueUsingDeque {
    static class Queue{
        static Deque<Integer> dq= new LinkedList<>();

        public static boolean isEmpty(){
            return dq.size()==0;
        }

        public static void add(int data){
            dq.addLast(data);
        }

        public static int remove(){
            if(dq.size()==0){
                System.out.println("Queue already empty");
                return -1;
            }
            return dq.removeFirst();
        }

        public static int peek(){
            if(dq.size()==0){
                System.out.println("Queue already empty");
                return -1;
            }
            return dq.getFirst();
        }
    }
    public static void main(String[] args){
        Queue q= new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        System.out.println(q.remove());
        q.add(6);

        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
