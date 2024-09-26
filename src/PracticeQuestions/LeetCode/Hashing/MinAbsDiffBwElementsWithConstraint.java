package PracticeQuestions.LeetCode.Hashing;
import java.util.*;

public class MinAbsDiffBwElementsWithConstraint {
    //LeetCode Q)2817  🔥
    //You could not solve it using basic binary search
    // You also learnt that priority queue can only remove elements in sorted or prioritised manner, but
    // it does not store them in sorted format. If you call pq.toArray(), the resulting array is not sorted.

    public static void main(String[] args){
        int arr[]= {61,85,196,17,86,35,27,13};
        int x= 1;

        List<Integer> nums= new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            nums.add(arr[i]);
        }

        int ans = Integer.MAX_VALUE;
        TreeSet<Integer> s = new TreeSet<>();
        for(int i = x; i < nums.size(); ++i){
            s.add(nums.get(i-x));
            Integer high = s.ceiling(nums.get(i)), low = s.floor(nums.get(i));
            if(high != null) ans = Math.min(ans, Math.abs(nums.get(i) - high));
            if(low != null) ans = Math.min(ans, Math.abs(nums.get(i) - low));
        }
        System.out.println(ans);
    }
}
