package PracticeQuestions.LeetCode.Matrix;

public class DiffBwOnes_ZerosinRow_Col {

    //LeetCode Q)2482

    public static void main(String[] args){
        int[][] grid= {{0,1,1},{1,0,1},{0,0,1}};

        int n = grid.length;
        int m = grid[0].length;
        int[] row = new int[n];
        int[] col = new int[m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                grid[i][j] = 2*(row[i] + col[j]) -(m+n);
            }
        }

        //return grid;
    }
}
