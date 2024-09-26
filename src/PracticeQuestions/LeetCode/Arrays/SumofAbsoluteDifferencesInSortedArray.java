package PracticeQuestions.LeetCode.Arrays;

public class SumofAbsoluteDifferencesInSortedArray {
    //LeetCode Q)1685

    public static void main(String[] args){

        int nums[]= {1,4,6,8,10};

        int prevSum=0;
        int totalSum=0;

        for(int i=0;i<nums.length;i++){
            totalSum+= nums[i];
        }

        for(int i=0;i<nums.length;i++){
            prevSum+= nums[i];
            nums[i]= ((i+1)*nums[i] - prevSum) + (totalSum-prevSum - (nums.length-i-1)*nums[i]);
            System.out.print(nums[i] + " ");
        }
    }
}
