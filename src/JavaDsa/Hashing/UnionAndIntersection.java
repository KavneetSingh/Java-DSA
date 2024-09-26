package JavaDsa.Hashing;
import java.util.*;

public class UnionAndIntersection {
    public static void main(String[] args){
        int arr1[]= {7,3,9};
        int arr2[]= {6,3,9,2,9,4};

        //union of 2 sets
        HashSet<Integer> union= new HashSet<>();

        for(int i=0; i<arr1.length;i++){
            union.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            union.add(arr2[i]);
        }

        System.out.println(union.size());
        System.out.println(union);

        //intersection of 2 sets
        HashSet<Integer> set1= new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set1.add(arr1[i]);
        }
        HashSet<Integer> intersection= new HashSet<>();
        // you wouldn't have to use this HashSet if you were to print only the no. of common elements in the two sets
        //instead of creating a new hashSet, create a variable count=0 and increment it when you find a common element
        //b/w the arr2 and set1
        for(int i=0;i<arr2.length;i++){
            if(set1.contains(arr2[i])){
                intersection.add(arr2[i]);
            }
        }
        System.out.println(intersection.size());
        System.out.println(intersection);
    }
}
