public class SudokuJava {

    public static void main(String[] args) {

        int[][] board = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };

        solveSudoku(board);

        for(int i=0 ;i<9;i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }


    }

    public static boolean solveSudoku(int [][] board) {

        for (int row = 0; row < 9; row++)
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == 0) {

                    for (int digit = 1; digit <= 9; digit++) {
                        if (isValid(board, row, col, digit)) {
                            board[row][col] = digit;

                            if (solveSudoku(board))
                                return true;
                            else
                                board[row][col] = 0;
                        }
                    }
                        return false;
                }


            }
        return true;
        }

    public static boolean isValid(int[][] board, int row, int col, int digit) {
        for(int i=0; i<9; i++) {

            if(board[row][i] == digit)
                return false;

            if(board[i][col] == digit)
                return false;

            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] ==digit)
                return false;
        }
        return true;
    }
}
