package JavaDsa.Stacks;

import java.util.Stack;

public class ReverseUsingStack {
    public static String reverseUsingStack(Stack s, String str){
        String newStr="";
        for(int i=0;i<str.length();i++){
            s.push(str.charAt(i));
        }

        StringBuilder result= new StringBuilder(""); //Using stringBuilder instead of String coz...
        while(!s.isEmpty()){
            result.append(s.pop());
        }
        return result.toString();  // remember this .toString() function
    }

    public static void main(String[] args) {

        Stack<Character> s = new Stack<>();
        String str= "sdckjn";
        System.out.println(reverseUsingStack(s, str));
        System.out.println(str);
    }
}
