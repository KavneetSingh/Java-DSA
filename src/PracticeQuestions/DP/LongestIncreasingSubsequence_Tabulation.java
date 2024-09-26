package PracticeQuestions.DP;
import java.util.Arrays;

public class LongestIncreasingSubsequence_Tabulation {

    public static int tabulation(int[] dp, int[] arr){
        dp[0]= 0;

        for(int i=1;i<dp.length;i++){       //O(n^2)
            int helper=0;
            for(int j=0;j<i;j++){

                if(arr[j] < arr[i-1]){
                    helper = Math.max(helper, dp[j+1]);
                }
            }
            dp[i]= helper + 1;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){
        int arr[]= {50,3,10,7,40,80};     //The longest increasing subsequence means the subsequence can be any set of integers
        // but increasing as the indexes increase too.
        // Here the answer would be 4  ->  {3,10,40,80} is an increasing sequence.
        //Done by myself. 🔥


        //Second solution can be to create an arr2 with all unique elements of arr and sort it.
        //Then you can simply find the LCS (Longest Common Subsequence) of both the arrays. SIMPLE Right.
        // This will also be O(n^2)

        int[] dp= new int[arr.length+1];

        Arrays.fill(dp,-1);

        int ans= tabulation(dp, arr);
        System.out.println(ans);

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
    }
}
