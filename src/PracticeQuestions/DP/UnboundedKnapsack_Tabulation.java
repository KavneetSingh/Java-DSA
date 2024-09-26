package PracticeQuestions.DP;
import java.util.*;

public class UnboundedKnapsack_Tabulation {     //O(n*W)

    public static int tabulation(int[] val, int[] wt, int[][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0]= 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]= 0;
        }

        for(int i=1;i<dp.length;i++){
            int v= val[i-1];
            int w= wt[i-1];
            for(int j=1;j<dp[0].length;j++){
                if(w <= j){
                    int ansIncluded= v * (j/w);           //Included in the solution
                    if(j-((j/w)*w)>0){
                        ansIncluded += dp[i][j-((j/w)*w)];
                    }
                    int ansExcluded= dp[i-1][j];          //Excluded from the solution
                    dp[i][j]= Math.max(ansIncluded , ansExcluded);
                }
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[val.length][dp[0].length-1];
    }

    public static void main(String[] args){
        //You can put unlimited number of a single object to make high profit.
        int[] weight= {2,5,1,3,4};
        int[] value= {15,14,10,45,30};
        int maxWt= 7;

        int[][] dp= new int[weight.length+1][maxWt+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        int ans= tabulation(value, weight, dp);
        System.out.println(ans);


        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
                if(dp[i][j]<10){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

    }
}
