package JavaDsa.Stacks;
import java.util.Stack;
public class Q1_PushAtBottom {
    public static void pushAtBottom(Stack<Integer> s, int data){
        if(s.size()==0){
            s.push(data);
            return;
        }
        int temp= s.pop();
        pushAtBottom(s,data);
        s.push(temp);
        return;
    }

    public static void main(String[] args){
        Stack<Integer> s= new Stack<>();

        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s , 4);

        while(s.size()!=0){
            System.out.println(s.pop());
        }
    }
}
