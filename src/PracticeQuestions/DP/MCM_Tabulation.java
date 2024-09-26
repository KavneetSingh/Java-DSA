package PracticeQuestions.DP;
import java.util.*;

public class MCM_Tabulation {

    public static int tabulation(int[] arr, int[][] dp){

        for(int i=0;i<arr.length;i++){
            dp[i][i]= 0;                        //for all the i==j, we stored the value as 0 coz
                                         // there will be only one matrix for those values of i and j
        }

        for(int len=2; len<dp.length; len++){
            for(int i=1; i<=dp.length-len ; i++){
                int j= i+len-1;                  //col
                dp[i][j]= Integer.MAX_VALUE;
                for(int k=i; k<j; k++){
                    int cost1= dp[i][k];
                    int cost2= dp[k+1][j];
                    int cost3= arr[i-1] * arr[k] * arr[j];
                    int finalAns= cost1 + cost2 + cost3;
                    dp[i][j]= Math.min(dp[i][j], finalAns);
                }
            }
        }

//        int min= Integer.MAX_VALUE;
//        for(int i=0; i<dp.length;i++){
//            if(dp[i][dp.length-1]!= -1 || dp[i][dp.length-1]!= 0){
//                min= Math.min(min, dp[i][dp.length-1]);
//            }
//        }
        return dp[1][dp.length-1];
    }

    //The dp works like this: Imagine the rows are indexed in i and columns are indexed in j.
    //Now the meaning of dp[i][j] is that it stores the value of answer for matrices starting at i and ending at j;
    //for example dp[1][2] in {1,3,5,2} stores cost for (1x3) and (3x5) which would be 1*3*5 = 15,
    // and dp[1][3] stores cost for (1x3), (3x5) and (5x2), which would be- (1*3*5) + (1*5*2)= 25;
    //The answer for all the matrices with similar logic should be stored at dp[1][dp.length-1].
    // we similarly run k from i to j-1 in order to get the solutions to all the sub-arrays or group of matrices.

    //Hence we find the minimum value for the given operation.

    //We never use the i>j values of dp coz it is simply 0 for them as i>j does not contain any valid matrices.

    public static void main(String[] args){
        int arr[]= {1,2,3,4,3};

        int dp[][]= new int[arr.length][arr.length];

//        for(int i=0;i<dp.length;i++){
//            Arrays.fill(dp[i], -1);
//        }

        int ans= tabulation(arr, dp);
        System.out.println(ans);

        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
                if(dp[i][j]==0){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
