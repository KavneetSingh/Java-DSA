package PracticeQuestions.LeetCode.String;
import java.util.*;

public class FindUniqueBinaryString {

    //LeetCode Q)1980
    public static String uniq(StringBuilder sb, HashSet<String> hs, int n){
        if(sb.length()== n){
            if(!hs.contains(sb.toString())){
                return sb.toString();
            }
            return "";
        }

        String s1= uniq(sb.append(1), hs, n);
        sb.deleteCharAt(sb.length()-1);
        String s2= uniq(sb.append(0), hs, n);
        sb.deleteCharAt(sb.length()-1);

        if(s1.length()==n){
            return s1;
        }
        return s2;
    }

    public static void main(String[] args){
        String[] nums= {"111","011","001"};

        //solution 1
//        HashSet<String> hs= new HashSet<>();
//        for(int i=0;i<nums.length;i++){
//            hs.add(nums[i]);
//        }
//        StringBuilder sb= new StringBuilder();
//        String ans= uniq(sb, hs, nums.length);
//
//        System.out.println(ans);


        //solution 2
        HashSet<Integer> hs= new HashSet<>();
        for(int i=0;i<nums.length;i++){
            hs.add(Integer.parseInt(nums[i], 2));
        }

        String ans="";
        for(int i=0;i<nums.length+1;i++){
            if(!hs.contains(i)){
                ans= Integer.toBinaryString(i);
            }
        }
        StringBuilder sb= new StringBuilder();
        if(ans.length()<nums.length){
            for(int i=0;i<nums.length-ans.length();i++){
                sb.append(0);
            }
            for(int i=0;i<ans.length();i++){
                sb.append(ans.charAt(i));
            }
            ans= sb.toString();
        }

        System.out.println(ans);


    }
}
