package PracticeQuestions.LeetCode.DP;

public class MinimumFallingPathSum {
    //LeetCode Q)931
    public static void main(String[] args){

        int matrix[][]= {{2,1,3},{6,5,4},{7,8,9}};

        int dp[][]= new int[matrix.length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            dp[dp.length-1][i]= matrix[dp.length-1][i];
        }
        for(int i=matrix.length-2;i>=0;i--){
            for(int j=0;j<matrix.length;j++){
                if(j==0 || j==matrix.length-1){
                    if(j==0) dp[i][j]= matrix[i][j]+ Math.min(dp[i+1][j], dp[i+1][j+1]);
                    else dp[i][j]= matrix[i][j] + Math.min(dp[i+1][j-1], dp[i+1][j]);
                }
                else{
                    dp[i][j]= matrix[i][j]+ Math.min(dp[i+1][j-1], Math.min(dp[i+1][j], dp[i+1][j+1]));
                }

            }
        }
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<dp.length;i++){
            ans= Math.min(dp[0][i], ans);
        }

        System.out.println(ans);
    }
}
