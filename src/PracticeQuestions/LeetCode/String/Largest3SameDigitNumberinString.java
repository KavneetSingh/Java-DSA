package PracticeQuestions.LeetCode.String;
import java.util.*;

public class Largest3SameDigitNumberinString {

    //LeetCode Q)2264

    public static void main(String[] args){
        String num= "6444444777133339";
        int x= -1;
        char ch= num.charAt(0);
        int count=1;
        for(int i=1;i<num.length();i++){
            if(num.charAt(i)== ch){
                count++;
                if(count==3){
                    x= Math.max(x, Integer.parseInt(num.substring(i-1,i)));
                }
            }
            else{
                count=1;
                ch= num.charAt(i);
            }
        }
        if(x==-1){
            System.out.println("null");
        }
        else{
            StringBuilder sb= new StringBuilder("");
            for(int i=0;i<3;i++){
                sb.append(x);
            }
            System.out.println(sb.toString());
        }
    }
}
