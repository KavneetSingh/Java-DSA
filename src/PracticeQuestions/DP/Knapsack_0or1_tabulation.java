package PracticeQuestions.DP;
import java.util.Arrays;

public class Knapsack_0or1_tabulation {

    public static int knapsackTabulation(int val[], int wt[], int W, int[][] dp){
        for(int i=0;i<dp.length;i++){   //0th column
            dp[i][0]= 0;
        }
        for(int j=0;j<dp[0].length; j++){    //0th row
            dp[0][j]= 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1; j<W+1; j++){
                int v= val[i-1];    //ith item's value
                int w= wt[i-1];    //ith item's weight

                if(w <= j){   //valid and can be put in the sack
                    int ans1= v + dp[i-1][j-w];    //included
                    int ans2= dp[i-1][j];          // not included
                    dp[i][j]= Math.max(ans1, ans2);
                }
                else{              //weight of item greater than capacity of sack
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[wt.length][W];
    }

    public static void main(String[] args){
        int[] weight= {2,5,1,3,4};
        int[] value= {15,14,10,45,30};
        int maxWt= 7;

        int dp[][]= new int[value.length+1][maxWt+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        int ans= knapsackTabulation(value, weight, maxWt, dp);
        System.out.println(ans);    //final answer

        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + "   ");
                if(i==0){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
