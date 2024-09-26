package PracticeQuestions.RandomPractice;
import java.util.*;

public class MinCostToX {

    public static int tabulation(int dp[], int x, int y, int z, int X){
        for(int i=2;i<dp.length;i++){
            int cost1= dp[i-1]+ y;           //cost of adding 1 to it;
            int cost2= Integer.MAX_VALUE;
            if((i&1)==0){          //i== even
                cost2= dp[i/2] + x;          //cost of multiplying by 2;
            }
            dp[i]= Math.min(cost1, cost2);
            for(int j=2;j<i;j++){
                dp[j]= Math.min(dp[j], dp[j+1]+z);
            }
        }

//        for(int i= dp.length-2;i>=2;i--){
//            dp[i]= Math.min(dp[i], dp[i+1]+z);
//        }

        return dp[X];
    }

    public static void main(String[] args){

        Scanner sc= new Scanner(System.in);

        int X= sc.nextInt();
        int x= sc.nextInt();
        int y= sc.nextInt();
        int z= sc.nextInt();

        int dp[]= new int[X*2];

        dp[0]=-1;
        dp[1]= 0;

        int ans= tabulation(dp, x,y,z, X);
        System.out.println(ans);

    }
}
