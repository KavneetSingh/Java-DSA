package PracticeQuestions.LeetCode.LinkedList;



public class CopyListWithRandomPointer {


    //LeetCode Q) 138    🔥🔥🔥🔥
    //They won't accept this solution coz the original array was changed/modified
    //I just thought that this solution was much better in terms of memory although it's still
    // O(n) coz that's what they eventually want
    //They made me submit the hashmap solution

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args){
        Node head= new Node(7);       //test case not good, rethink it.

        Node curr= head;
        Node next= head.next;
        Node newHead= new Node(head.val);
        Node newCurr= newHead;

        while(next!=null){
            curr.next= newCurr;
            newCurr.random= curr;
            newCurr.next= new Node(curr.val);

            curr= next;
            newCurr= newCurr.next;
            next= next.next;
        }

        //now: 1)newRandoms point to their own original versions
        // 2) oldRandoms point to their own randoms
        // 3) oldNexts point to their own new counterparts so it's easier to locate then in new LL
        // 4) newNexts point to their own newer next nodes

        Node newNext= newHead.next;
        newCurr= newHead;
        curr= head;

        while(newNext!=null){
            if(newCurr.random.random== null) newCurr.random= null;
            else newCurr.random= newCurr.random.random.next;

            newNext= newNext.next;
            newCurr= newCurr.next;
        }

        System.out.println(newHead.val);


    }
}
