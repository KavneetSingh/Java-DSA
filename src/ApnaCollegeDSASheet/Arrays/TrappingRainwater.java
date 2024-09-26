package ApnaCollegeDSASheet.Arrays;

public class TrappingRainwater {
    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
     compute how much water it can trap after raining.
     */
    public static void main(String[] args){
//        int arr[]= {4,2,0,6,3,2,5};               //ans=11;
//        int arr[]= {0,1,0,2,1,0,1,3,2,1,2,1};     //ans= 6;
        int arr[]= {4,2,0,3,2,5};                   //ans= 9;
        int[] leftHigh= new int[arr.length];
        int[] rightHigh= new int[arr.length];

        leftHigh[0]= arr[0];
        rightHigh[rightHigh.length-1]= arr[arr.length-1];

        int currHigh= arr[0];

        for(int i=0;i<leftHigh.length;i++){             //calculating the left highest walls for all the elements
            if(arr[i] >= currHigh){
                currHigh= arr[i];
            }
            leftHigh[i]= currHigh;
        }

        currHigh= arr[arr.length-1];

        for(int i=arr.length-1;i>=0;i--){               //calculating the right highest walls for all the elements
            if(arr[i]> currHigh){
                currHigh= arr[i];
            }
            rightHigh[i]= currHigh;
        }

        int ans= 0;
        for(int i=0;i<arr.length;i++){
            int minWall= Math.min(leftHigh[i], rightHigh[i]);
            if(minWall- arr[i]>0){
                ans+= minWall- arr[i];
            }
        }
        System.out.println(ans);
    }
}
