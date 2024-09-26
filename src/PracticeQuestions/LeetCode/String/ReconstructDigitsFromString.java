package PracticeQuestions.LeetCode.String;

import java.util.HashMap;

public class ReconstructDigitsFromString {

    public static String originalDigits(String s){
        HashMap<Character, Integer> hm= new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(hm.containsKey(ch)){
                int x= hm.get(ch);
                hm.put(ch, x+1);
            }
            else{
                hm.put(ch,1);
            }
        }

        StringBuilder sb= new StringBuilder("");
        int arr[]= new int[10];

        if(hm.containsKey('z')){
            int x= hm.get('z');
            arr[0]= x;
        }
        if(hm.containsKey('w')){
            int x= hm.get('w');
            arr[2]= x;
        }
        if(hm.containsKey('u')){
            int x= hm.get('u');
            arr[4]= x;
        }
        if(hm.containsKey('x')){
            int x= hm.get('x');
            arr[6]= x;
        }
        if(hm.containsKey('g')){
            int x= hm.get('g');
            arr[8]= x;
        }
        if(hm.containsKey('o')){
            int x= hm.get('o');
            arr[1]= x - arr[0] - arr[2] - arr[4];
        }
        if(hm.containsKey('h')){
            int x= hm.get('h');
            arr[3]= x- arr[8];
        }
        if(hm.containsKey('f')){
            int x= hm.get('f');
            arr[5]= x-arr[4];
        }
        if(hm.containsKey('v')){
            int x= hm.get('v');
            arr[7]= x- arr[5];
        }
        if(hm.containsKey('i')){
            int x= hm.get('i');
            arr[9]= x- arr[5] - arr[6] - arr[8];
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        for(int i=0;i<10;i++){
            for(int j=0;j<arr[i];j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
//        String s= "towioztenneeogienhr";
//        String s= "owoztneoer";
        String s= "esnve";

        System.out.println(originalDigits(s));
    }
}
