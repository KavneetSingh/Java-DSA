package PracticeQuestions.DP.Assignment;
import java.util.*;

public class ParenthesisCombinations {
    /*
    Given N number of pairs of parenthesis (pair of opening and closing parenthesis), you have to count all the valid
     combinations of the parenthesis.
     */

    //Based on Catalan's number.

    public static int tabulation(int dp[]){


        dp[0]= 1;
        dp[1]= 1;
        for(int i=2;i<dp.length;i++){
            int ans=0;
            for(int k=0;k<i;k++){
                ans+= dp[k]*dp[i-k-1];
            }
            dp[i]= ans;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){

        int x= 6;
        int dp[]= new int[x+1];

        Arrays.fill(dp,-1);

        int ans= tabulation(dp);
        System.out.println(ans);

        System.out.println();

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println();
    }
}
