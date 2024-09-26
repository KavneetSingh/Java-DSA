package PracticeQuestions.LeetCode.DP;
import java.util.*;

public class MaxProfitJobScheduling {
    //LeetCode Q)1235
    static class job{
        int start;
        int end;
        int profit;

        public job(int s, int e, int p){
            this.start= s;
            this.end= e;
            this.profit= p;
        }

//        @Override
//        public int compare(job j1, job j2){
//            if(j1.start- j2.start== 0){
//                return j1.end- j2.end;
//            }
//            return j1.start- j2.start;
//        }

    }

//    class sortBysTime implements Comparator<job>{
//        public int compare(job j1, job j2){
//            if(j1.start- j2.start== 0)
//                return j1.end- j2.end;
//            return j1.start- j2.start;
//        }
//    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        job[] arr= new job[profit.length];
        int tEnd=0;
        for(int i=0;i<profit.length;i++){
            job a= new job(startTime[i], endTime[i], profit[i]);
            tEnd= Math.max(tEnd, endTime[i]);
            arr[i]= a;
        }

        Arrays.sort(arr, (a,b)-> a.end- b.end);
        Arrays.sort(arr, (a,b)-> a.start- b.start);


        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].start +" " + arr[i].end + " " + arr[i].profit);
        }

        int dp[][]= new int[arr.length+1][tEnd+1];

        for(int i=1;i<dp.length;i++){
            int end= arr[i-1].end;
            int start= arr[i-1].start;
            int p= arr[i-1].profit;
            for(int j=1;j<dp[0].length;j++){
                if(end==j){
                    int ans1= Math.max(dp[i-1][j], dp[i][j-1]);
                    int ans2= dp[i-1][start]+ p;
                    dp[i][j]= Math.max(ans1, ans2);
                }
                else{
                    dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args){
        int s[]= {1,2,3,4,6};
        int e[]= {3,5,10,6,9};
        int p[]= {20,30,100,70,60};

        System.out.println(jobScheduling(s,e,p));
    }
}
