package ApnaCollegeDSASheet.Arrays;

public class ContainerWithMaxWater {
    /*
    You are given an integer array height of length n. There are n vertical lines drawn such that
     the two endpoints of the ith line are (i, 0) and (i, height[i]).

    Find two lines that together with the x-axis form a container, such that the container contains the most water.

    Return the maximum amount of water a container can store.

    Notice that you may not slant the container.
     */
    public static void main(String[] args){
//        int arr[]= {1,8,6,2,5,4,8,3,7};          //ans= 49;
//        int arr[]= {1,1};                       //ans= 1;
        int arr[]= {1,3,2,5,25,24,5};             //ans= 24;
        int i= 0;
        int j= arr.length-1;

        int max= -1;

        for(int k=0;k<arr.length;k++){


            System.out.println("i= " + i + "; j= " +j);
            int currVolume= Math.min(arr[i], arr[j]) * (j-i);
            max= Math.max(max, currVolume);

            if(arr[i]< arr[j]){
                i++;
            }
            else{
                j--;
            }
//
//            if(i+1<j && arr[i]< arr[j] && arr[i+1]> arr[i]){
//                i++;
//            }
//            else if(j-1>i && arr[i]> arr[j] && arr[j-1]> arr[j]){
//                j--;
//            }
//            else if(arr[i]== arr[j]){
//                if(i+1< arr.length  && j-1>=0 && arr[i+1]> arr[j-1]){
//                    i++;
//                }
//                else if(j-1>=0){
//                    j--;
//                }
//            }
//            else{
//                if(i+1< arr.length  && j-1>=0 && arr[i+1]> arr[j-1]){
//                    i++;
//                }
//                else if(j-1>=0){
//                    j--;
//                }
//            }
        }

        System.out.println(max);
    }
}
