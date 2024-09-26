package PracticeQuestions.DP;
import java.util.*;

public class CoinChange_Tabulation {

    public static int tabulation(int val[], int sum, int[][] dp){     //O(n*sum)  time complexity
        for(int i=0;i<dp.length;i++){       //Most important point. getting 0 using any coin also has a way and that is 1.
            dp[i][0]= 1;
        }
        for(int j=1;j<dp[0].length;j++){
            dp[0][j]= 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v= val[i-1];
                int w= val[i-1];    //Yes even in void of weights in the question we assume that the value is equal to weight.

                if(w <= j){     //valid to be included
                    dp[i][j]= dp[i][j-w] + dp[i-1][j];   //included and not included are added here to find total number of ways
                }
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        //Tell the number of ways in which you can get the sum through different dominions of coins in arrays
        int[] coins= {2,5,3,6};
        int sum= 10;               // 22222, 55, 2233, 622, 235   these are ways of getting 10 using 2,3,5,6 rupee coins

        int dp[][]= new int[coins.length+1][sum+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        int ans= tabulation(coins, sum, dp);
        System.out.println(ans);

        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
