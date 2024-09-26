package ApnaCollegeDSASheet.Arrays;

public class MaxSubarray {
    //Find the max sum of subarray (subarray: a continuous part of an array)
    public static void main(String[] args){
//        int arr[]= {-2,1,-3,4,-1,2,1,-8,4};    //ans= 6;
//        int arr[]= {5,4,-1,7,8};                // ans= 23;
//        int arr[]= {1};                           //ans = 1;
//        int arr[]= {-1};                        //ans= -1;
//        int arr[]= {-3,-2,-5,-2};                 //ans= -2
//        int arr[]= {-3,-2,0,2,-1,4};              //ans= 5;
//        int arr[]= {-1,1,-1,1,-1,1};                 //ans= 1;
//        int arr[]= {-1,0};                          //ans= 0;
        int arr[]= {1, 1, -2};                     //ans= 2;



//        int arr[]= {0,-3,1,1};
//        int maxInt= Integer.MIN_VALUE;
//        int[] leftSum= new int[arr.length];
//        int sum= 0;
//        int min= Integer.MAX_VALUE;
//        int max= Integer.MIN_VALUE;
//        int ans=0;
//        int maxIdx= -1;
//        int minIdx= -1;
//
//        for(int i=0;i<arr.length;i++){
//            maxInt= Math.max(maxInt, arr[i]);
//            sum+= arr[i];
//            leftSum[i]= sum;
//            if(min> leftSum[i]){
//                min= leftSum[i];
//                minIdx= i;
//            }
//            if(max <= leftSum[i]){
//                max= leftSum[i];
//                maxIdx= i;
//            }
//            if(maxIdx>= minIdx){
//                if(min>=0){
//                    ans= max;
//                }
//                else{
//                    ans= max-min;
//                }
//            }
//
//        }
//        System.out.println("max= " + max);
//        System.out.println("min= " + min);
//
//        if(max<=0){
//            if(ans>0){
//                System.out.println(Math.max(maxInt, ans));
//            }
//            else{
//                System.out.println(maxInt);
//            }
//            System.out.println("2");
//        }
//
//        else if(maxIdx==minIdx){
//            System.out.println(max);
//            System.out.println("1");
//        }
//
//        else if(min>0){
//            System.out.println(max);
//            System.out.println("3");
//        }
//
////        else if(ans>=0){
////            System.out.println(ans);
////        }
//
//        else{
//            System.out.println(ans);
//            System.out.println("4");
//        }


        int maxInt= arr[0];
        int currSum= Integer.MIN_VALUE;
        int maxSum= Integer.MIN_VALUE;

        for(int i=0;i< arr.length;i++){
            if(currSum== Integer.MIN_VALUE){
                currSum= arr[i];
            }
            else{
                currSum += arr[i] ;
            }
            maxInt= Math.max(maxInt, arr[i]);


            if(currSum<0){
                currSum= 0;
            }
            maxSum= Math.max(currSum, maxSum);
        }
        if(maxSum <=0){
            System.out.println(maxInt);
        }
        System.out.println(maxSum);

    }
}
