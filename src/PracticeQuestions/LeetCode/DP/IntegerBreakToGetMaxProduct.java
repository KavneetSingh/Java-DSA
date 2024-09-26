package PracticeQuestions.LeetCode.DP;

public class IntegerBreakToGetMaxProduct {

    //LeetCode Q) 343
    //Q) Break the integer into components which add up to make the number and return the maximum product
    // of all the components possible.
    //eg: 10= 2+2+2+2+2;    product of this combination is: 2^5= 32;
    //But the maximum product solution for n=10 is 36. How?  10= 3+3+4; 3*3*4= 36;  That's how

    public static int maxProd(int dp[]){
        if(dp.length==3){
            return 1;
        }
        for(int i=2;i<dp.length;i++){
            int maxProd= 0;
            for(int j=2;j<i;j++){
                int ans1= dp[j]*(i-j);
                int ans2= j*(i-j);
                maxProd= Math.max(ans1,ans2);
                dp[i]= Math.max(dp[i], maxProd);
            }
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args){
        int n= 20;
        int dp[]= new int[n+1];

        int ans= maxProd(dp);
        System.out.println(ans);
    }
}
