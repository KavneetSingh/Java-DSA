package PracticeQuestions.LeetCode.DP;

public class LongestPalindrome {

    //Leetcode Q)5
    //return the longest palindromic substring in s.
    //easy solution would be to iterate whole string and keep every char of string as centre of the palindrome. (this works for odd length)
    // for even length palindrome just shift the right iterator one char to the right if right char is same as curr char.\

    //my approach was to use dp but I figured out i'd have to move diagonally coz each cell needs value from
    //cell diagonally left to it.   So I tried something new doing this.

    public static String pal(boolean dp[][], String s){
//        for(int i=0;i<dp.length;i++){
//            dp[i][i]= true;
//        }
        int I=-1;
        int J=-1;
        int currLength= 0;

        for(int k=0;k<s.length();k++){
            for(int j=k;j<s.length();j++){
                int i= j-k;

                char a= s.charAt(i);
                char b= s.charAt(j);
                if(i==j){
                    dp[i][j]= true;
                }
                else if(j-i==1){
                    dp[i][j]= a==b;
                }
                else if(i<dp.length-1 && j>0){
                    dp[i][j]= dp[i+1][j-1] && a==b;
                }

                if(dp[i][j] && j-i+1>currLength){
                    currLength= j-i+1;
                    I= i;
                    J= j;
                }
            }
        }
        return s.substring(I,J+1);
    }

    public static void main(String[] args){
//        String s= "sbddbb";
//        String s= "cbbd";
        String s= "aaaaa";        //this gave wrong answer coz of an if statement instead of else-if statement
//        String s= "a";

        boolean[][] dp= new boolean[s.length()][s.length()];

        //every cell contains the boolean value of whether the substring from i to j is a palindrome.


        System.out.println(pal(dp,s));

        //Check all the cells of dp:-

//        for(int i=0;i<dp.length;i++){
//            for(int j=0;j<dp.length;j++){
//                if(dp[i][j]){
//                    System.out.print("T ");
//                }
//                else {
//                    System.out.print("F ");
//                }
//            }
//            System.out.println();
//        }
    }
}
