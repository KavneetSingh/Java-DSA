package PracticeQuestions.LeetCode.Queue;
import java.util.*;

public class SlidingWindowMaximum {

    //LeetCode Q) 239

    public static int[] maxSlidingMindow(int[] arr, int k){
        Deque<Integer> dq= new LinkedList<>();
        int res[]= new int[arr.length-k+1];
//        int curr=0;
        for(int i=0;i<k;i++){
            while(!dq.isEmpty() && arr[dq.getLast()]<arr[i]){     //remvoe elements which are less than curr element
                dq.removeLast();
            }
            dq.addLast(i);
//            System.out.println();
        }

//        System.out.println(arr[dq.getFirst()]);
        res[0]= arr[dq.getFirst()];

        for(int i=k; i<arr.length;i++){
            while(!dq.isEmpty() && arr[dq.getLast()]<arr[i]){     //remvoe elements which are less than curr element
                dq.removeLast();
            }
            dq.addLast(i);

            while(dq.getFirst()<i-k+1){       //remove elements which are not a part of the window
                dq.removeFirst();
            }

            res[i-k+1]= arr[dq.getFirst()];
        }

        return res;
    }
    public static void main(String[] args){
//        int arr[]= {1,3,-1,-3,5,3,3,3,6,7};
        int arr[]= {4,3,11};
        int k= 3;

        int res[]= maxSlidingMindow(arr,k);

        for(int i=0;i<res.length;i++){
            System.out.print(res[i] + " ");
        }

    }
}
