class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int swimInWater(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int left = grid[0][0];
        int right = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                right = Math.max(right, grid[i][j]);
            }
        }
        if (right == grid[row - 1][col - 1]) {
            return right;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (dfs(grid, 0, 0, new boolean[row][col], mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean dfs(int[][] grid, int x, int y, boolean[][] visited, int t) {
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return true;
        }
        visited[x][y] = true;
        for (int i = 0; i < DIRS.length; i++) {
            int nx = x + DIRS[i][0];
            int ny = y + DIRS[i][1];
            if (!isValid(grid, nx, ny, visited, t)) {
                continue;
            }
            if (dfs(grid, nx, ny, visited, t)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int[][] grid, int nx, int ny, boolean[][] visited, int t) {
        int row = grid.length;
        int col = grid[0].length;
        boolean res = (nx >= 0) && (nx < row) && (ny >= 0)
                && (ny < col) && !visited[nx][ny] && grid[nx][ny] <= t;
        return res;
    }
}