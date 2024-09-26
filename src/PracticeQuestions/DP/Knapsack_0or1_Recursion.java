package PracticeQuestions.DP;

public class Knapsack_0or1_Recursion {

    public static int knapsack(int wt[], int val[], int Wt, int curr){
        if(Wt==0 || curr==0){
            return 0;
        }

        if(wt[curr]<= Wt){
            int ans1= val[curr] + knapsack(wt, val, Wt-wt[curr], curr-1);
            int ans2= knapsack(wt, val, Wt, curr-1);
            return Math.max(ans1, ans2);
        }
        else{
            return knapsack(wt, val, Wt, curr-1);
        }

    }

    public static void main(String[] args){
        int weight[]= {2,5,1,3,4};
        int value[]= {15,14,10,45,30};
        int maxWt= 7;

        int ans= knapsack(weight, value, maxWt, value.length-1);
        System.out.println(ans);
    }
}
