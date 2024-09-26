package PracticeQuestions.DP.Assignment;

public class TribonacciNumbers {

    public static int tabulation(int[] dp){
        dp[0]= dp[1]= 0;
        dp[2]= 1;

        for(int i=3;i<dp.length;i++){
            dp[i]= dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){
        int x= 7;
        //trib(x)= trib(x-1) + trib(x-2) + trib(x-3);
        int dp[]= new int[x+1];

        int ans= tabulation(dp);
        System.out.println(ans);

        System.out.println();

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
    }
}
