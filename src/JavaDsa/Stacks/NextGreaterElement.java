package JavaDsa.Stacks;
import java.util.Stack;

public class NextGreaterElement {

    public static void nextGreatFinder(int num[], int nextGreater[]){
        Stack<Integer> s= new Stack<>();

        for(int i= num.length-1;i>=0;i--){

            while(!s.isEmpty() && s.peek()<=num[i]){
                s.pop();
            }

            if(s.isEmpty()){
                nextGreater[i]= -1;
            }else{
                nextGreater[i]=s.peek();
            }
            s.push(num[i]);
        }
    }

    public static void main(String[] args){
        //The next greater element of some element x in an array is the first greater
        //element that is to the right of x in the same array.
        int num[]= {4,3,6,4,2,7,9,3,6};
        int nextGreater[]= new int[num.length];
        nextGreatFinder(num,nextGreater);

        for(int i=0;i<nextGreater.length;i++){
            System.out.print(nextGreater[i]+" ");
        }
        System.out.println( );

        //Next greater Right
        //Next greater Left
        //Next smaller Left
        //Next smaller Right
    }
}
