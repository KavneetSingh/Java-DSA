package PracticeQuestions.LeetCode.Arrays;

public class CouplesHoldingHands {

    //LeetCode Q) 765
    // Find the minimum no
    public static int minSwaps(int arr[]){
        int swaps= 0;
        int[] pos= new int[arr.length];

        for(int i=0;i<arr.length;i++){
            pos[arr[i]]= i;
        }
//        for(int i=0;i<arr.length;i++){
//            System.out.print(pos[i]+ " ");
//        }
//        System.out.println();
//        System.out.println();

        for(int i=0;i<arr.length;i++){
            if(i%2==0){
                continue;
            }

            int prev= arr[i-1];
            int currIdx;
            if((prev&1)==1){            //prev== odd
                if(arr[i]== prev-1){    //couple already placed correctly
                    continue;
                }
                currIdx= pos[prev-1];
            }
            else{
                if(arr[i]==prev + 1){     //couple already placed correctly but reversed. Still they are a couple right?
                    continue;
                }
                currIdx= pos[prev+1];
            }

            //swap the right partner according to the left one.
            //if the loop is still continued that means they don't form a couple or the couple is not good;

            int swapper= arr[i];
            arr[i]= arr[currIdx];
            pos[arr[i]]= i;
            arr[currIdx]= swapper;
            pos[swapper]= currIdx;
            swaps++;

//            System.out.println(i);
//            for(int j=0;j<arr.length;j++){
//                System.out.print(arr[j] +" ");
//            }
//            System.out.println();

        }

        return swaps;
    }

    public static void main(String[] args){
//        int arr[]= {0,6,1,3,4,2,5,7};
        int arr[]= {0,2,5,3,4,6,1,7};
        System.out.println(minSwaps(arr));
    }
}
