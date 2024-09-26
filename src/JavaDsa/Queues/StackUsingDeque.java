package JavaDsa.Queues;
import java.util.*;
import java.util.Deque;

public class StackUsingDeque {
    static class Stack{
        static Deque<Integer> dq= new LinkedList<>();

        public static boolean isEmpty(){
            return dq.size()==0;
        }

        public static void push(int data){
            dq.addLast(data);
        }

        public static int pop(){
            if(dq.size()==0){
                System.out.println("Stack already empty");
                return -1;
            }
            return dq.removeLast();
        }

        public static int peek(){
            if(dq.size()==0){
                System.out.println("Stack already empty");
                return -1;
            }
            return dq.getLast();
        }
    }
    public static void main(String[] args){
        Stack s= new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
    }
}
