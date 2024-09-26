package JavaDsa.Stacks;
import java.util.Stack;
public class ReverseTheStack {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.size()==0){
            s.push(data);
            return;
        }
        int temp= s.pop();
        pushAtBottom(s,data);
        s.push(temp);
    }

    public static void reverseStack(Stack<Integer> s){
        if (s.isEmpty()){
            return;
        }
        int top= s.pop();
        reverseStack(s);
        pushAtBottom(s,top);
    }

    public static void main(String[] args){
        Stack s= new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s,4);
        reverseStack(s);
        while(s.size()!=0){
            System.out.println(s.pop());
        }
    }
}