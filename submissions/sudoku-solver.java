class Solution {
    public void solveSudoku(char[][] board) {
        backtrace(board, 0, 0);
    }

    private boolean backtrace(char[][] board, int i, int j) {
        if (j == 9) {
            return backtrace(board, i + 1, 0);
        }
        if (i == 9) {
            return true;
        }
        if (board[i][j] != '.') {
            return backtrace(board, i, j + 1);
        }
        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, i, j, c)) {
                continue;
            }

            board[i][j] = c;
            if (backtrace(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int l = 0; l < 9; l++) {
            if (board[i][l] == c ) {
                return false;
            }
            if (board[l][j] == c) {
                return false;
            }
            if (board[(i/3)*3 + l/3][(j/3)*3 + l%3] == c) {
                return false;
            }
        }
        return true;
    }
}