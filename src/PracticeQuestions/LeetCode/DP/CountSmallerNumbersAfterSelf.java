package PracticeQuestions.LeetCode.DP;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumbersAfterSelf {

    //LeetCode Q)315   🔥  Look for the solution on leetcode too. It is a much better one.

    public static void main(String[] args){

        int[] arr= {8,5,2,6,1,4,5,2};

        List<Integer> ans= new ArrayList<>();
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            min= Math.min(arr[i], min);
            max= Math.max(arr[i],max);
        }

        int store[][]= new int[max-min+1][arr.length];

        for(int i=arr.length-1;i>=0;i--){
            int x= arr[i];
            store[x-min][i]= 1;          //stores 1 at every occurance of every element
        }

        int dp[][]= new int[max-min+1][arr.length];
        //stores the number of lesser elements on the right

        boolean done= false;
        for(int j=dp[0].length-2;j>=0;j--){
            done= false;
            for(int i=1;i<dp.length;i++){
                if(store[i-1][j+1]==1){
                    done=true;
                }
                if(done) dp[i][j]= dp[i][j+1]+1;
                else dp[i][j]= dp[i][j+1];
            }
        }

        for(int i=0;i<arr.length;i++){
            ans.add(dp[arr[i]-min][i]);
        }

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(store[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }



        System.out.println(ans);
    }
}
