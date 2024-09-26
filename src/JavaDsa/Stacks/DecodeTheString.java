package JavaDsa.Stacks;
import java.util.Stack;


public class DecodeTheString {

    public static String decoder(String str){
        Stack<Integer> integerStack= new Stack<>();
        Stack<Character> charStack= new Stack<>();
        String temp="", result="";
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9'){
                int count=0;
                while(Character.isDigit(str.charAt(i))){
                    count=count*10 + (str.charAt(i)-'0');
                    i++;
                }
                i--;
                integerStack.push(count);
            }
            else if(str.charAt(i)==']'){
                temp="";
                int count=0;
                if(!integerStack.isEmpty()){
                    count= integerStack.peek();
                    integerStack.pop();
                }
                while(!charStack.isEmpty() && charStack.peek()!='['){
                    temp= charStack.peek()+ temp;
                    charStack.pop();
                }
                if(!charStack.isEmpty() && charStack.peek()!='['){
                    charStack.pop();
                }

                for(int j=0;j<count;j++){
                    result=result+temp;
                }
                for(int j=0;j<result.length();j++){
                    charStack.push(result.charAt(j));
                }

                result= "";
            }
            else if(str.charAt(i)== '['){
                if(Character.isDigit(str.charAt(i-1))){
                    charStack.push(str.charAt(i));
                }
                else{
                    charStack.push(str.charAt(i));
                    integerStack.push(1);
                }
            }

            else{
                charStack.push(str.charAt(i));
            }
        }
        while(!charStack.isEmpty()){
            result= charStack.peek()+ result;
            charStack.pop();
        }
        return result;
    }

    public static void main(String[] args){
        String str="2[CV]";
        System.out.println(decoder(str));
    }
}
