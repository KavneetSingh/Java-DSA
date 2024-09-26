package PracticeQuestions.LeetCode.Arrays;
import java.util.*;

public class ConvertArrayInto2DArrayWithConditions {
    //LeetCode question 2610

    public static List<List<Integer>> findMatrix(int arr[]){

        int hash[]= new int[arr.length+1];
        List<List<Integer>> list= new ArrayList<>();
        if(arr.length==0){
            return list;
        }

        int max= 0;
        for(int i=0;i<arr.length;i++){
            hash[arr[i]]++;
            max= Math.max(max, hash[arr[i]]);
        }

//        for(int i=0;i<hash.length;i++){
//            System.out.print(hash[i] + " ");
//        }
//        System.out.println();

        for(int i=0;i<max;i++){
            list.add(i, new ArrayList<>());
        }

        for(int i=0;i<arr.length+1;i++){
            if(hash[i]==0){
                continue;
            }
            while(hash[i]>0){
                list.get(hash[i]-1).add(i);
                hash[i]--;
            }
        }
        return list;

    }

    public static void main(String[] args){
//        int arr[]= {1,3,4,1,2,3,1};
        int arr[]= {4,5,3,3,3};
        System.out.println(findMatrix(arr));
    }
}
