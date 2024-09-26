package PracticeQuestions.LeetCode.DP;
import java.util.*;

public class DecodeWays {
    //LeetCode Q)91
    public static void main(String[] args){
//        String s= "122027";   //ans= 2
//        String s= "122023";   //ans= 4
        String s= "10011";   //ans= 0

        int dp[]= new int[s.length()+1];
        dp[0]= 1;     //coz there exists some way
        if(s.charAt(0)=='0') System.out.println(0);
        dp[1]=1;
        for(int i=2;i<dp.length;i++){
            String s1= s.substring(i-1,i);
            String s2= s.substring(i-2,i);
            int i1= Integer.parseInt(s1);
            int i2= Integer.parseInt(s2);
            if(i1==0 && i2>26 || i2==0){
                System.out.println(0);
            }
            if(i2<=26 & i2>0)   dp[i]+= dp[i-2];
            if(i1!=0) dp[i]+= dp[i-1];
            if(i1==i2) dp[i]= dp[i-1];
        }

        System.out.println(dp[dp.length-1]);

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println();
    }
}
