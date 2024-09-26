package JavaDsa.LL;

public class DoublyLL {

    public static class Node{
        int data;
        Node next;
        Node prev;

        public Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //addfirst
    public static void addFirst(int data){
        Node newN= new Node(data);
        size++;
        if(head==null){
            head=tail=newN;
            return;
        }
        newN.next=head;
        head.prev=newN;
        head=head.prev;
    }

    //remove first
    public static int remFirst(){
        if(head==null){
            System.out.println("LL already empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size--;
            return val;
        }

        Node temp=head;
        head= head.next;
        head.prev=null;
        temp.next=null;
        size--;
        return temp.data;
    }

    public void print(){
        Node temp=head;
        System.out.print("null <-> ");
        while(temp!=null){
            System.out.print(temp.data+" <-> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void reverse(){
        Node curr= head;
        Node prev=null;
        Node next=null;

        while(curr!=null){
            next= curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;

        }

        Node newH=tail;
        tail=head;
        head=newH;
    }

    public static void main(String[] args){
        DoublyLL dll= new DoublyLL();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.print();
        System.out.println(dll.size);

        dll.remFirst();
        dll.print();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.reverse();
        dll.print();
    }
}
