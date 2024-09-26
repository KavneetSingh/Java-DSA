package PracticeQuestions.DP;

public class TargetSumSubset {

    public static boolean targetSumTabulation(int arr[], int target, boolean dp[][]){
        for(int i=0;i<dp.length;i++){    //At zero items, getting a sum of 0 is still possible (coz of null set).
            dp[i][0]= true;
        }


        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                int currVal= arr[i-1];
                if(currVal == j){
                    dp[i][j]= true;                          // element alone adds up to target
                }

                else if(j > currVal  &&  dp[i-1][j - currVal]){    //included with previous sums
                    dp[i][j]= true;
                }
                else if(dp[i-1][j]){                 // the element is excluded but the sum is achievable becoz of previous elements
                    dp[i][j]= true;
                }
            }
        }
        boolean ans= false;
        for(int i=1; i<dp.length;i++){
            if(dp[i][target]){
                ans= true;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr={4,2,7,1,3};
        int target= 10;

        //variable 1= element index;
        //variable 2= subset size;

        boolean dp[][]= new boolean[arr.length+1][target+1];

        boolean ans= targetSumTabulation(arr, target, dp);
        System.out.println(ans);

        //print
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if(dp[i][j]){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
//                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
