import java.util.*;

public class KeypadCombos {

    //LeetCode - 17

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

    public static List<String> comboPrinter(String num) {

        if(num.length()==0){
            return new ArrayList<>();
        }

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

        // System.out.println(al);
        return al;
    }
    public static void main(String[] args){
        String digits="23";
        List<String> arr= comboPrinter(digits);


        for(int i=0;i<arr.size();i++){
            System.out.print(arr.get(i) + " ");
        }
    }
}
