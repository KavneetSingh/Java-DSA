package JavaDsa.Stacks;
import java.util.ArrayList;

public class StackB {
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        //Empty or not
        public static boolean isEmpty(){
            return list.size()==0;
        }

        //push
        public static void push(int a){
            list.add(a);
        }

        //pop
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top= list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        public static int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String[] args){
        Stack s= new Stack();
        Stack s1=new Stack();

        System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.pop();
        System.out.println(s1.isEmpty());
        s1.push(10);
        System.out.println(s.peek());
    }
}
