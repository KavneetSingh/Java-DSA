package PracticeQuestions.DP;

public class FibonacciSequence {

    public static int fib(int x, int[] arr){
        //Using memoization
        if(x==1 || x==0){
            return x;
        }

        if(arr[x]!=0){
            return arr[x];
        }


        arr[x]= fib(x-1, arr) + fib(x-2, arr);
        return arr[x];
    }

    public static void main(String[] args){
        int x= 5;
        int arr[]= new int[x+1];
//        fib(x, arr);
        System.out.println(fib(x, arr));
//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+" ");
//        }

        //Using tabulation
//        arr[0]= 0;
//        arr[1]= 1;
//        for(int i=2;i<x+1;i++){
//            arr[i]= arr[i-1]+ arr[i-2];
//        }
    }
}
