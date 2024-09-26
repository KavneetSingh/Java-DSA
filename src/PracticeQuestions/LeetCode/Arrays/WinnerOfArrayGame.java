package PracticeQuestions.LeetCode.Arrays;

public class WinnerOfArrayGame {

    //LeetCode Q) 1535
    public static void main(String[] args){
        int arr[]= {2,1,3,5,4,6,7};
        int k= 2;

        int wins=0;
        int currWinner= -1;
        int i=0;
        int j=1;
        // int max= arr[0];
        while(wins<k){
            if(j<i){
                break;
            }
            if(wins==arr.length){
                break;
            }
            int a=arr[i];
            int b= arr[j];
            if(a>=b){
                wins++;
                currWinner= a;
                j= (j+1)%arr.length;
            }
            else{
                wins=1;
                currWinner= b;
                i=j;
                j= (j+1)%arr.length;
            }
        }

        System.out.println(currWinner);
    }
}
