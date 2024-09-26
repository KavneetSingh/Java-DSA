package PracticeQuestions.LeetCode.Arrays;

public class ElementAppearingMoreThan25percInSortedArray {
    //LeetCode Q)1287  🔥
    public static void main(String[] args){

        int arr[]= {1,2,2,6,6,6,6,7,10};

        int jmp= arr.length/100;
        jmp= Math.max(jmp,1);
        int ansLen= arr.length/4;
        ansLen/=jmp;
        // if(arr.length%4!=0) ansLen++;

        System.out.println(arr.length);
        System.out.println(jmp);
        System.out.println(ansLen);
        System.out.println();

        int freq=0;
        int prev=-1;
        int pot= -1;
        for(int i=0;i<arr.length;i=i+jmp){
            if(arr[i]>prev)   freq=0;
            freq++;
            prev= arr[i];
            if(freq>= ansLen) pot= prev;
            if(freq>ansLen) break;
        }
        if(pot>-1){
            System.out.println(pot);
        }
        else{
            System.out.println(prev);
        }
    }
}
