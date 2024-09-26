package PracticeQuestions.LeetCode.LinkedList;

public class Add2Numbers {

    //LeetCode Q)2.

    static class ListNode{
        int val;
        ListNode next= null;

        public ListNode(int val){
            this.val= val;
        }

        public ListNode(int val, ListNode next){
            this.val= val;
            this.next= next;
        }
    }

    public static void main(String[] args){
        int num1[]= {2,4,3,9,5,9};
        int num2[]= {5,6,7,3,5};

        ListNode l1= new ListNode(num1[0]);
        ListNode l2= new ListNode(num2[0]);

        ListNode curr1= l1;

        for(int i=1;i<num1.length;i++){
            curr1.next= new ListNode(num1[i]);
            curr1=curr1.next;
        }
        curr1= l1;
        while(curr1!=null){
            System.out.print(curr1.val + ", ");
            curr1=curr1.next;
        }
        System.out.println();
        ListNode curr2= l2;
        for(int i=1;i<num2.length;i++){
            curr2.next= new ListNode(num2[i]);
            curr2= curr2.next;
        }
        curr2= l2;
        while(curr2!=null){
            System.out.print(curr2.val + ", ");
            curr2=curr2.next;
        }
        System.out.println();



        //code starts here

        int sum= (l1.val+l2.val)%10;
        int carry= (l1.val+l2.val)/10;
//        ListNode l3= new ListNode(sum);
        l2.val= sum;

        curr1= l1.next;
        curr2= l2.next;
        ListNode curr3= l2;
        while(curr1!=null && curr2!=null){
            sum= (curr1.val+curr2.val +carry)%10;
            carry= (curr1.val+curr2.val +carry)/10;
            curr3.next.val= sum;
//            curr2.val= sum;
            curr1= curr1.next;
            curr2= curr2.next;
            curr3= curr3.next;
        }


//        System.out.println(curr2.val);

        while(curr1!=null){
            sum= (curr1.val+carry)%10;
            carry= (curr1.val+carry)/10;
            curr3.next= new ListNode(sum);
//            System.out.println(curr2.val);
            curr1= curr1.next;
            curr3= curr3.next;
        }

        while(curr2!=null){
            sum= (curr2.val+carry)%10;
            carry= (curr2.val+carry)/10;
            curr3.next.val =sum;
            curr2= curr2.next;
            curr3= curr3.next;
        }

        if(carry==1){
            curr3.next= new ListNode(1);
        }

//        return l3;

        curr3= l2;
        while(curr3!=null){
            System.out.print(curr3.val + ", ");
            curr3=curr3.next;
        }

    }
}
