package PracticeQuestions.LeetCode.Arrays;
import java.util.*;

public class MaximumElementAfterDecreasingandRearranging {
    public static void main(String[] args){
        int[] arr= {2,2,1,2,1};

        Arrays.sort(arr);
        int curr= 1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>curr){
                curr++;
            }
        }

        System.out.println(curr);
    }
}
