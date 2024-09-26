package PracticeQuestions.LeetCode.DP;

public class CountVowelsInPermutation {

    //LeetCode Q)1220    🔥

    static int mod= 1000000007;
    public static int noOfStrings(int n, int dp[][]){

        for(int i=dp[0].length-2;i>=0;i--){
            dp[0][i]= dp[1][i+1] %mod ;
            dp[1][i]= (dp[0][i+1] + dp[2][i+1]) %mod;
            dp[2][i]= (((dp[0][i+1] + dp[1][i+1])%mod + dp[3][i+1])%mod + dp[4][i+1]) %mod;
            dp[3][i]= (dp[2][i+1] + dp[4][i+1]) %mod;
            dp[4][i]= dp[0][i+1] % mod;
        }

        int sum=0;
        for(int i=0;i<5;i++){
            sum+= dp[i][0];
            sum%=mod;
        }
        return sum;
    }

    public static void main(String[] args){
        int n=15000;

        int dp[][]= new int[5][n];
        for(int i=0;i<5;i++){
            dp[i][dp[0].length-1]= 1;
        }
        if(n==1){
            System.out.println(5);
        }

        if(n>1){
            System.out.println(noOfStrings( n, dp));
        }

    }
}
