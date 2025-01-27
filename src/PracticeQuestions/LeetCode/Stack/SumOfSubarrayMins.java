package PracticeQuestions.LeetCode.Stack;
import java.util.*;

public class SumOfSubarrayMins {

    //LeetCode Q)907    🔥🔥🔥

    public static void main(String[] args){

        int arr[]= {11,81,94,43,3};

        long res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        long M = (long)1e9 + 7;
        stack.push(-1);

        for (int i2 = 0; i2 < arr.length+1; i2++){
            int currVal = (i2<arr.length)? arr[i2] : 0;

            while(stack.peek() !=-1 && currVal < arr[stack.peek()]){
                int index = stack.pop();
                int i1 = stack.peek();
                int left = index - i1;
                int right = i2 - index;
                long add = (long)(left * right * (long)arr[index]) % M;
                res += add ;
                res %= M;
            }

            stack.push(i2);
        }

        System.out.println(res);
    }
}
