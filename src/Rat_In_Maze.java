import java.util.*;

public class Rat_In_Maze {

    public static void printSoln(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(" "+ arr[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int x, int y){
        return (x>=0 && x<maze.length && y>=0 && y<maze.length && maze[x][y]==1);
    }

    static int count=0;
    public static void Ways(int arr[][],int x, int y){
        if(x== arr.length || y== arr.length){

        }

    }

    public static boolean solveMaze(int maze[][]){
        int N= maze.length;

        int soln[][]= new int[N][N];

        if(solveMazeUtil(maze, 0, 0, soln)== false){
            System.out.println("The solution to this maze does not exist");
            return false;
        }
        printSoln(soln);
        return true;
    }

    public static boolean solveMazeUtil(int maze[][], int x, int y, int soln[][]){
        if(x== maze.length-1 && y== maze.length-1 && maze[x][y]==1){
            soln[x][y]=1;
            return true;
        }
        if(isSafe(maze, x,y)){
            if(soln[x][y] ==1){
                return false;
            }

            soln[x][y]=1;
            if(solveMazeUtil(maze, x+1 ,y,soln)){
                return true;
            }
            if(solveMazeUtil(maze,x,y+1,soln)){
                return true;
            }
            soln[x][y]=0;
            return false;
        }

        return false;
    }

    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int N= 4;
        int maze[][]= new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                maze[i][j]= sc.nextInt();
            }
        }

        solveMaze(maze);
    }
}
