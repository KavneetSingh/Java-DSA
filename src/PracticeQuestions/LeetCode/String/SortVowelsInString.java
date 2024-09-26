package PracticeQuestions.LeetCode.String;

import java.util.*;

public class SortVowelsInString {
    public static void main(String[] args){
        String s= "lEetcOde";
        HashSet<Character> hs= new HashSet<>();

        String vowels= "AEIOUaeiou";
        for(int i=0;i<vowels.length();i++){
            hs.add(vowels.charAt(i));
        }

        HashMap<Character, Integer> hm= new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(hs.contains(ch)){
                if(hm.containsKey(ch)){
                    hm.put(ch, hm.get(ch)+1);
                }
                else{
                    hm.put(ch,1);
                }
            }
        }
        StringBuilder sb= new StringBuilder("");

        int ptr= 0;
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(hs.contains(ch)){
                while(!hm.containsKey(vowels.charAt(ptr))){
                    ptr++;
                }
                sb.append(vowels.charAt(ptr));
                if(hm.get(vowels.charAt(ptr))== 1){
                    hm.remove(vowels.charAt(ptr));
                }
                else hm.put(vowels.charAt(ptr), hm.get(vowels.charAt(ptr))-1);
            }
            else{
                sb.append(ch);
            }
        }

        System.out.println(sb.toString());
    }
}
