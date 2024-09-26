package JavaDsa.Queues;

public class QueueUsingLL {

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data= data;
            this.next= null;
        }
    }

    static class Queue{
        static Node head=null;
        static Node tail=null;

        public static boolean isEmpty(){
            return head==null && tail==null;
        }

        public static void add(int data){
            Node newN= new Node(data);
            if(head==null){
                head=tail=newN;
                return;
            }
            tail.next= newN;
            tail=tail.next;
        }

        public static int remove(){
            if(isEmpty()){
                System.out.println("Queue already empty");
                return -1;
            }

            int data= head.data;
            if(tail==head){
                tail=head=null;
                return data;
            }
            head= head.next;
            return data;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
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

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }
    }
}
