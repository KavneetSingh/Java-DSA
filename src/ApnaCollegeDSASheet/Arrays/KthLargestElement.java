package ApnaCollegeDSASheet.Arrays;
import java.util.*;

import javax.swing.text.html.HTMLDocument;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class KthLargestElement {
    public static void main(String[] args){
        int arr[]= {3,2,3,1,2,4,5,5,6};
        int k=2;
//
//        boolean larger[]= new boolean[arr.length];
//        int currMax= Integer.MIN_VALUE;
//        int maxInd= -1;
//
//        for(int i=0;i<k;i++){
//            currMax=Integer.MIN_VALUE;
//            for(int j=0;j<arr.length;j++){
//                if(!larger[j]){
//                    if(arr[j]>= currMax){
//                        currMax= arr[j];
//                        maxInd= j;
//                    }
//                }
//            }
//            larger[maxInd]= true;
//            if(i==k-1){
//                System.out.println(currMax);
//            }
//        }

//        TreeSet<Integer> hs= new TreeSet<>();       //it stores in a sorted format;
//
//        for(int i=0;i<arr.length;i++){
//            hs.add(arr[i]);
//        }
//
//        Iterator<Integer> itr= hs.iterator();
//
//        while(k>0){
//            itr.next();
//            k--;
//        }
//        System.out.println(itr.next());

//        int[] arr = { 12, 3, 5, 7, 19 };
//        int N = arr.length;
//        int K = 4;

        // since counting starts from 0 so to find kth
        // element we need to reduce K by 1
        k--;

        // for storing elements in sorted form
        // in set we will use TreeSet
        Set<Integer> s = new TreeSet<Integer>();

        // Adding elements to set
        for (int i = 0; i < arr.length; i++)
            s.add(arr[i]);

        // Use iterator method of Iterator
        // for the traversal
        Iterator<Integer> itr = s.iterator();

        while (k > 0) {
            itr.next();
            k--;
        } // itr points to the Kth element in the set

        System.out.println(itr.next());

    }
}
