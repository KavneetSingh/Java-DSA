package PracticeQuestions.LeetCode.Arrays;
import java.util.*;

public class MinOpToMakeContinuous {

    //LeetCode Q)2009

    public static int sortedMinOperations(int arr[]){

        Queue<Integer> q= new LinkedList<>();
        HashSet<Integer> hs= new HashSet<>();
        int maxEnqueued= 0;
        for(int i=0;i<arr.length;i++){
            while(!q.isEmpty() && arr[i]-q.peek()>=arr.length){
                q.remove();
            }
            if(hs.contains(arr[i])){
                continue;
            }
            q.add(arr[i]);
            hs.add(arr[i]);
            maxEnqueued= Math.max(maxEnqueued, q.size());
        }

        return arr.length-maxEnqueued;

    }
    public static int minOperations(int arr[]){
//        int maxContinuity=0;
//        int repetitions=0;
//        int contMax;
//        int contMin;
//        ArrayList<Integer> al= new ArrayList<>();      //contains all the other occurances of same length continuity
//        HashMap<Integer, Integer> hm= new HashMap<>();
//
//        for(int i=0;i<arr.length;i++){
//            if(hm.containsKey(arr[i])){
//                repetitions++;
//                continue;
//            }
//            //else
//            int lower=0;       //continuity in lower range
//            int higher=0;      //continuity in higher range
//            if(arr[i]> 0 && hm.containsKey(arr[i]-1)){
//                lower= hm.get(arr[i]-1);
//            }
//            if(hm.containsKey(arr[i]+1)){
//                higher= hm.get(arr[i]+1);
//            }
//            int contLen= lower+higher+1;
//            hm.put(arr[i],contLen);
//
//            if(contLen>maxContinuity){
//                al= new ArrayList<>();
//                contMax= arr[i]+ higher;
//                contMin= arr[i]- lower;
//                al.add(contMin);
//                maxContinuity= contMax-contMin+1;
////                System.out.println("cont min= " + contMin);
////                System.out.println("max continuity= " + maxContinuity);
//            }
//            else if(contLen==maxContinuity){
//                al.add(arr[i]- lower);
////                System.out.println(arr[i]-lower);
//            }
//
//        }
//
//
//        if(maxContinuity== arr.length){
//            return 0;
//        }
//
//        int maxCandidate= 0;
//        HashSet<Integer> hs;
//        for(int i=0;i<arr.length;i++){
//            hs= new HashSet<>();
//            int curr= arr[i];
//            int currMax= 0;
//            for(int j=curr;j<curr+arr.length;j++){
//                if(hm.containsKey(j) && !hs.contains(j)){
//                    currMax++;
//                    hs.add(j);
//                }
//            }
//            maxCandidate= Math.max(maxCandidate, currMax);
//        }
//        return arr.length- maxCandidate;

//
////        System.out.println(al.size());
//
//        int countInCont=0;     //stores the maximum no of elements that are in the continuous range;
//
//        HashSet<Integer> hs;
//        if(maxContinuity==1){
//            for(int i=0;i<arr.length;i++){
//                hs= new HashSet<>();
//                int currCount=0;
//                for(int j=arr[i];j<arr.length+arr[i];j++){
//                    if(hm.containsKey(j) && !hs.contains(j)){
//                        hs.add(j);
//                        currCount++;
//                    }
//                }
//                countInCont= Math.max(currCount, countInCont);
//            }
//            return arr.length- countInCont;
//        }
//
//
//        for(int i=0;i<al.size();i++){
//            hs= new HashSet<>();
//            int start= al.get(i);
//            int end= start+maxContinuity;
//            int currCount=0;
//            for(int j= start+maxContinuity; j<start + arr.length; j++){
//                if(hm.containsKey(j) && !hs.contains(j)){         //!hs.contains(j) checks for the repetition of elements
//                    hs.add(j);
//                    currCount++;
//                }
//            }
//            countInCont= Math.max(currCount, countInCont);
//        }
//        System.out.println("yes");
//        System.out.println(maxContinuity);
//        return arr.length- maxContinuity- countInCont;

        return 0;
    }

    public static void main(String[] args){
//        int arr[]= {1,2,3,5,6};          //ans==1
//        int arr[]= {1,10,18,12,17,15,11};     //ans== 3
//        int arr[]= {1,5,6,7,9,13,14,15};        //ans==4
        int arr[]= {41,33,29,33,35,26,47,24,18,28};  //ans==5
//        System.out.println(minOperations(arr));
        Arrays.sort(arr);
        System.out.println(sortedMinOperations(arr));
    }
}
