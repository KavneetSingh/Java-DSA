package PracticeQuestions.LeetCode.Greedy;
import java.util.*;

public class MaxiNumberofCoinsYouCanGet {

    //LeetCode Q) 1561
    public static void main(String[] args){

        int arr[]= {2,4,1,2,7,8};

        Arrays.sort(arr);
        int fst= arr.length-1;
        int trd= 0;
        int sum= 0;
        while(trd<fst-1){
            sum+= arr[fst-1];
            fst-=2;
            trd++;
        }
        System.out.println(sum);
    }
}
