package PracticeQuestions.LeetCode.String;

import java.util.HashMap;

public class WordPattern {
    public static void main(String[] args){
//        String pattern= "abba";
//        String s= "dog cat cat dog";

//        String pattern= "abba";
//        String s= "dog cat cat fish";

//        String pattern= "abba";
//        String s= "dog dog dog dog";

        String pattern= "aaa";
        String s= "aa aa aa aa";

        boolean equalLen;

        int countSubs=0;
        for(int i=0;i<s.length();i++){

            if(s.charAt(i) == ' ' && i!= s.length()-1){
                countSubs++;
            }
        }
        countSubs++;
        System.out.println(countSubs);

        equalLen= pattern.length() == countSubs;

//        String str1= "cat";
//        String str2= new String("cat");


        HashMap<Character,String> hm= new HashMap<>();
        HashMap<String, Character> hm2= new HashMap<>();


        int j=0;
        boolean follows= true;

        for(int i=0;i<pattern.length();i++){

            if(!equalLen){
                follows= false;
                break;
            }

            char ch= pattern.charAt(i);
            if(j!=0){
                j++;
            }
            int start= j;
//            boolean done= false;
            while(j<s.length()  &&   s.charAt(j)!= ' ' ){
                j++;
            }

            String sub= s.substring(start, j);

//            System.out.println(sub);

            if((hm.containsKey(ch) && hm2.containsKey(sub) && (hm2.get(sub)!=ch || hm.get(ch).compareTo(sub)!=0))
                ||  (hm.containsKey(ch) && hm.get(ch).compareTo(sub)!=0) || (hm2.containsKey(sub) && hm2.get(sub)!=ch)){
                follows= false;
                break;
            }
            else{
                hm.put(ch, sub);
                hm2.put(sub, ch);
            }
        }

        System.out.println(follows);
    }
}
