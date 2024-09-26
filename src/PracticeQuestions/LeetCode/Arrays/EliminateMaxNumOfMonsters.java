package PracticeQuestions.LeetCode.Arrays;
import java.util.*;


public class EliminateMaxNumOfMonsters {

    //LeetCode Q)1921

    public static void main(String[] args){
        int dist[]= {3,2,4};
        int speed[]= {5,3,2};

        int time[]= new int[dist.length];
        for(int i=0;i<dist.length;i++){
            time[i]= dist[i]/speed[i];
            if(dist[i]%speed[i]>0) time[i]++;
        }

        Arrays.sort(time);

        int currTime=0;
        int ans=0;

        for(int i=0;i<time.length;i++){
            if(time[i]>currTime){
                ans++;
            }
            else{
                break;
            }
            currTime++;
        }

        System.out.println(ans);
    }
}
