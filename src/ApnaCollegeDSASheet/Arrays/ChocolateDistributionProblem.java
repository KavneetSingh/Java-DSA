package ApnaCollegeDSASheet.Arrays;
import java.util.*;

public class ChocolateDistributionProblem {
    /*
    Given an array of N integers where each value represents the number of chocolates in a packet.
    Each packet can have a variable number of chocolates. There are m students, the task is to
     distribute chocolate packets such that:

        1. Each student gets one packet.
        2. The difference between the number of chocolates in the packet with maximum chocolates and
         the packet with minimum chocolates given to the students is minimum.
     */

    public static void main(String[] args){
//        int[] arr= {7, 3, 2, 4, 9, 12, 56};      //ans= 2;
//        int m= 3;

//        int[] arr= {3, 4, 1, 9, 42, 7, 9, 12};     //ans= 6;
//        int m=5;

        int[] arr= {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m=7;

        Arrays.sort(arr);

        int ans= Integer.MAX_VALUE;
        for(int i=0;i<arr.length-m+1; i++){
            if(arr[i+m-1]- arr[i] < ans){
                ans= arr[i+m-1]- arr[i];
//                System.out.println(ans + " " + (i+m-1));
            }
        }

        System.out.println(ans);
    }
}
