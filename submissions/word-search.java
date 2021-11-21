class Solution {
    // DFS: matrix
    private final int[][] dir = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        if ((board == null) || (board.length == 0) || (board[0].length == 0)) {
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0, new boolean[m][n]) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, int start, boolean[][] visited) {
        if (start >= word.length()) {
            return true;
        }

        if (!isValid(board, x, y) || visited[x][y] || board[x][y] != word.charAt(start)) {
            return false;
        }

        visited[x][y] = true;
        for (int i = 0; i < dir.length; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (dfs(board, nextX, nextY, word, start + 1, visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }

    private boolean isValid(char[][] board, int x, int y) {
        return (x >= 0) && (x < board.length) && (y >= 0) && (y < board[0].length);
    }
}