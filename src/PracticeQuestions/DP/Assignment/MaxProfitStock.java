package PracticeQuestions.DP.Assignment;

public class MaxProfitStock {
    // print the max profit that you can accumulate and keep in mind the transaction cost everytime.
    // Additionally print the difference of days between transactions

    public static int tabulation(int[] arr, int[] dp, int cost){

        dp[0]= dp[1]= 0;

        int ans=0;

        for(int i=2;i<dp.length;i++){
            if(arr[i-1]> arr[i-2]){
                dp[i]= 1;
            }
        }

        int start=-1;
//        int end= -1;
        int endStart[]= new int[arr.length];



        for(int i=1;i<dp.length;i++){
            if(dp[i]==1){
                if(start==-1){
                    start= i-1;
                }
                endStart[i-1]= 1;                    //1 denotes stoke bought;
                if(i+1<dp.length && dp[i+1]== 1){
                    continue;
                }
                else{
                    if(arr[i-1] > arr[start-1] + cost){
                        ans+= arr[i-1]-cost-arr[start-1];
                        endStart[i-1]= 2;      //2 demotes stock sold
                        start=-1;
                    }
                }

            }
        }

        //working fine till here; Now we need to find the gap between trades

        return ans;

    }

    public static void main(String[] args){
        int arr[]= {6,1,7,2,8,4};
        int transactionCost= 2;       //answer will be 8

        int dp[]= new int[arr.length+1];

        int ans= tabulation( arr, dp, transactionCost);
        System.out.println(ans);
    }
}
