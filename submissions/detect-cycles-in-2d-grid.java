class Solution {
    // DFS（网格）：dfs进入前剪枝 + cur/pre两个点剪枝
    private boolean ans;
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    boolean[][] visited;
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    dfs(grid, i, j, -1, -1);
                    if (ans) {
                        return ans;
                    }
                }
            }
        }
        return false;
    }

    private void dfs(char[][] grid, int x, int y, int preX, int preY) {
        int m = grid.length;
        int n = grid[0].length;
        if (visited[x][y]) {
            ans = true;
            return;
        }
        visited[x][y] = true;
        for (int[] dir : DIRS) {
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                continue;
            }
            if (nextX == preX && nextY == preY) {
                continue;
            }
            if (grid[nextX][nextY] != grid[x][y]) {
                continue;
            }
            dfs(grid, nextX, nextY, x, y);
        }
    }
}