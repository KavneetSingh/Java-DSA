package PracticeQuestions.DP;

import java.util.Arrays;

public class StringConversion_Tabulation {

    public static int tabulation(String str1, String str2, int[][] dp){
        for(int i=0;i<dp.length;i++){
            dp[i][0] = i;
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j] = j;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                char a= str1.charAt(i-1);
                char b= str2.charAt(j-1);

                if(a==b){
                    dp[i][j]= dp[i-1][j-1];     //The current chars are equal so no need to perform an operation;
                }
                else{
                    int ans1= dp[i-1][j] + 1;
                    int ans2= dp[i][j-1] + 1;
                    int ans3= dp[i-1][j-1] + 2;        //delete on string one and then add

                    dp[i][j]= Math.min(Math.min(ans1, ans2), ans3);
                    //I don't think ans3 makes any difference. Run on different String samples
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        //This question is similar to EditDistance but the only difference is that you can only add or delete chars
        // and not replace it. This makes the question not much difficult and I think we only need to
        // remove the replacement option in else section

        String str1= "pear";
        String str2= "sea";

        int[][] dp= new int[str1.length()+1][str2.length()+1];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans= tabulation(str1, str2, dp);
        System.out.println(ans);

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}

//Another approach, You can find the LCS of both the strings and then add or subtract the number
// of different chars in both strings.
