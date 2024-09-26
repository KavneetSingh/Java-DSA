package JavaDsa.Hashing;
import java.util.HashSet;

public class CountDistinctElements {
    public static void main(String[] args){  //find the total no. of distinct elements
        int arr[]= {3,4,2,5,6,7,4,3,1,2};
        HashSet<Integer> hs= new HashSet<>();

        for(int i=0;i<arr.length;i++){
            hs.add(arr[i]);
        }
        System.out.println(hs.size());
    }
}
