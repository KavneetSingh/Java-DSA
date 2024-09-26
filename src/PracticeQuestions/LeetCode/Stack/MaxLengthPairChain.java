package PracticeQuestions.LeetCode.Stack;

import java.util.*;

public class MaxLengthPairChain {
    public static void main(String[] args){
        int arr[][]= {{1,2}, {1,7}, {1,5}};
        Arrays.sort(arr, (a,b)-> a[1] - b[1]);

        int ans=0;
//        int nextStart= -1;
        int currEnd=arr[0][1];
        for(int i=0;i<arr.length;i++){
            if(currEnd< arr[i][0]){                                 //arr[i][1]< arr[i+1][0]
                ans++;
                System.out.println(currEnd +" < " + arr[i][0]);
                currEnd= arr[i][1];
            }
        }
        System.out.println(ans+1);
    }
}
