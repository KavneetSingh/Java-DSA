package PracticeQuestions.DP.Assignment;

public class HouseThief {
    /*
        You are a professional robber planning to rob houses along a street.
        Each house has a certain amount of money stashed, the only constraint stopping you from
        robbing each of them is that adjacent houses have security systems connected, and
        it will automatically contact the police if two adjacent houses were broken into on the same night.

        Given an integer array nums representing the amount of money of each house,
        return the maximum amount of money you can rob tonight without alerting the police.
         */

    public static int tabulation(int[] arr, int[] dp){
        dp[0]= 0;
        dp[1]= 0;
        dp[2]= arr[0];      //The first 2 values are exclusively added in the dp so that all cases can qualify

        for(int i=3;i<dp.length;i++){
            int currVal= arr[i-2];

            int ans1= dp[i-1];                 //currValue not included
            int ans2= dp[i-2]+currVal;         //curr value included in the value of curr-2
            int ans3= dp[i-3]+currVal;         //currValue included int the value of curr-3
                                                  // -> (for in case: if we ignore 2 adjacent values)

            dp[i]= Math.max(ans1, Math.max(ans2, ans3));
        }

        return Math.max(dp[dp.length-1], dp[dp.length-2]);
    }

    public static void main(String[] args){


        int arr[]= {11,3,4,12,2,4,2};

        int[] dp= new int[arr.length+2];

        int ans= tabulation(arr, dp);

        System.out.println(ans);
        System.out.println();

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }

    }
}
