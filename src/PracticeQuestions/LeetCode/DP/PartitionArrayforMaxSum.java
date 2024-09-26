package PracticeQuestions.LeetCode.DP;

public class PartitionArrayforMaxSum {
    //LeetCode Q)1043
    public static void main(String[] args){
        int arr[]= {1,15,7,9,2,5,10};        //ans= 84
        int k= 3;
        int dp[]= new int[arr.length+1];

        for(int i=1;i<dp.length;i++){
            int max= 0;
            int curr= i;
            int res= 0;
            while(curr>0 && curr>i-k){
                max= Math.max(max, arr[curr-1]);
                int temp= max*(i-curr+1) + dp[curr-1];
                res= Math.max(res, temp);
                curr--;
            }

            dp[i]= res;
        }

        System.out.println(dp[dp.length-1]);
    }
}
