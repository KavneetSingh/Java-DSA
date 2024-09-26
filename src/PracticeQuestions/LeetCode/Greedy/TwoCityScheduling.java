package PracticeQuestions.LeetCode.Greedy;
import java.util.*;

public class TwoCityScheduling {

    //LeetCode Q)1029;  🔥🔥
    public static void main(String[] args){
        int[][] costs= {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        Arrays.sort(costs, (a,b)-> Integer.compare(a[0]-a[1], b[0]-b[1]));   //Very imp
        int ans=0;
        int n= costs.length/2;
        for(int i=0;i<costs.length;i++){
            if(i<n){
                ans+= costs[i][0];
            }
            else{
                ans+= costs[i][1];
            }
        }

        System.out.println(ans);
    }
}
