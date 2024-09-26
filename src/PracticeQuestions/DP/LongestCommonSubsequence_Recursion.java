package PracticeQuestions.DP;

public class LongestCommonSubsequence_Recursion {

    public static int recursion(String a, String b, int i1, int i2){
        if(i1 < 0 || i2 < 0){
            return 0;
        }

        if(a.charAt(i1) == b.charAt(i2)){                        //Valid
            int ans1= recursion(a,b,i1-1, i2-1);     //included
            return 1 + ans1;    // 1 is added as the last chars of both strings are same.
        }
        else{
            int ans1= recursion(a,b,i1-1, i2);               //reduce char at 'a' and not 'b'
            int ans2= recursion(a,b,i1,i2-1);               // reduce char at 'b' and not 'a'

            return Math.max(ans1, ans2);
        }

    }

    public static void main(String[] args){         //O(n^n)
        String a= "abcdefg";
        String b= "adbctfxg";    //LCS= abcfg   length= 5;

        String x= "kavneet";
        String y= "adfsdvsdsdnasxascseet";

        int ans= recursion(x,y, x.length()-1, y.length()-1);
        System.out.println(ans);
    }
}
