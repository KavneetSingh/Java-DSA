package PracticeQuestions.DP.Assignment;

public class LongestIncreasingPathInMatrix {

    /*
    We have a matrix of N rows and M columns. From m[i][j], we can move to m[i+1][j], if m[i+1][j]>m[i][j],
    or can move to m[i][j+1] if m[i][j+1]>m[i][j]. The task is to print the longest path length if we start from (0, 0).
     */

    public static int tabulation(int[][] m, int[][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0]= 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]= 0;
        }
        dp[1][1]=1;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(i==1 && j==1){
                    continue;
                }
                int left= 0;
                int top= 0;

                if( i>=2 && m[i-1][j-1] > m[i-2][j-1]){
                    top= dp[i-1][j] + 1;
                }
                if( j>=2 && m[i-1][j-1] > m[i-1][j-2]){
                    left= dp[i][j-1] + 1;
                }

                dp[i][j]= Math.max( left , top );

                if(j>=2 && dp[i-1][j]==0 && m[i-1][j-2]>=m[i-1][j-1] || i>=2 && dp[i][j-1]==0 && m[i-2][j-1]>=m[i-1][j-1]){
                    //Since we start at 0,0 then there should not be any
                    // case where you started out of some middle point and that somehow ended up being the answer.
                    dp[i][j]= 0;
                }
            }
        }

        //Now the only looseEnds left are the 1th row and 1th column in dp array. If we find a zero in any of them,
        // there won't be any way of the rest cells ahead of them to be other than 0. coz we will never reach there.
        {
            boolean zeroFound=false;
            for(int j=1;j<dp[0].length;j++){
                if(dp[1][j]==0){
                    zeroFound= true;
                }
                if(zeroFound){
                    dp[1][j]= 0;
                }
            }

            zeroFound=false;
            for(int i=1;i<dp[0].length;i++){
                if(dp[i][1]==0){
                    zeroFound= true;
                }
                if(zeroFound){
                    dp[i][1]= 0;
                }
            }
        }


        int max= 0;

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                max= Math.max(max, dp[i][j]);
            }
        }
        return max;
    }



    public static void main(String[] args){
        int[][] m= {{1,2,3,4},
                    {2,2,3,4},
                    {3,2,3,4},
                    {4,5,6,7}};

        int[][] dp= new int[m.length+1][m[0].length+1];

        int ans= tabulation(m,dp);
        System.out.println(ans);

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }


}
