package Greedy_algorithms;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequencing {
    static class Job{
        int deadline;
        int profit;
        int id;

        public Job(int i, int d, int p){
            id=i;
            deadline= d;
            profit=p;
        }
    }

    public static void main(String[] args){
        int jobsInfo[][]= {{4,20},{1,10},{1,40},{1,30}};

        ArrayList<Job> jobs= new ArrayList<>();

        for(int i=0;i< jobsInfo.length;i++){
            Job j= new Job(i,jobsInfo[i][0], jobsInfo[i][1]);
            jobs.add(j);
        }

        Collections.sort(jobs, (obj1, obj2)-> obj2.profit- obj1.profit);

        ArrayList<Integer> seq= new ArrayList<>();

        int time=0;
        for(int i=0;i<jobs.size();i++){
            Job curr= jobs.get(i);
            if(curr.deadline> time){
                seq.add(curr.id);
                time++;
            }
        }

        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }
}
