package JavaDsa.LL;

public class LinkedList {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data= data;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size=0;

    public void addFirst(int data){
        Node newN= new Node(data);
        size++;
        if(head==null){
            head=tail=newN;
            return;
        }
        newN.next= head;
        head= newN;
    }

    public void add(int idx, int data){
        if(head==null){
            addFirst(data);
            return;
        }
        Node newN= new Node(data);
        Node temp= head;
        for(int i=0;i<idx-1;i++){
            temp= temp.next;
        }
        if(temp.next==null){
            addLast(data);
            return;
        }
        size++;
        newN.next= temp.next;
        temp.next= newN;
    }

    public void addLast(int data){
        Node newN= new Node(data);
        if(tail==null){
            head= tail= newN;
        }
        size++;
        tail.next= newN;
        tail= newN;
    }

    public int removeFirst(){
        if(size==0){
            System.out.println("Linked List already empty");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val= head.data;
            head= tail= null;
            size--;
            return val;
        }
        int val= head.data;
        head= head.next;
        size--;
        return val;

        //Java has inbuilt Garbage Collectors which delete all the nodes that you can't reach now. So, no need to worry.
    }

    public int removeLast(){
        if(head== null){
            System.out.println("Linked List is already empty chacha");
            return Integer.MIN_VALUE;
        }
        if(size==1){
            int val= head.data;
            head= tail= null;
            size=0;
            return val;
        }
        int val= tail.data;
        Node temp= head;
        while(temp.next.next!= null){
            temp=temp.next;
        }
        temp.next= null;
        tail= temp;
        size--;
        return val;
        //Java has inbuilt Garbage Collectors which delete all the nodes that you can't reach now. So, no need to worry.
    }

    public int recSearch(Node head, int i, int key){
        if(head==null){
            return -1;
        }
        if(head.data== key){
            return i;
        }

        return recSearch(head.next, i+1, key);

    }
    public int itrSearch(int key){
        int i=0;
        Node temp= head;
        while(temp!=null){
            if(key== temp.data){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    public void print(){
        if(head==null){
            System.out.println("The Linked List is empty");
        }
        Node temp= head;
        while(temp!= null){
            System.out.print(temp.data+" ");
            temp= temp.next;
        }
        System.out.println();
    }

    public void reverse(){
        Node prev= null;
        Node curr= tail = head;
        Node next;

        while(curr!=null){
            next= curr.next;
            curr.next=prev;
            prev= curr;
            curr= next;
        }
        head= prev;
    }

    public void deleteNthFromEnd(int n){
        if(n== size){
            head= head.next;
            return;
        }
        int toDelete= size- n +1;
        int i=1;
        Node temp= head;
        while(i<toDelete-1){
            temp= temp.next;
            i++;
        }

        temp.next= temp.next.next;

    }

    // slow-fast approach
    public Node findMid(Node head){
        Node slow= head;
        Node fast= head;

        while(fast!= null && fast.next!=null){
            slow= slow.next;
            fast= fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome(){
        if(head== null || head.next== null){
            return true;
        }
        Node midNode= findMid(head);

        Node prev= null;
        Node curr= midNode;
        Node next;

        while(curr!= null){
            next= curr.next;
            curr.next= prev;
            prev= curr;
            curr= next;
        }

        Node right= prev;
        Node left= head;

        while(right!= null){
            if(left.data != right.data){
                return false;
            }
            left= left.next;
            right= right.next;
        }
        return true;
    }

    public boolean isCycle(){              // Floyd's cycle finding algorithm
        Node slow= head;
        Node fast= head;
        slow= slow.next;
        fast= fast.next.next;
        while(fast!= null && fast.next!=null){
            if(fast== slow){
                return true;
            }
            slow=slow.next;
            fast= fast.next.next;
        }
        return false;
    }

    public void remCycle(){
        Node slow= head;
        Node fast= head;
        slow= slow.next;
        fast= fast.next.next;
        Node prev= null;
        while(fast!= null && fast.next!= null){
            if(slow== fast){
                slow= head;
                prev= fast;
                break;
            }
            slow= slow.next;
            fast= fast.next.next;
        }
        if(prev== null){
            return;
        }

        slow= slow.next;
        fast= fast.next;
        while(slow!= fast){
            fast= fast.next;
            slow= slow.next;
            prev= prev.next;
        }
        prev.next= null;
    }

    private Node getMid(Node head){
        Node slow= head;
        Node fast= head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    public Node mergeSort(Node head){
        if(head==null || head.next==null){
            return head;
        }
        //finding mid
        Node mid= getMid(head);
        //left and right mergeSort
        Node rightHead= mid.next;
        mid.next= null;
        Node newLeft= mergeSort(head);
        Node newRight= mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL= new Node(-1);
        Node temp= mergedLL;

        while(head1!=null && head2!=null){
            if(head1.data<= head2.data){
                temp.next= head1;
                head1=head1.next;
                temp = temp.next;
            } else{
                temp.next= head2;
                head2= head2.next;
                temp= temp.next;
            }
        }

        while (head1!=null){
            temp.next= head1;
            head1= head1.next;
            temp= temp.next;
        }
        while(head2!= null){
            temp.next= head2;
            head2= head2.next;
            temp= temp.next;
        }

        return mergedLL.next;
    }

    public static void main(String[] args){
//        LinkedList ll= new LinkedList();
//        ll.addFirst(2);
//        System.out.println(head.data);
//        ll.addFirst(1);
//        System.out.println(head.data);
//        ll.addLast(3);
//        System.out.println(tail.data);
//        ll.addLast(4);
//        ll.print();
//        ll.add(2,5);
//        ll.print();
//        System.out.println(size);
//        System.out.println(ll.removeFirst());
//        ll.print();
//        System.out.println(ll.removeLast());
//        ll.print();
//        ll.addLast(7);
//        ll.addLast(4);
//        ll.addFirst(9);
//        ll.addLast(6);
//        ll.print();
//        System.out.println(ll.itrSearch(4));
//        System.out.println(ll.recSearch(head,0, 7));
//        //ll.reverse();
//        ll.deleteNthFromEnd(3);
//        ll.print();

//        LinkedList pall= new LinkedList();  // This program does not create a new linked List
//                                            // so don't worry if your code isn't working as desired
//        pall.addLast(1);                // This element is added to 'll' itself as there is no new 'pall' created
//        pall.addLast(2);
//        pall.addLast(3);
//        pall.addLast(3);
//        pall.addLast(2);
//        pall.addLast(1);
//        pall.addLast(5);
//        tail.next= head.next.next;
//        //pall.print();
//        //System.out.println(pall.checkPalindrome());
//        System.out.println(pall.isCycle());
//        pall.remCycle();
//        pall.print();

        LinkedList mll= new LinkedList();
        mll.addFirst(1);
        mll.addFirst(2);
        mll.addFirst(3);
        mll.addFirst(4);
        mll.addFirst(5);
//        5->4->3->2->1

        mll.print();
        mll.head= mll.mergeSort(mll.head);
        mll.print();
    }
}
