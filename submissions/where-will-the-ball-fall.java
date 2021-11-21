class Solution {
    // DFS: 二维DFS
    private int ans;
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[n];
        for (int j = 0; j < n; j++) {
            ans = j;
            dfs(grid, 0, j);
            result[j] = ans;
        }
        return result;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        // 退出：列越界
        if ((j < 0) || (j >= n)) {
            ans = -1;
            return;
        }
        // 退出：到达出口，注意是最后一行的下面一行
        if (i >= m) {
            return;
        }
        // 退出：向右无路
        if ((j < n - 1) && (grid[i][j] == 1) && (grid[i][j + 1] == -1)) {
            ans = -1;
            return;
        }
        // 退出：向左无路
        if ((j > 0) && (grid[i][j] == -1) && (grid[i][j - 1] == 1)) {
            ans = -1;
            return;
        }
        // 选择：根据方向
        if (grid[i][j] == 1) {
            ans = j + 1;
        } else {
            ans = j - 1;
        }
        dfs(grid, i + 1, ans);
    }
}