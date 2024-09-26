package ApnaCollegeDSASheet.Arrays;

public class MinInRotatedSortedArray {
    /*
    Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
     For example, the array nums = [0,1,2,4,5,6,7] might become:

    [4,5,6,7,0,1,2] if it was rotated 4 times.
    [0,1,2,4,5,6,7] if it was rotated 7 times.
    Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

    Given the sorted rotated array nums of unique elements, return the minimum element of this array.

    You must write an algorithm that runs in O(log n) time.
     */


    public static void main(String[] args){
//        int arr[]= {4,5,6,7,1,2,3};     //ans= 1;
//        int arr[]= {4,5,6,7,0,1,2};
        int arr[]= {11,13,15,17};
        int end= arr.length-1;
        int start= 0;
        int mid= (start+end)/2;
        boolean found= false;
        int min= Integer.MAX_VALUE;

        if(arr[start]<=arr[mid] && arr[mid]<=arr[end]){            //sorted non rotated array;
            System.out.println(arr[start]);     //ans
            found= true;
            min= arr[start];
        }


        while(!found){

            if( mid-1>= 0  &&   arr[mid] <arr[mid-1]){
                min= arr[mid];
                found= true;
            }

            if(arr[start] <= arr[mid]   &&   arr[mid]<= arr[end]){       //sorted sub-array
                if(start>0 && arr[start]< arr[start-1]){
                    min= arr[start-1];
                    found=true;
                }
                else if(arr[start]< arr[arr.length-1]){
                    end= start;
                    start= 0;
                }
                else{
                    start= end;
                    end= arr.length-1;
                }
            }

            else if(arr[start] <= arr[mid]   &&   arr[mid] >= arr[end]){        //mid lies on left of minimum element
                if(arr[mid+1] < arr[mid]){
                    min= arr[mid+1];
                    found= true;
                }
                else{
                    start= mid;
                }
            }

            else if(arr[mid]<= arr[start] && arr[mid]< arr[end]){
                end= mid;
            }
            mid= (start+end)/2;
        }

        System.out.println(min);
    }
}
