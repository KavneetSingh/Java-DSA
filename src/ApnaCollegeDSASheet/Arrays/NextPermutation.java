package ApnaCollegeDSASheet.Arrays;
import java.util.*;

public class NextPermutation {

    //LeetCode Q)31
    //Very imp. 🔥🔥🔥

    //the question is to find the next permutation of the lexicographic arrangement of the given integer

    //You can do this by iterating from left and reaching the first point where the array is sorted
    //1. stop at the first element that is lesser than its previous element
    //2. swap its position with the next greater element in the righter elements
    //3. sort the right part of the array without affecting the left and the index found in step 1.

    public static void nextPerm(int arr[]){

        boolean decreasing= true;
        int prev= arr[0];
        for(int i=0;i<arr.length;i++){
            if(prev<arr[i]){
                decreasing= false;
                break;
            }
            prev= arr[i];
        }

        if(decreasing){
            Arrays.sort(arr);
            return;
        }

        int x= arr.length-1;
        while(x>=1 && arr[x-1]>=arr[x]) {        //1. finding the first element that's lesser than its right element
            x--;
        }

        x= Math.max(0, x-1);

//        System.out.println(x);




        int start=x;
        while(start<arr.length-1 && arr[start+1]> arr[x]) start++;    //2. finding the next greater element in the right

        int temp= arr[start];          //swapping their values
        arr[start]= arr[x];
        arr[x]= temp;

        int arr2[]= new int[arr.length-1-x];        //3. sorting the subarray in the right of x.
        for(int i=0;i<arr2.length;i++){
            arr2[i]= arr[x+i+1];
        }

        Arrays.sort(arr2);
        for(int i=0;i<arr2.length;i++){
            arr[x+i+1]= arr2[i];
        }

    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}
