package PracticeQuestions.LeetCode.DP;
import java.util.*;
public class MinCostClimbingStairs {

    //LeetCode Q)746

    public static int minCost(int[] dp, int[] arr){

        dp[1]= 0;
        dp[2]= 0;

        if(arr.length>2){
            for(int i=3;i<dp.length;i++){
                int ans1= dp[i-1] + arr[i-2];
                int ans2= dp[i-2] + arr[i-3];
                System.out.println(ans1 + ", " + ans2);
                dp[i]= Math.min(ans1, ans2);
            }
        }
        else if(arr.length==2){
            return Math.min(arr[0], arr[1]);
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args){
//        int arr[]= {1,100,1,1,1,100,1,1,100,1};
//        int arr[]= {10,15,20};
        int arr[]= {1,100};
        int dp[]= new int[arr.length+2];
        Arrays.fill(dp, 0);
        System.out.println(minCost(dp, arr));

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
    }
}
