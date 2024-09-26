package PracticeQuestions.LeetCode.DP;
import java.util.*;

public class InterleavingString {
    //LeetCode 97

    /*
    Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

    An interleaving of two strings s and t is a configuration where s and t are divided into n and m
    substrings
    respectively, such that:

    s = s1 + s2 + ... + sn
    t = t1 + t2 + ... + tm
    |n - m| <= 1
    The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
    Note: a + b is the concatenation of strings a and b.
     */


    /*
    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Explanation: One way to obtain s3 is:
Split s1 into s1 = "aa" + "bc" + "c", and s2 into s2 = "dbbc" + "a".
Interleaving the two splits, we get "aa" + "dbbc" + "bc" + "a" + "c" = "aadbbcbcac".
Since s3 can be obtained by interleaving s1 and s2, we return true.
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Explanation: Notice how it is impossible to interleave s2 with any other string to obtain s3.
     */


    /*  Solution:
    You need to check all the possibilities as the s1 and s2 could have the same chars in the first few indexes, but then
     it could make all the difference. the best option is to use DP to check all the possibilities.

     DP[i][j] means that the first i letters of s1 and first j letters of s2 could interleave to form first i+j letters of s3.
     ith letter of s1 is same as (i+j)th letter of s3 and value of dp[i-1][j]==true   OR
     jth letter of s2 is same as (i+j)th letter of s3 and value of dp[i][j-1]== true. ie, i letters of s1 and j-1 letters
      of s2 could interleave to form i+j-1 letters of s3. 🔥 DONE BY ME for myself in the future.

  A small Gift for your hardWork 😘. Keep working hard. You know this is all you can do rest is not in your hands (Maybe it is!).

     */

    public static boolean tabulation(boolean[][] dp, String s1, String s2, String s3){


        if(s3.length() != s1.length()+ s2.length()){
            return false;
        }
        if(s3.length()==0 && s1.length()==0 && s2.length()==0){
            return true;
        }
        else if(s1.length()==0){
            return s2.compareTo(s3)==0;
        }
        else if(s2.length()==0){
            return s1.compareTo(s3)==0;
        }

        //DP starts here

        for(int i=1;i<dp.length;i++){
            if(s1.substring(0,i).compareTo(s3.substring(0,i)) == 0 ){
                dp[i][0]= true;
            }
        }

        for(int j=1;j<dp[0].length;j++){
            if(s2.substring(0,j).compareTo(s3.substring(0,j)) == 0 ){
                dp[0][j]= true;
            }
        }

        dp[0][0]= true;

        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                char a= s1.charAt(i-1);
                char b= s2.charAt(j-1);

                if(dp[i-1][j] && a== s3.charAt(i+j-1)  || dp[i][j-1] && b== s3.charAt(i+j-1)){
                    dp[i][j]= true;
                }
                else{
                    dp[i][j]= false;
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];


    }


    public static void main(String[] args){
//        String s1= "aabcc";
//        String s2= "dbbca";
//        String s3= "aadbbcbcac";

//        String s1= "aabcc";
//        String s2= "dbbca";
//        String s3= "aadbbbaccc";

        String s1= "aabcd";
        String s2= "addcbc";
        String s3= "aadadbcbccd";

//        HashMap<Character, Integer> hm= new HashMap<>();

        boolean[][] dp= new boolean[s1.length()+1][s2.length()+1];

        boolean ans= tabulation(dp, s1, s2, s3);
        System.out.println(ans);

        for(int i=0;i<dp.length;i++){
            for(int j=0;j< dp[0].length; j++){
                System.out.print( dp[i][j]? "T ":"F ");
            }
            System.out.println();
        }
    }
}
