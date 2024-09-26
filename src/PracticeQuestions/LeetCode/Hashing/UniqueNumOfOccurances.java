package PracticeQuestions.LeetCode.Hashing;
import java.util.*;

public class UniqueNumOfOccurances {

    //LeetCode Q)1207

    public static void main(String[] args){
        int[] arr= {-3,0,1,-3,1,1,1,-3,10,0};
        HashMap<Integer, Integer> hm= new HashMap();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i], hm.getOrDefault(arr[i],0)+1);
        }

        Iterator<Integer> itr= hm.values().iterator();
        HashSet<Integer> hs= new HashSet<>();
        while(itr.hasNext()){
            int x= itr.next().intValue();
            if(hs.contains(x)){
                System.out.println(false);      //return false;
            }
            else hs.add(x);
        }
        System.out.println(true);              //iterated means completely done and return true;
    }
}
