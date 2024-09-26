package PracticeQuestions.DP.Assignment;

public class MinRemovalsForMountain {
    /*
    You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array nums, return the minimum number
 of elements to remove to make nums a mountain array.
     */


    //Tried all the shitty things to solve this question, and now I realize this could only be solved using
    // the Longest Increasing Sequence algo. Find the longest increasing algo from left
    // and also from right and then figure out what to do.


    public static void longestIncreasingSubsequence(int[] arr, int[] dp){
        dp[0]= 0;

        for(int i=1;i<dp.length-1;i++){       //O(n^2)
            int helper=0;
            for(int j=0;j<i;j++){

                if(arr[j] < arr[i-1]){
                    helper = Math.max(helper, dp[j+1]);
                }
            }
            dp[i]= helper + 1;
        }
    }


    public static void longestIncreasingSubsequenceInverse(int[] arr, int[] dp){
        dp[0]=dp[dp.length-1]= 0;

        for(int i=dp.length-2;i>0;i--){       //O(n^2)
            int helper=0;
            for(int j=dp.length-1;j>i;j--){

                if(arr[j-2] < arr[i-1]){
                    helper = Math.max(helper, dp[j-1]);
                }
            }
            dp[i]= helper + 1;
        }
    }

//    public static int tabulation(int[] arr, int[][] dp){
//
//        dp[0][0]= dp[1][0]= dp[0][dp[0].length-1]= dp[1][dp[0].length-1]= -1;
//
//        for(int i=1;i<dp[0].length-1;i++){             //Left mountains
//            if(i-2>=0 && arr[i-1]>arr[i-2]){         //Valid
//                dp[0][i]= dp[0][i-1];             //no dikkat
//            }
//            else{                               //invalid
//                int x=i;
//                int helper=0;
//                while(x-2>1 && arr[i-1]<=arr[x-2] && dp[0][x-2] == dp[0][x-1]){
//                    x--;
//                    helper++;
//                }
//
//                dp[0][i]= dp[0][i-1] + 1 + helper;       //add 1 to left one's value
//            }
//        }
//
//        for(int j= dp[0].length-2;j>0;j--){         //Right mountains
//            if(j<arr.length && arr[j-1] > arr[j]){                //Valid
//                dp[1][j]= dp[1][j+1];             //Again no dikkat
//            }
//            else{                                  //Invalid
//                int x=j;
//                int helper= 0;
//
//                while(x+1<dp.length-1 && arr[x] >= arr[j-1] && dp[1][x]==dp[1][x+1]){
//                    x++;
//                    helper++;
//                }
//
//                dp[1][j]= dp[1][j+1] + 1 + helper;         //add 1 to the right value;
//            }
//        }
//
//        int min= Integer.MAX_VALUE;
////        int idx= 0;
////        if(dp[0][i] + dp[1][i] < min){
////            min= dp[0][i] + dp[1][i];
////            idx= i;
////        }
//        for(int i=1;i<dp[0].length-1;i++){
//            min= Math.min(min, dp[0][i] + dp[1][i]);
//        }
//        return min;
//    }

    public static void main(String[] args){
//        int arr[]= {4,3,2,1,1,2,3,1};    //ans=4
//        int arr[]= {9,8,1,7,6,5,4,3,2,1};    //ans=2
//        int arr[]= {100,92,89,77,74,66,64,66,64};    //ans= 6
        int arr[]= {1,2,1,3,4,4};

        int[][] dp= new int[2][arr.length+2];

        longestIncreasingSubsequence(arr, dp[0]);
        longestIncreasingSubsequenceInverse(arr, dp[1]);

        for(int i=0;i<dp[0].length;i++){
            dp[0][i]= i - dp[0][i];
            dp[1][i]= dp[1].length- 1 -i - dp[1][i];
        }
        int n= 1;
        int m= dp[0].length-2;                       //This dp[0].length is very important and not dp.length
                                                     //Take care in the future
        while(n<arr.length && arr[n-1] > arr[n]){
            n++;
        }
        while(m>0 && arr[m-1]>=arr[m-2]){
            m--;
        }

        System.out.println(n);
        System.out.println(m);

        int min= Integer.MAX_VALUE;
        for(int i=n;i<m;i++){
            min= Math.min(min, dp[0][i]+dp[1][i]);
        }

        System.out.println(min);

//        int ans= tabulation(arr, dp);
//        System.out.println(ans);

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
