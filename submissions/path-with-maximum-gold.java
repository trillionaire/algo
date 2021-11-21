class Solution {
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    int max = 0;

    public int getMaximumGold(int[][] grid) {
        int res = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                res = Math.max(res, backtrace(grid, i, j, visited));
            }
        }
        return res;
    }

    private int backtrace(int[][] grid, int x, int y, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        // end case
        if (!isValid(grid, x, y, m, n) || visited[x][y]) {
            return 0;
        }

        // backtrace
        int delta = 0;
        for (int i = 0; i < dx.length; i++) {
            visited[x][y] = true;            
            delta = Math.max(delta, backtrace(grid, x + dx[i], y + dy[i], visited));
            visited[x][y] = false;
            max = 0;
        }
        return grid[x][y] + delta;
    }

    private boolean isValid(int[][] grid, int x, int y, int m, int n) {
        return ((0 <= x) && (x < m) && (0 <= y) && (y < n) && (grid[x][y] != 0));
    }
}