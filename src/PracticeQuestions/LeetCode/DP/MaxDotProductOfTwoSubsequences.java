package PracticeQuestions.LeetCode.DP;

import java.util.Arrays;

public class MaxDotProductOfTwoSubsequences {

    //LeetCode Q) 1458
    public static int maxProd(int arr1[], int arr2[], int dp[][]){
        Arrays.fill(dp[0],0);
        int maxLessThan0= Integer.MIN_VALUE;

        for(int i=1;i<dp.length;i++){
            dp[i][0]= 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int ans1= Math.max(dp[i-1][j], dp[i][j-1]);
                int ans2= (arr1[i-1] * arr2[j-1]) + dp[i-1][j-1];

                if(ans2<=0){
                    maxLessThan0= Math.max(maxLessThan0, ans2);
                }
                dp[i][j]= Math.max(ans1, ans2);
            }
        }

        if(dp[dp.length-1][dp[0].length-1]<=0){
            return maxLessThan0;
        }

        return  dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        int arr1[]= {-3,4,5,-2};
        int arr2[]= {5,1,10,3,-6};
//        int arr1[]= {-3,-2,0};
//        int arr2[]= {5,1,10};

        int dp[][]= new int[arr1.length+1][arr2.length+1];

        System.out.println(maxProd(arr1, arr2, dp));

    }
}
