package PracticeQuestions.LeetCode.Matrix;

public class RotateImage {
    //LeetCode Q)48
    public static void main(String[] args){

        int arr[][]= {{5,1,9,11},
                      {2,4,8,10},
                      {13,3,6,7},
                      {15,14,12,16}};
        /*ans= [[15,13,2,5],
                [14,3,4,1],
                [12,6,8,9],
                [16,7,10,11]]
         */

        int row=0;
        for(row=0;row<arr.length/2;row++){
            int l= row;
            int r= arr.length-1-row;
            int b= arr.length-1-row;
            int u= row;
            // arr[u][l+i]        top left element goes from left to right
            // arr[b-i][l]        bottom left element goes from bottom to top
            // arr[b][r-i]        bottom right element goes from right to left
            // arr[u+i][r]        top right element goes from top to bottom
            for(int i=0,j=l;j<r;j++,i++){
                int temp= arr[u][l+i];
                arr[u][l+i]= arr[b-i][l];
                arr[b-i][l]= arr[b][r-i];
                arr[b][r-i]= arr[u+i][r];
                arr[u+i][r]= temp;
            }
        }
    }
}
