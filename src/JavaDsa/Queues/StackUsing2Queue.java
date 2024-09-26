package JavaDsa.Queues;
import java.util.LinkedList;
import java.util.Queue;
public class StackUsing2Queue {

    static class Stack{
        static Queue<Integer> q1= new LinkedList<>();
        static Queue<Integer> q2= new LinkedList<>();

        public static boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data){
            if(!q1.isEmpty()) {
                q1.add(data);
            }
            else{
                q2.add(data);
            }
        }

        public static int pop(){
            if(q1.isEmpty() && q2.isEmpty()){
                System.out.println("Stack already Empty");
                return -1;
            }
            else if(q1.isEmpty() && !q2.isEmpty()){
                while(!q2.isEmpty()){
                    if(q2.size()==1){
                        break;
                    }
                    q1.add(q2.remove());
                }
                return q2.remove();
            }
            else{
                while(!q1.isEmpty()){
                    if(q1.size()==1){
                        break;
                    }
                    q2.add(q1.remove());
                }
                return q1.remove();
            }
        }

        public static int peek(){
            int data=-1;
            if(q1.isEmpty() && q2.isEmpty()){
                System.out.println("Stack already Empty");
            }
            else if(q1.isEmpty() && !q2.isEmpty()){
                while(!q2.isEmpty()){
                    if(q2.size()== 1){
                        data= q2.peek();
                    }
                    q1.add(q2.remove());
                }
            }
            else{
                while(!q1.isEmpty()){
                    if(q1.size()==1){
                        data= q1.peek();
                    }
                    q2.add(q1.remove());
                }
            }
            return data;
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
        System.out.println();
    }
}
