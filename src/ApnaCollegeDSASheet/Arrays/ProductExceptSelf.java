package ApnaCollegeDSASheet.Arrays;

public class ProductExceptSelf {
    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to
     the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation.


     */
    public static void main(String[] args){
//        int arr[]= {1,2,3,4};
        int arr[]= {-1,1,0,-3,3};
        int[] leftProd= new int[arr.length];
        int[] rightProd= new int[arr.length];

        int prod=1;

        for(int i=0; i<arr.length; i++){
            leftProd[i]= prod;
            prod*= arr[i];
        }
        prod= 1;
        for(int i= arr.length-1;i>=0;i--){
            rightProd[i]= prod;
            prod*= arr[i];
        }

        int ans[]= new int[arr.length];

        for(int i=0;i<ans.length;i++){
            ans[i]= leftProd[i] * rightProd[i];
            System.out.print(ans[i] + " ");
        }
    }
}
