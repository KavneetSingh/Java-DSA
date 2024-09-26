package ApnaCollegeDSASheet.Arrays;

public class SearchInRotatedSortedArray {
    /*
    There is an integer array nums sorted in ascending order (with distinct values).

    Prior to being passed to your function, nums is possibly rotated at an unknown pivot
     index k (1 <= k < nums.length) such that the resulting array is
     [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
    For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

    Given the array nums after the possible rotation and an integer target,
    return the index of target if it is in nums, or -1 if it is not in nums.

    You must write an algorithm with O(log n) runtime complexity.
     */
    public static void main(String[] args){
//        int[] arr={4,5,6,7,0,1,2};
//        int target= 3;
//        int[] arr={4,5,6,7,0,1,2};
//        int target= 3;             //return -1
//        int[] arr={1};
//        int target= 3;
//        int[] arr={4,5,6,7,8,1,2,3};
//        int target= 8;
        int[] arr={5,1,2,3,4};
        int target= 1;

        int start= 0;
        int end= arr.length-1;
        int mid= (start+end)/2;
//        System.out.println(mid + " here");
        boolean done= false;
        if(arr[start]== target){
            System.out.println(start);
            done= true;
        }
        else if(arr[end]== target){
            System.out.println(end);
            done= true;
        }
        else if(arr[mid]== target){
            System.out.println(mid);
            done= true;
        }
        int count=0;

        while(!done && arr[mid]!= target  && count<= Math.pow(Math.log(arr.length),2)){

//            if(end== mid || mid== start){
//                System.out.println("-1");
//                break;
//            }

            if(arr[end]> arr[start] && arr[mid]> arr[start] && arr[mid]< arr[end]){          //Normal binary search
                if(target> arr[mid]){
                    start= mid;
                }
                else{
                    end= mid;
                }
            }

            else if(arr[end]< arr[start]){
                if(arr[mid] < arr[start]){            //mid lies on or right to pivot.
                    if(target< arr[mid] && target<arr[end]){
                        end= mid;
                    }
                    else if(target< arr[mid]){
                        end= mid;
                    }
                    else if(target> arr[mid] && target> arr[start]){
                        end= mid;
                    }
                    else{
                        start= mid;
                    }
                }
                else if(arr[mid]> arr[start]){        //mid lies left of pivot.
                    if(target> arr[mid]){
                        start= mid;
                    }
                    else if(target<arr[mid] && target< arr[end]){
                        start= mid;
                    }
                    else{
                        end= mid;
                    }
                }


            }

            mid= (start+end)/2;
            System.out.println(mid + " now");
            count++;

//            if(target<arr[start] && target< arr[mid]){
//                if(target< arr[mid]){
//                    end= mid;
//                }
//                else if(target > arr[mid]){
//                    start= mid;
//                }
//
//            }
//            else if(target> arr[end]){
//                if(target < arr[mid]){
//                    end= mid;
//                }
//                else if(target > arr[mid]){
//
//                }
//            }
        }
        if(count>= Math.log(arr.length)*2){
            System.out.println("-1");
        }
        else if(!done){
            System.out.println(mid);
        }

    }
}
