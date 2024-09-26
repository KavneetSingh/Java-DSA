package PracticeQuestions.DP;
import java.util.Arrays;

public class CatalanNumber_Tabulation {         //Remember this

    public static int tabulation(int[] dp){      //O(n^2)
        dp[0] = dp[1]= 1;

        for(int i=2;i<dp.length;i++){
            int ans= 0;
            for(int j=0;j<i;j++){
                ans+= dp[j] * dp[i-j-1];
            }
            dp[i]= ans;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){
        int x= 10;
        int[] dp= new int[x+1];

        Arrays.fill(dp,-1);

        int ans= tabulation(dp);
        System.out.println(ans);

        System.out.println();
        System.out.println();

        for(int s: dp){
            System.out.print( s + " " );
        }
    }
}
