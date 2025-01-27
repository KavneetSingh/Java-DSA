public class NQueens {
    static int count=0;
    public static void nQueens(char board[][],int row){
        if(row==board.length){
            System.out.println("----- Solution -----");
            count++;
            System.out.println( count );
            printBoard(board);
            return;
        }
        for(int i=0;i< board.length;i++){
            if(isSafe(board,row,i)){
                board[row][i]= 'Q';
                nQueens(board, row+1);
                board[row][i]='.';
            }
        }
    }

    public static Boolean isSafe(char board[][], int row,int col){
        // vertical up
        for(int i=0;i<=row-1;i++){
            if(board[i][col]== 'Q'){
                return false;
            }
        }

        // diagonal left up
        for(int i=row-1, j=col-1;i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        // diagonal right up
        for(int i=row-1, j=col+1; i>=0 && j< board.length;i--,j++){
            if(board[i][j]== 'Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j] +" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        int N=4;
        char ChessBoard[][]= new char[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                ChessBoard[i][j]= '.';
            }
        }

        nQueens(ChessBoard, 0);
    }
}
