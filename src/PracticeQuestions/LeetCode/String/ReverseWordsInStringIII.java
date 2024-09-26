package PracticeQuestions.LeetCode.String;
import java.util.*;

public class ReverseWordsInStringIII {

    //Leetcode Q- 557.
    public static String reverse(String str){
        Stack<Character> s= new Stack<>();
        StringBuilder sb= new StringBuilder();
        int i=0;
        while(i<str.length()){
            char a= str.charAt(i);

            if(a==' ' || i==str.length()-1){
                if(i==str.length()-1){
                    s.add(a);
                }
                while(!s.isEmpty()){
                    sb.append(s.pop());
                }
                if(i==str.length()-1){
                    break;
                }
                sb.append(' ');
                i++;
                continue;
            }
            s.add(a);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        String str= "Let's go and beat some java Questions";

        System.out.println(reverse(str));
    }
}
