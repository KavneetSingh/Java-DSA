package PracticeQuestions.DP;
import java.util.Arrays;

public class LCS_Tabulation {

    public static int tabulation(String a, String b, int dp[][]){        //O(n*m)
        for(int i=0;i<dp.length;i++){
            dp[i][0]= 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]= 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(a.charAt(i-1) == b.charAt(j-1)){        //valid
                    dp[i][j]= 1 + dp[i-1][j-1];
                }
                else{
                    int ans1= dp[i-1][j];                // reducing size of a
                    int ans2= dp[i][j-1];                //reducing the size of b
                    dp[i][j]= Math.max(ans1, ans2);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        String a= "abcde";
        String b= "aca";        //works completely fine in this case too.

        int[][] dp= new int[a.length()+1][b.length()+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        int ans= tabulation(a,b,dp);
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
