package PracticeQuestions.LeetCode.Matrix;

public class LargestSubmatrixWithRearrangements {
    //LeetCode Q)1727

    public static void main(String[] args){

        int[][] matrix = {{0,0,1},{1,1,1},{1,0,1}};

        int dp[][]= new int[matrix.length][matrix.length];
        //not a dp but it stores the number of occurances of all 1's from i to j th cell in every column.
        //you can count the number of all ones in subarray from i to j and multiply it with j-i+1 to get the area.
        //this solution was using a lot of memory so had to use another solution.
        int ans= -1;
        for(int i=0;i<matrix[0].length;i++){
            boolean prevOne= false;
            int start= -1;
            for(int j=0;j<matrix.length;j++){
                if(!prevOne && matrix[j][i]==1){
                    start= j;
                    prevOne= true;
                }
                else if(!prevOne || matrix[j][i]==0){
//                    System.out.println(i  + " , " + j);
                    prevOne= false;
                }
                if(prevOne){
                    for(int k=start;k<=j;k++){
                        dp[k][j]++;
                        ans= Math.max(ans, dp[k][j]* (j+1-k));
                    }

//                    System.out.println( "true for: "+ i  + " , " + j + ".  start= " + start);

                }

            }
        }

//        for(int i=0;i<dp.length;i++){
//            for(int j=0;j<dp.length;j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(ans);
    }
}
