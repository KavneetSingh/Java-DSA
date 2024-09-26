package PracticeQuestions.LeetCode.String;
import java.util.*;

public class ReplaceAllDigitsWithCharacters {
    public static String replaceDigits(String s) {
        char ch='a';
        StringBuilder sb= new StringBuilder("");
        for(int i=0;i<s.length();i++){
            int k= -1;
            if(i%2 == 1){
                k= Integer.parseInt(s.substring(i,i+1));
                k= (ch-'a'+ k) % 26;
                ch= (char)('a'+k);
            }
            else{
                ch= s.charAt(i);
            }
            sb.append(ch);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        String s= "a1c1x8";
        System.out.println(replaceDigits(s));
    }
}
