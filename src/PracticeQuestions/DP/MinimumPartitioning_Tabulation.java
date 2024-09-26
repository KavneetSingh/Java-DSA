package PracticeQuestions.DP;
import java.util.*;

public class MinimumPartitioning_Tabulation {

    //You are given an array of integers and you need to divide the given elements into 2 sets (with any length)
    //Such that the modulo of difference (or absolute difference) between the 2 sets is minimum.

    // APPROACH:
    // Lets calculate the sum of all elements of array and divide it by 2 to find half, this will give us
    // the ideal value closest to which the elements' sum should reach.
    // Then we can run 0/1 Knapsack and check the max value less than half that can be reached at any
    // point using elements of array.
    //The closest you reach can be subtracted from complete sum to find value of the other set.
    // The difference of the two is our answer. Enjoy...

    //It was a little difficult to imagine at first but then I did it.

    public static int tabulation(int arr[], int dp[][]){
        for(int i=0;i<dp.length;i++){
            dp[i][0]= 0;
        }

        for(int j=0;j<dp[0].length;j++){
            dp[0][j]= 0;
        }

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int wt= j;
                int val= arr[i-1];
                if(val <= wt ){        //valid
                    int ans1= dp[i-1][j-val] + val;      //included
                    int ans2= dp[i-1][j];                //not included
                    dp[i][j]= Math.max(ans1, ans2);
                }
                else{
                    dp[i][j]= dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        int arr[]= {1,6,5,11,4,6};

        int sum= 0;
        for(int i=0;i<arr.length;i++){
            sum+= arr[i];
        }

        int half= sum/2;             //This is the ideal value that the container should hold inorder to be
                                     // the minimum difference sets

        int dp[][]= new int[arr.length+1][half+1];



        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }



        int ans= tabulation(arr, dp);
        System.out.println(ans);
        int finalAns=0;
        if( sum%2 == 0){
            finalAns= (half-ans)*2;
        }
        else{
            finalAns= (half-ans)*2 +1;
        }
        System.out.println("final ans= " + finalAns);

        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + " ");
                if(dp[i][j]<10 && dp[i][j]!=-1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
