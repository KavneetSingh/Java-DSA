package PracticeQuestions.LeetCode.DP;
import java.util.*;

public class PerfectSquares {
    //LeetCode Q)279

    public static void main(String[] args){
        int n= 12;
        int x= (int) Math.sqrt(n);

        int[][] dp= new int[x+1][n+1];
        Arrays.fill(dp[0], Integer.MAX_VALUE);
        for(int i=1; i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(j>=(i*i)){
                    dp[i][j]= Math.min(dp[i-1][j], dp[i][j-(i*i)]+1);
                }
                else dp[i][j]= dp[i-1][j];
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
}
