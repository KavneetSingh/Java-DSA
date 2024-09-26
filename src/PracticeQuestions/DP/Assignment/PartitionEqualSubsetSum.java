package PracticeQuestions.DP.Assignment;

public class PartitionEqualSubsetSum {
    /*
    Given an integer array nums, return true if you can partition the array into two
    subsets such that the sum of the elements in both subsets is equal or false otherwise.
     */

    public static boolean tabulation(int arr[], int[][] dp){
        int sum= dp[0].length -1;

        for(int i=0; i<dp.length;i++){
            dp[i][0]= 0;
        }
        for(int j=0;j<dp[0].length;j++){
            dp[0][j]= 0;
        }

        for(int i=1; i<dp.length; i++){
            for(int j=1;j<dp[0].length;j++){
                int val= arr[i-1];
                int wt= j;

                if(val <= wt){            //valid
                    int ans1= val + dp[i-1][j-val];         //included
                    int ans2= dp[i-1][j];               //not included

                    dp[i][j]= Math.max(ans1, ans2);
                }
                else{                     //invalid
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1] == sum;
    }

    public static void main(String[] args){
        int arr[]= {1,5,11,5};

        int sum=0;

        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }

        if((sum&1)==1){
            //return false;
            System.out.println("Not possible");
        }

        int[][] dp= new int[arr.length+1][sum/2 +1];

        boolean ans= tabulation(arr,dp);
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
