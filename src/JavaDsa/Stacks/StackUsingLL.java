package JavaDsa.Stacks;

public class StackUsingLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
            this.next=null;
        }
    }
    static class Stack{
        static Node head= null;

        public static boolean isEmpty(){
            return head==null;
        }

        public static void push(int data){
            Node newN= new Node(data);
            if(head==null){
                head= newN;
                return;
            }
            newN.next=head;
            head=newN;
            return;
        }

        public static int pop(){
            if(head==null){
                return -1;
            }
            int data= head.data;
            head=head.next;
            return data;
        }

        public static int peek(){
            if(head==null){
                return -1;
            }
            return head.data;
        }

    }
    public static void main(String[] args){
        Stack s=new Stack();
        System.out.println(s.isEmpty());
        s.push(2);
        s.push(3);
        s.push(4);
        Stack s1= new Stack();
        s1.pop();
        System.out.println(s1.peek()); //why am I getting the same result for both s and s1 if I perform any operation??
    }
}
