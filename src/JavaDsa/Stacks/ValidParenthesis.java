package JavaDsa.Stacks;
import java.util.Stack;

public class ValidParenthesis {

    public static Boolean validPar(String str){
        if(str.length()==0){
            return true;
        }
        Stack<Character> s= new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(ch=='{' || ch=='(' || ch=='['){
                s.push(ch);
            } else{
                if(s.isEmpty()){
                    return false;
                }
                if(s.peek()=='(' && ch==')' || s.peek()=='[' && ch==']' || s.peek()=='{' && ch=='}'){
                    s.pop();
                } else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        String str="(({[]}){})";
        System.out.println(validPar(str));
    }
}
