package PracticeQuestions.DP;
import java.util.*;

public class RodLength_Tabulation {

    public static int tabulation(int val[], int wt[], int[][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0]= 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]= 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int v= val[i-1];
                int w= wt[i-1];

                if(w<=j){          //valid
                    int ans1= v + dp[i][j-w];   //included
                    int ans2= dp[i-1][j];       //not included
                    dp[i][j]= Math.max(ans1, ans2);
                }
                else{           //invalid
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        //Given a rod of length 'len', you need to cut it in a way that when you sell the parts, you should get the max profit.
        //length array denotes lengths sellable and value array is value of rods of that respective length

        int lengths[]= {1,2,3,4,5,6,7,8};
        int value[]= {1,5,8,9,10,17,17,20};
        int len= 8;

        int dp[][]= new int[lengths.length+1][len+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        int ans= tabulation(value, lengths, dp);
        System.out.println(ans);


        System.out.println();
        System.out.println();

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                System.out.print( dp[i][j] + " " );
                if(dp[i][j] < 10){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
