package PracticeQuestions.LeetCode.Arrays;

public class MinAmtOfTimeToCollectGarbage {
    public static void main(String[] args){
        String[] garbage= {"G","P","GP","GG"};
        int[] travel = {2,4,3};

        int currDist[]= new int[3];    //store the time needed to reach curr destination MPG
        int timeWorked[]= new int[3];  //store the time they have already worked for in seq- MPG

        int j=0;
        int i=0;

        for(i=0;i<garbage.length;i++){
            for(j=0;j<garbage[i].length();j++){
                char ch= garbage[i].charAt(j);

                switch(ch){
                    case 'M':
                        timeWorked[0]+= currDist[0];
                        timeWorked[0]++;
                        currDist[0]= 0;
                        break;

                    case 'P':
                        timeWorked[1]+= currDist[1];
                        timeWorked[1]++;
                        currDist[1]= 0;
                        break;

                    case 'G':
                        timeWorked[2]+= currDist[2];
                        timeWorked[2]++;
                        currDist[2]= 0;
                        break;
                }
            }

            if(i<travel.length){
                currDist[0]+= travel[i];
                currDist[1]+= travel[i];
                currDist[2]+= travel[i];
            }
        }

//        System.out.println(timeWorked[0]);
//        System.out.println(timeWorked[1]);
//        System.out.println(timeWorked[2]);
        System.out.println(timeWorked[0] + timeWorked[1] + timeWorked[2]);
    }
}
