package PracticeQuestions.DP;
import java.util.*;

public class MCM_Memoization {

    public static int memoization(int[] arr, int[][] dp, int i, int j){       //O(n^2)
        if(i>=j){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int min= Integer.MAX_VALUE;

        for(int k=i;k<j;k++){
            int cost1= memoization(arr, dp, i, k);         //cost of multiplying from i=1 to k;
            int cost2= memoization(arr, dp, k+1, j);    // cost of multiplying from i=k+1 to j

            int cost3= arr[i-1] * arr[k] * arr[j];         //cost of multiplying the left and right resultant matrices.

            int finalAns= cost1 + cost2 + cost3;           //final cost is sum of the three
            min= Math.min(finalAns, min);
        }

        dp[i][j]= min;

        return min;
    }


    public static void main(String[] args){
        int[] arr= {4,2,3,4,3};

        int[][] dp= new int[arr.length][arr.length];

        for(int i=0;i<dp.length;i++){
            Arrays.fill( dp[i], -1);
        }

//        Arrays.fill(dp[0], 0);

        int ans= memoization(arr, dp, 1, arr.length-1);

//        int ans= Integer.MAX_VALUE;                 //wrong logic.
//
//        for(int i=0;i<dp.length;i++){
//            if(dp[i][dp.length-1] !=-1){
//                ans= Math.min(dp[i][dp.length-1], ans);
//            }
//        }

        System.out.println(ans);         //correct answer

        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
