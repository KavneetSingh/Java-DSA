package PracticeQuestions.LeetCode.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorityElement2 {
    //LeetCode Q) 229

    public static List<Integer> majorityElement(int arr[]){
        int base= arr.length/3;
        List<Integer> ans= new ArrayList<>();

        HashMap<Integer, Integer> hm= new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(hm.containsKey(arr[i])){
                int x= hm.get(arr[i]);
                hm.put(arr[i], x+1);
                if(x+1==base+1){
                    ans.add(arr[i]);
                }
            }
            else{
                hm.put(arr[i],1);
                if(base==0){
                    ans.add(arr[i]);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args){
        int arr[]= {3,2,3};

        System.out.println(majorityElement(arr));

    }
}
