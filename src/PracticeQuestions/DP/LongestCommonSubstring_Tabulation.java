package PracticeQuestions.DP;
import java.util.*;

public class LongestCommonSubstring_Tabulation {

    public static int tabulation(String a, String b, int[][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0]= 0;
        }

        for(int j=0; j<dp[0].length;j++){
            dp[0][j]= 0;
        }

        int max= 0;

        for(int i=1; i<dp.length;i++){
            for(int j=1; j<dp[0].length; j++){
                char A= a.charAt(i-1);
                char B= b.charAt(j-1);

                if(A==B){
                    dp[i][j]= dp[i-1][j-1] + 1;         //whenever the last char of both strings are same,
                    // we increase the value of previous answer by 1 and store in the dp table.

                    max= Math.max(max, dp[i][j]);        // we will have to traverse the table again for solution.
                    // Instead of n^2 traversal, we will calculate max already everytime there's a change.
                }
                else{
                    dp[i][j]= 0;          //Since this question is different from the longest common sub-sequence,
                    //we need to store 0 only whenever the last chars are different.
                }
            }
        }
        return max;
    }

    public static void main(String[] args){
        String a= "aabcdgrhe";
        String b= "edfabcdde";        //the longest common substring here is 'abcd' with length 4;

        int[][] dp= new int[a.length()+1][b.length()+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        int ans= tabulation( a, b, dp);
        System.out.println(ans);

        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print( dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
