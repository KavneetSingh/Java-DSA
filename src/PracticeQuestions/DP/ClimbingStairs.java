package PracticeQuestions.DP;
public class ClimbingStairs {


    public static void main(String[] args){
        //Find the number of ways to get to a particular step in a stair from ground when you can climb either 1 or 2 steps at a time
        //similar to fibonacci
        int N= 6;
        int arr[]= new int[N+1];
        arr[0]= 1;
        arr[1]= 1;

//        int ans= tabulation(arr);          //Write this yourself

        for(int i=2;i<N+1;i++){
            arr[i]= arr[i-1]+ arr[i-2];
            System.out.print(arr[i]+" ");
        }

    }
}
