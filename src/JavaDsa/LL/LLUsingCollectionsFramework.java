package JavaDsa.LL;
import java.util.LinkedList;

public class LLUsingCollectionsFramework {
    public static void main(String[] args){
        LinkedList<Integer> ll= new LinkedList<>();

        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(1);

//        3->4->1
        System.out.println(ll);
        ll.removeFirst();
        ll.removeLast();
        ll.addFirst(7);
        System.out.println(ll);
    }
}
