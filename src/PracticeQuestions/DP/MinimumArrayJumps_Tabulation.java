package PracticeQuestions.DP;
import java.util.*;

public class MinimumArrayJumps_Tabulation {

    //Every element of array denotes the number of jumps you can take from there.

//    public static int tabulation(int arr[], int dp[][]){
//        for(int i=0;i<dp.length;i++){
//            dp[i][0]= -1;                   //You can't reach from i to j (as j is less than i)
//            dp[0][i]= -1;
//        }
//        dp[0][0]= 0;
//
//        for(int i=1;i<dp.length;i++){
//            for(int j=i;j<dp[0].length;j++){
//                int stepsAvailable= arr[i-1];
//
//                for(int k=i; k< i + stepsAvailable; i++){
//                    dp[i][k]= Math.min(dp[i][]);
//                }
//            }
//        }
//    }

    public static int tabulation(int arr[], int dp[]){

        if(arr.length==1){
            return 0;
        }

        dp[0]= 0;
        dp[1]= 0;     //reaching from 1st element to 1st element will take 0 steps;

        for(int i=1;i<dp.length;i++){
            int j= arr[i-1];
            for(int k=i;k<=i+j;k++){
                if(k<dp.length){
                    dp[k]= Math.min( dp[k] ,  dp[i]+1 );
                }

            }
        }
        return dp[dp.length-1];
    }


    public static void main(String[] args){
        int arr[]= {2,3,1,1,4};
        int dist= arr.length;

//        int[][] dp= new int[dist+1][dist+1];
//        for(int i=0;i<dp.length;i++){
//            Arrays.fill(dp[i], -1);
//        }
        //dp[i][j] contains the minimum number of steps needed to reach from i to j;

        //Better approach: use a 1D array and store the number of steps needed in the cells.
        //dp[i] will denote the number of steps needed to reach ith index from index 1;
        //dp[1] denotes steps needed to go from 1 to 1, dp[4] denotes min number of steps needed to reach 4th index from 1.

        int dp[]= new int[arr.length+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        int ans = tabulation(arr, dp);
        System.out.println(ans);

        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
    }
}
