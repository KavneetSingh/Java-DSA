package PracticeQuestions.LeetCode.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByNoOf1Bits {

    //LeetCode Q)1356

    public static void main(String[] args){
        int arr[] = {0,1,2,3,4,5,6,7,8};
//        int arr[]= {1024,512,256,128,64,32,16,8,4,2,1};
        Arrays.sort(arr);

//        ArrayList<Integer> al= new ArrayList<>();

        ArrayList<Integer>[] bits= new ArrayList[14];
        //question had a range of 0<=arr[i]<=10000  so 14 set bits can be there

        for(int i=0;i<bits.length;i++){
            bits[i]= new ArrayList<Integer>();
        }

        for(int i=0;i<arr.length;i++){
            int setBits= 0;
            int curr= arr[i];
            while(curr>0){
                if((curr & 1)==1)  setBits++;
                curr = curr>>1;
            }
//            System.out.println(setBits);
            bits[setBits].add(arr[i]);
        }


        int x=0;
        for(int i=0;i<bits.length;i++){
            for(int j=0;j<bits[i].size();j++){
                arr[x] = bits[i].get(j);
                System.out.print(arr[x] + " ");
                x++;
            }
        }
    }
}
