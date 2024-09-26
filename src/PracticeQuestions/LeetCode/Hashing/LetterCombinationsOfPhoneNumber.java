package PracticeQuestions.LeetCode.Hashing;
import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    /*  leet code Q17
    Given a string containing digits from 2-9 inclusive, return all possible letter combinations that
     the number could represent. Return the answer in any order.

    A mapping of digits to letters (just like on the telephone buttons) is given below. Note that
     1 does not map to any letters.

    Example 1:

    Input: digits = "23"
    Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
    Example 2:

    Input: digits = ""
    Output: []
    Example 3:

    Input: digits = "2"
    Output: ["a","b","c"]
     */

    public static void print(StringBuilder sb, ArrayList<String> al, HashMap<Character, String> hm, String num, int curr){
        if(curr== num.length()){
            al.add(sb.toString());
            return;
        }

        char digit= num.charAt(curr);
        String x= hm.get(digit);

        for(int i=0;i<x.length();i++){
            char ch= x.charAt(i);
            print(sb.append(ch), al, hm, num, curr+1);
            sb.deleteCharAt(curr);
        }
    }

    public static void main(String[] args){

//        String num= "23";  //ans= [ad, ae, af, bd, be, bf, cd, ce, cf]
//        String num= "";      //ans= []
//        String num= "2";     //[a, b, c]
        String num= "67";   //ans= [mp, mq, mr, ms, np, nq, nr, ns, op, oq, or, os]


        HashMap<Character, String> hm= new HashMap<>();

        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        ArrayList<String> al= new ArrayList<>();
        StringBuilder sb= new StringBuilder("");

        print(sb, al, hm, num, 0);

        System.out.println(al);

//        System.out.println(new ArrayList<>());

    }
}
