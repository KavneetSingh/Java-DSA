package JavaDsa.Queues;
import java.util.*;

public class QueueReversal {

    public static void queueReversal(Queue<Integer> q){
        Stack<Integer> s= new Stack<>();
        while(!q.isEmpty()){
            s.push(q.remove());
        }
        while(!s.isEmpty()){
            q.add(s.pop());
        }
    }

    public static void main(String[] args){
        Queue<Integer> q= new LinkedList<>();

        Scanner sc= new Scanner(System.in);
        int size= sc.nextInt();
        for(int i=0;i<size;i++){
            int j= sc.nextInt();
            q.add(j);
        }

        queueReversal(q);

        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
        System.out.println();
    }
}
