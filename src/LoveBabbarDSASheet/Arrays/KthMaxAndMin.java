package LoveBabbarDSASheet.Arrays;
import java.util.*;

public class KthMaxAndMin {
    public static void main(String[] args){
        int k=3;
        int[] arr= {6,4,2,5,7,3,1};
        //Find third min and third max elements;
        Arrays.sort(arr);
        System.out.println("kth min= " + arr[k-1]);
        System.out.println("kth max= " + arr[arr.length-k]);
    }
}
