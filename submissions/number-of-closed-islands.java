class Solution {
    // DFS(网格)：flag记录是否碰到边界
    private boolean flag;
    public int closedIsland(int[][] grid) {
        int result = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flag = true;
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    if (flag) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            flag = false;
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        grid[i][j] = 1;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}