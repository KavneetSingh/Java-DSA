package PracticeQuestions.DP.Assignment;
import java.util.*;


public class LongestPalindromicSubsequence {
    //The question is to find the max length of palindromic subsequence in a given string.


    //Solution: The idea is to create a 2D DP array and store the max size of palindromic subsequence from ith to
    // jth char in dp[i][j]
    //The final answer will be stored in the cell dp[1][dp[0].length-1];

    public static int tabulation(String str, int[][] dp){

        if(str.length()==0){
            return 0;
        }

        for(int i=1;i<dp.length;i++){
            dp[i][i]= 1;
        }

//        int max=-1;

        for(int k=1;k<dp.length-1;k++){
            for(int m=1;m<dp.length-k;m++){
                int i= m;
                int j= i+k;

                char a= str.charAt(i-1);
                char b= str.charAt(j-1);

                if(a==b){               //valid
                    int ans1= 0;
                    int ans2= 0;
                    if(i+1<dp.length){
                        ans1= 2+ dp[i+1][j-1];
                        ans2= dp[i+1][j];
                    }

                    int ans3= dp[i][j-1];

                    dp[i][j]= Math.max(ans1, Math.max(ans2, Math.max(ans3, dp[i][j])));
//                    max= Math.max(max, dp[i][j]);
                }
                else{
                    int ans1= 0;
                    if(i+1<dp.length){
                        ans1= dp[i+1][j];
                    }

                    int ans2= dp[i][j-1];
                    dp[i][j]= Math.max(ans1, Math.max(ans2, dp[i][j]));
//                    max= Math.max(max, dp[i][j]);
                }
            }
        }

//        for(int i=1;i<dp.length-1;i++){
//            for(int j=i+1;j<dp[i].length;j++){
//
//            }
//        }



        return dp[1][dp[0].length-1];
    }

    public static void main(String[] args){
        String str= "abcabcabcabc";

        int[][] dp= new int[str.length()+1][str.length()+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],0);
        }

        int ans= tabulation(str, dp);
        System.out.println(ans);

//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println();


        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
