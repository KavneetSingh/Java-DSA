package JavaDsa.LL;

public class zigzagLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data= data;
        }
    }

    public static Node head;
    public static Node LH;
    public static Node RH;
    public static Node last;
    public static Node nextL;
    public static Node nextR;
    public static Node left;
    public static Node right;

    public static void addNode(int data){
        Node newN= new Node(data);
        if(LH==null){
            head=last=newN;
        }
        last.next= newN;
        last= last.next;
    }

    public static void printLL(Node temp){
        if(LH==null){
            System.out.println("Linked List empty");
        }
        while(temp!=null && temp.next!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println(temp.data);
        System.out.println();
    }

    public static Node midFinder(){
        Node slow= head;
        Node fast= head.next;
        while(fast!=null && fast.next!=null){
            slow= slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void reverse(Node mid){
        Node newHead= mid.next;
        mid.next=null;
        Node prev=null;
        Node nextN;

        while(newHead!=null){
            nextN= newHead.next;
            newHead.next=prev;
            prev= newHead;
            if(nextN!=null){
                newHead= nextN;
            }

        }
        left=LH;
        right= prev;
    }

    public static void main(String[] args){
        zigzagLL LL1= new zigzagLL();
        Node newN= new Node(1);
        last=newN;
        LH=newN;
        LL1.addNode(2);
        LL1.addNode(3);
        LL1.addNode(4);
        LL1.addNode(5);
        LL1.addNode(6);
        LL1.printLL(LH);

        Node mid=midFinder();

        while(LH!=null && RH!=null){
            nextL= left.next;
            left.next=right;
            nextR= right.next;
            right.next=nextL;

            left=nextL;
            right= nextR;
        }
    }
}
