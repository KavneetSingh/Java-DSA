package JavaDsa.Stacks;
import java.util.Stack;

public class DuplicateParenthesis {

    public static boolean duplicatePar(String str){
        Stack<Character> s= new Stack<>();
        for(int i=0; i<str.length();i++){
            char a= str.charAt(i);
            if(a!=')'){
                s.push(a);
            }
            else{
                int count=0;
                while(s.peek()!= '('){
                    s.pop();
                    count++;
                }
                s.pop();
                if(count<1){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        //code to tell whether any extra parenthesis are present or not
        String str= "((a+b))";
        System.out.println( duplicatePar(str) );
    }
}
