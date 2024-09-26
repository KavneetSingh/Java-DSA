package PracticeQuestions.DP;
import java.util.*;

public class NumberOfBSTs_Tabulation {

    //You are given an integer x denoting the number of nodes or an array with values of nodes.
    // If array is given find the number of elements in array.
    // Then calculate the number of BST possible for the number of nodes.
    //Magically the number of nodes come out to be same as Catalan's number for the number of nodes.
    //The number of BSTs can be calculated as eg- x=4, the number of BST would be

    /*
            O                    O                       O                     O
          /  \           +      / \              +      / \         +        /   \
   0 nodes      3 nodes    3 nodes  0 node       2 nodes   1 node       1 node    2 nodes

   now, find the number of BSTs of having 3 nodes and 2 nodes. For 1 node, there is only 1 BST possible and for 0 as well.
     */

    public static int tabulation(int[] dp){
        dp[0]= dp[1]= 1;

        for(int i=2;i<dp.length;i++){
            int ans=0;
            for(int j=0;j<i;j++){
                ans+= dp[j] * dp[i-j-1];
            }
            dp[i]= ans;
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args){
        int x= 5;
//        int arr[]= {10,20,30,40,50};
//        int x= arr.length;

        int dp[]= new int[x+1];

        Arrays.fill(dp, -1);

        int ans= tabulation(dp);
        System.out.println(ans);


        System.out.println();
        System.out.println();

        for(int i=0;i<dp.length;i++){
            System.out.print(dp[i] + " ");
        }
    }
}
