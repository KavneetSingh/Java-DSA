package PracticeQuestions.LeetCode.DP;

public class OutofBoundaryPaths {
    //LeetCode Q)576     🔥🔥🔥🔥
    public static int findPaths(int m, int n, int maxMove, int sR, int sC) {
        if(maxMove==0) return 0;
        int dp[][][]= new int[m][n][maxMove];

        for(int i=0;i<dp.length;i++){
            dp[i][0][0]= 1;
            dp[i][dp[0].length-1][0]= 1;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j][0]= 1;
            dp[dp.length-1][j][0]= 1;
        }
        dp[0][0][0]= 2;
        dp[0][dp[0].length-1][0]= 2;
        dp[dp.length-1][0][0]= 2;
        dp[dp.length-1][dp[0].length-1][0]= 2;

        if(m==1 && n==1){
            dp[0][0][0]= 4;
        }
        else if(n==1 || m==1){
            if(m==1){
                for(int j=1;j<dp[0].length-1;j++){
                    dp[0][j][0]=2;
                }
                dp[0][0][0]= dp[0][dp[0].length-1][0]= 3;
            }
            else if(n==1){
                for(int i=1;i<dp.length-1;i++){
                    dp[i][0][0]= 2;
                }
                dp[0][0][0]= dp[dp.length-1][0][0]= 3;
            }
        }


        for(int k=1;k<maxMove;k++){
            for(int i=0;i<dp.length;i++){
                for(int j=0;j<dp[0].length;j++){
                    int temp=0;
                    if(i>0) temp+= dp[i-1][j][k-1];
                    temp%=1000000007;
                    if(i<dp.length-1) temp+= dp[i+1][j][k-1];
                    temp%=1000000007;
                    if(j>0) temp+= dp[i][j-1][k-1];
                    temp%=1000000007;
                    if(j<dp[0].length-1) temp+= dp[i][j+1][k-1];
                    temp%=1000000007;
                    dp[i][j][k]= temp;
                }
            }
        }

         for(int i=0;i<dp.length;i++){
             for(int j=0;j<dp[0].length;j++){
                 System.out.print(dp[i][j][0] + " ");
             }
             System.out.println();
         }

        int ans=0;

        for(int k=0;k<maxMove;k++){
            ans+= dp[sR][sC][k];
            ans%= 1000000007;
        }

        return ans;
    }

    public static void main(String[] args){
        System.out.println(findPaths(10,10,6,5,5));
    }
}
