package PracticeQuestions.DP;

public class CatalanNumber_Memoization {

    //Catalans number is a sequence:  Cn= Cn-1.C0 + Cn-2.C1 + Cn-3.C2 +.....+ C2.Cn-3 + C1.Cn-2 + C0.Cn-1;
    //eg=>     C5=  C4.C0 + C3.C1 + C2.C2 + C1.C3 + C0.C4;

    public static int memoization(int curr, int[] dp){
        if(curr== 0 || curr==1){
            return 1;
        }
        if(dp[curr]!= -1){
            return dp[curr];
        }

        int ans=0;


        for(int i=0;i<curr;i++){
            ans+= memoization(i, dp) * memoization(curr-i-1, dp);
        }

        dp[curr]= ans;
        return ans;
    }

    public static void main(String[] args){
        int x= 7;
        int dp[]= new int[x+1];

        for(int i=0;i<dp.length;i++){
            dp[i]= -1;
        }

        dp[0]= 1;
        dp[1]= 1;

        int ans= memoization( x , dp );
        System.out.println(ans);


        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
    }
}
