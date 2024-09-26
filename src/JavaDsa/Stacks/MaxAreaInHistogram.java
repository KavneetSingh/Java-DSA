package JavaDsa.Stacks;
import java.util.Stack;

public class MaxAreaInHistogram {

    public static void nextSmallerRight(int h[], int rightSmaller[]){
        // Stores index of right smaller element in the array
        Stack<Integer> s= new Stack<>();
        for(int i=h.length-1;i>=0;i--){

            while(!s.isEmpty() && h[i]<h[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                rightSmaller[i]= h.length;
            }else{
                rightSmaller[i]= s.peek();
            }
            s.push(i);
        }
    }

    public static void nextSmallerLeft(int h[], int leftSmaller[]){
        // Stores the index of left smaller element in the array
        Stack<Integer> s= new Stack<>();
        for(int i=0;i<h.length;i++){

            while(!s.isEmpty() && h[i]<h[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                leftSmaller[i]=-1;
            } else{
                leftSmaller[i]= s.peek();
            }
            s.push(i);
        }
    }

    public static void main(String[] args){
        // Find the max are possible in histogram using height and width of a bar and its surrounding bars
        int heights[]= {2,1,5,6,2,3};
        // first select a bar and its height will act as height of the rectangle...
        // then find the width of the rectangle using same logic as that of (NextGreaterElement) que
        int leftSmaller[]= new int[heights.length];
        int rightSmaller[]= new int[heights.length];

        nextSmallerLeft(heights, leftSmaller);  //Working perfectly
        nextSmallerRight(heights, rightSmaller); // Working perfectly

//        for(int i=0;i<leftSmaller.length;i++){
//            System.out.print(leftSmaller[i]+" ");
//        }
//        System.out.println();
//        for(int i=0;i<rightSmaller.length;i++){
//            System.out.print(rightSmaller[i]+" ");
//        }
//        System.out.println();

        int maxArea=-1;

        for(int i=0;i< heights.length;i++){
            int area= (rightSmaller[i]-leftSmaller[i]-1) * heights[i];
            if(area>maxArea){
                maxArea= area;
            }
        }
        System.out.println(maxArea);
    }
}
