package PracticeQuestions.DP.Assignment;

public class BoxStacking {
    /*
    Given n cuboids where the dimensions of the ith cuboid is cuboids[i] = [width i, length i, height i]
    (0-indexed). Choose a subset of cuboids and place them on each other.

    You can place cuboid i on cuboid j if width i <= width j and length i <= length j
    and height i <= height j. You can rearrange any cuboid's dimensions by rotating it to put it on another cuboid.

Return the maximum height of the stacked cuboids.
     */

    public static void main(String[] args){
        int[][] arr= {{50,45,20},{95,37,53},{45,23,12}};
        int[][][] variations= new int[arr.length][6][3];

        for(int i=0;i<arr.length;i++){           //Creating variations
            int l= arr[i][0];
            int b= arr[i][1];
            int h= arr[i][2];


            variations[i][0][0]= l;   //1
            variations[i][0][1]= b;
            variations[i][0][2]= h;
            variations[i][1][0]= l;   //2
            variations[i][1][1]= h;
            variations[i][1][2]= b;
            variations[i][2][0]= b;   //3
            variations[i][2][1]= l;
            variations[i][2][2]= h;
            variations[i][3][0]= b;   //4
            variations[i][3][1]= h;
            variations[i][3][2]= l;
            variations[i][4][0]= h;   //5
            variations[i][4][1]= b;
            variations[i][4][2]= l;
            variations[i][5][0]= h;   //6
            variations[i][5][1]= l;
            variations[i][5][2]= b;

        }

        //Sort on the basis of area of base




    }
}
