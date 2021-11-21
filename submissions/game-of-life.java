class Solution {
    public static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] copy = new int[m][n];
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = getResult(copy, i, j);
            }
        }
    }

    private int getResult(int[][] copy, int x, int y) {
        int count = 0;
        for (int i = 0; i < DIRS.length; i++) {
            int cx = x + DIRS[i][0];
            int cy = y + DIRS[i][1];
            if (isValid(copy, cx, cy)) {
                count += copy[cx][cy];
            }
        }
        if (copy[x][y] == 1 && count >= 2 && count <= 3) {
            return 1;
        }
        if (copy[x][y] == 0 && count == 3) {
            return 1;
        }
        return 0;
    }

    private boolean isValid(int[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        return (x >= 0) && (x < m) && (y >= 0) && (y < n);
    }
}