package JavaDsa.Hashing;
import java.util.*;
public class LargestSubArrayWithSumZero {
    public static void main(String[] args){
        int arr[]= {15, -2, 2, -8, 1, 7, 10};
        int sum=0;
//        int start;
//        int end;
        int size=0;
        HashMap<Integer, Integer> hm= new HashMap<>();
        for(int i=0;i<arr.length;i++){
            sum+= arr[i];
            if(hm.containsKey(sum)){
                size= Math.max(i- hm.get(sum), size);
            }
            else{
                hm.put(sum,i);
            }

        }
        System.out.println(size);
    }
}
