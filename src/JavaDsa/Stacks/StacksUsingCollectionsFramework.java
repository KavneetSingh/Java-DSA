package JavaDsa.Stacks;
import java.util.Stack;
public class StacksUsingCollectionsFramework {
    public static void main(String[] args){
        Stack<Integer> s= new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.pop());

        System.out.println(s.isEmpty());
        System.out.println(s.peek());
    }
}
