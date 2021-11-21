class Solution {
    // DFS : DFS + 记忆化
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Map<Integer, Integer> memo = new HashMap<>();
        return dfs(grid, 0, 0, memo);
    }

    private int dfs(int[][] grid, int x, int y, Map<Integer, Integer> memo) {
        int m = grid.length;
        int n = grid[0].length;

        if (x >= m || x < 0 || y < 0 || y >= n) {
            return Integer.MAX_VALUE;
        }
        if ((x == m - 1 && y == n - 1)) {
            return grid[x][y];
        }
        // 获取缓存
        if (memo.containsKey(x * n + y)) {
            return memo.get(x * n + y);
        }
        int result = Math.min(dfs(grid, x + 1, y, memo), dfs(grid, x, y + 1, memo)) + grid[x][y];
        // 记录缓存
        memo.put(n * x + y, result);
        return result;
    }
}