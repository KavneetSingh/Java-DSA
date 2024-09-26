package PracticeQuestions.DP;

public class MatrixChainMultiplication_Recursion {

    //Calculate the minimum cost of multiplying sequence of matrices, such that
    // 2 consecutive elements of the array represent the dimensions of a matrix
    // the cost of multiplying 2 matrices (AxB) & (BxC) = A*B*C;
    // The array denotes the matrices as: {1,2,3,4} represents 3 arrays with dimensions  (1x2) , (2x3) & (3x4).

    public static int recursion(int arr[], int i, int j){

        if(j<=i){
            return 0;                 //Single matrix case
        }

        int min= Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int ans1= recursion(arr, i, k);           //A(i) to A(k)
            int ans2= recursion(arr, k+1, j);       //A(k+1) to A(j)

            int ans3= arr[i-1] * arr[k] * arr[j];

            int finalAns= ans1 + ans2 + ans3;

            min= Math.min(min, finalAns);
        }
        return min;
    }

    public static void main(String[] args){
        int arr[]= {1,2,3,4,3};

        int ans= recursion(arr, 1, arr.length-1);
        System.out.println(ans);
    }
}
