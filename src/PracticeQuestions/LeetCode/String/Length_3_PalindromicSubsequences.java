package PracticeQuestions.LeetCode.String;
import java.util.*;

public class Length_3_PalindromicSubsequences {

    //LeetCode Q)1930
    //Return the number of unique subsequences of length 3 that are palindromes too.

    public static void main(String[] args){

        String s= "bbcbaba";

        boolean[][] pals= new boolean[26][26];      //storing palindromes already admitted
        // pals are stored in {'j''ch''j'} form
        int[] front= new int[26];               //store the first iteration of each alphabet
        Arrays.fill(front, Integer.MAX_VALUE);
        int[] back= new int[26];               //store the last iteration of each alphabet
        Arrays.fill(back, Integer.MIN_VALUE);

        int ans= 0;

        for(int i=0;i<s.length();i++){
            int ch= s.charAt(i)-'a';
            front[ch]= Math.min(front[ch], i);
            back[ch]= Math.max(back[ch], i);
        }

        for(int i=0;i<s.length();i++){
            int ch= s.charAt(i) - 'a';
            for(int j=0;j<26;j++){
                if(front[j] < i && back[j]>i && !pals[j][ch]){
                    ans++;
                    pals[j][ch]= true;
                }
            }
        }

        System.out.println(ans);
    }
}
