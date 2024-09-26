package Greedy_algorithms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String[] args){
        int start[]= {1,3,0,5,8,5};
        int end[]= {2,4,6,7,9,9};

        //if we are given unsorted array then sort using 2D array
        int activities[][]= new int[end.length][3];
        for(int i=0;i<end.length;i++){
            activities[i][0]=i;
            activities[i][1]= start[i];
            activities[i][2]= end[i];
        }

        //lambda function to sort 2D array on the basis of activities[][2]
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

        // these are given start and end times for various activities to be done by the person and he needs to select the most no.
        // activities he can perform. we are also already given sorted end times which already solves a lot of use cases
        int maxAct=0;
        ArrayList<Integer> ans= new ArrayList<>();
        maxAct=1;
        ans.add(activities[0][0]);
        int lastEnd= activities[0][2];
        for(int i=1;i<end.length;i++){
            if(activities[i][1]>= lastEnd){
                //select the activity
                ans.add(activities[i][0]);
                maxAct++;
                lastEnd= activities[i][2];
            }
        }
        System.out.println(maxAct);
        System.out.println(ans);
    }
}
