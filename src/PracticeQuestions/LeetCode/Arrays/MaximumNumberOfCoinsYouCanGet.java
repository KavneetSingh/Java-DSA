package PracticeQuestions.LeetCode.Arrays;
import java.util.*;


public class MaximumNumberOfCoinsYouCanGet {
//LeetCode Q) 1561
    public static int SecondHighestSum(int arr[]){
        Arrays.sort(arr);
        int fst= arr.length-1;
        int sec= arr.length-2;
        int trd= 0;
        int sum= 0;
        while(trd<sec){
            sum+= arr[sec];
            fst-=2;
            sec-=2;
            trd++;
        }
        return sum;
    }

    /*
        public int maxCoins(int[] arr) {
            Arrays.sort(arr);
            int fst= arr.length-1;
            int trd= 0;
            int sum= 0;
            while(trd<fst-1){
                sum+= arr[fst-1];
                fst-=2;
                trd++;
            }
            return sum;
        }
     */

    public static void main(String[] args){
        int arr[]= {9,8,7,6,5,1,2,3,4};
        System.out.println(SecondHighestSum(arr));
    }
}
