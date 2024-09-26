package PracticeQuestions.LeetCode.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int arr[], int target){
        if(arr.length==0){
            return new int[]{-1,-1};
        }
        int start= 0;
        int end= arr.length-1;
        int mid= (start+end)/2;

        while(arr[mid]!=target && start<mid && mid<=end && start<end){
            if(arr[start]== target || arr[end]== target){
                break;
            }
            if(arr[mid]> target){
                end= mid;
            }
            else{
                start=mid;
            }
            mid= (start+end)/2;
        }

        int currIdx= -1;
        if(arr[end]==target) currIdx= end;
        else if(arr[mid]==target) currIdx= mid;
        else if(arr[start]==target) currIdx= start;

        start= currIdx;
        while(start>0 && arr[start-1]== target){
            start--;
        }
        end= currIdx;
        while(end<arr.length-1 && arr[end+1]== target){
            end++;
        }

        return new int[]{start,end};

    }
    public static void main(String[] args){
        int arr[]= {5,7,7,8,8,9,10};
        int target= 8;
        int res[]= searchRange(arr, target);
        System.out.println("start= " + res[0]);
        System.out.println("end= " + res[1]);
    }
}
