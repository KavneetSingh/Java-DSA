package ApnaCollegeDSASheet.Arrays;

public class BuySellStocks {
    /*
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a
     different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.


     */
    public static void main(String[] args){
        int arr[]= {7,1,5,3,6,4};   //ans= 5;
//        int[] arr= {7,6,4,3,1};       //ans= 0;


        int ans= -1;

        //Solution 1:       O(n) && O(n)

//        int[] leftHigh= new int[arr.length];
//        int max= arr[arr.length-1];

//        for(int i=arr.length-1;i>=0;i--){
//            max= Math.max(max, arr[i]);
//            leftHigh[i]= max;
//            ans= Math.max(ans, leftHigh[i]- arr[i]);
//        }
//
//        if(ans<0){
//            System.out.println(0);
//        }
//        else{
//            System.out.println(ans);
//        }

        //Solution 2:             O(n) && O(1)

        int min= arr[0];
//        int max= arr[0];
        for(int i=0;i<arr.length;i++){
//            if(arr[i]>= max){
//                max= arr[i];
//            }

            ans= Math.max(ans, arr[i]-min);

            min= Math.min(arr[i], min);
        }

        if(ans<0){
            System.out.println(0);
        }
        else{
            System.out.println(ans);
        }
    }
}
