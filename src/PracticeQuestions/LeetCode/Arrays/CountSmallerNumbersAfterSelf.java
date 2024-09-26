package PracticeQuestions.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.List;

public class CountSmallerNumbersAfterSelf {
    //LeetCode Q) 315


    public static void main(String[] args){
//        int arr[]= {5,2,6,1};
        int arr[]= {-1,-1};
        int min= Integer.MAX_VALUE;
        int max= Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            min= Math.min(arr[i], min);
            max= Math.max(arr[i],max);
        }

        int matrix[][]= new int[max-min+1][arr.length+1];  //arr[0] denotes min value;  coz min can be negative
        // arr[i] -> arr[i - min];

        for(int i=0;i<arr.length;i++){
            int x= arr[i];
            matrix[x-min][i]= 1;
//            System.out.println(x-min + ", " + i);
        }

//        for(int i=0;i<matrix.length;i++){
//            for(int j=0;j<matrix[0].length;j++){
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        for(int i=0;i<matrix.length;i++){                   //store the count of an element till curr index
            int currCount=0;
            for(int j=0;j<matrix[0].length;j++){

                if(matrix[i][j]==1){
                    currCount++;
                }
                matrix[i][j]= currCount;
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println();

        List<Integer> ans= new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            int curr= arr[i];
            int currSum=0;
            for(int j=0;j<arr[i]-min;j++){
                currSum += matrix[j][matrix[0].length-1] - matrix[j][i];
            }
            ans.add(i, currSum);
        }

        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i) + " ");
        }
    }
}
