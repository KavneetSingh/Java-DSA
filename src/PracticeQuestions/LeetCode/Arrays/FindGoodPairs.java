package PracticeQuestions.LeetCode.Arrays;
import java.util.*;

public class FindGoodPairs {
    //LeetCode Q) 1512
    // A pair is good if you can map 2 elements in an array with equal value.

    public static int goodPairs(int arr[]){
        HashMap<Integer, Integer> hm= new HashMap<>();

        int ans=0;

        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int x= hm.get(arr[i]);
                ans+= x;
                hm.put(arr[i], x+1);
            }
            else{
                hm.put(arr[i], 1);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int arr[]= {1,2,3,1,1,3};

        System.out.println(goodPairs(arr));
    }
}
