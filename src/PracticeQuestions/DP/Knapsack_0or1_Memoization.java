package PracticeQuestions.DP;
import java.util.Arrays;

public class Knapsack_0or1_Memoization {
    public static int knapsack(int val[], int wt[], int W, int curr, int dp[][]){
        if(curr<=0 || W==0){
            return 0;
        }

        if(dp[curr][W]!=-1){
            return dp[curr][W];
        }

        if(wt[curr-1]<= W){
            int ans1= val[curr-1] + knapsack(val, wt, W-wt[curr-1], curr-1, dp);
            //Since we have create the dp table of value.length+1, this is why here in the above statements we use val[curr-1].
            int ans2= knapsack(val, wt, W, curr-1, dp);
            dp[curr][W]= Math.max(ans1, ans2);

        }
        else{
            dp[curr][W]= knapsack(val, wt, W, curr-1, dp);
        }
        return dp[curr][W];
    }


    public static void main(String[] args){
        int[] weight= {2,5,1,3,4};
        int[] value= {15,14,10,45,30};
        int maxWt= 7;
        int[][] dp= new int[value.length+1][maxWt+1];

        for(int i=0;i<value.length+1;i++){
            Arrays.fill(dp[i], -1);
        }

        int ans= knapsack(value, weight, maxWt, value.length, dp);
        System.out.println(dp[value.length][maxWt]);
        System.out.println(ans);
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
