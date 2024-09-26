package PracticeQuestions.LeetCode.Queue;
import java.util.*;

public class LongestSubstringWithoutRepeatingChar {
    //LeetCode Q)3

    public static void main(String[] args){
        String s= "abcabcbb";
        HashSet<Character> hs= new HashSet();
        int ans= 0;
        Queue<Character> q= new LinkedList<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(hs.contains(ch)){
                char x;
                do{
                    x= q.remove();
                    hs.remove(x);
                }while(x!=ch);
            }
            q.add(ch);
            hs.add(ch);
            System.out.print(ch + " ");
            ans= Math.max(ans, q.size());
            System.out.println(q.size());
        }

        System.out.println(ans);
    }
}
