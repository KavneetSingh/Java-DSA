package PracticeQuestions.DP;
import java.util.*;

public class LCS_Memoization {

    public static int memoization(String a, String b, int n, int m, int[][] dp){       //O(n*m)
        if(n<0 || m<0){
            return 0;
        }

        if(dp[n][m]!=-1){
            return dp[n][m];
        }

        if(a.charAt(n-1)== b.charAt(m-1)){        //valid condition
            dp[n][m]= 1 + memoization(a,b, n-1, m-1,dp);
            return dp[n][m];
        }
        else{
            int ans1= memoization( a, b, n-1, m, dp);    //reduced size of a
            int ans2= memoization( a, b, n, m-1, dp);    //reduced size of b

            dp[n][m]= Math.max(ans1,ans2);
            return dp[n][m];
        }
    }

    public static void main(String[] args){
        String a= "kavneet";
        String b= "avneet";    //adfsdvsdsdnasxascseet

        int[][] dp= new int[a.length()+1][b.length()+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        for(int i=0;i<dp.length;i++){
            dp[i][0]= 0;
        }
        for(int j=0;j<b.length();j++){
            dp[0][j]= 0;
        }

        int ans= memoization(a,b,a.length(), b.length(), dp);
        System.out.println(ans);

        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
