class Solution {
    // DFS：矩形DFS + dir转方向
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int[][] generateMatrix(int n) {
        int[][] grid = new int[n][n];
        dfs(grid, 0, 0, 1, 0);
        return grid;
    }

    private void dfs(int[][] grid, int x, int y, int num, int dir) {
        int len = grid.length;
        if (num > len * len) {
            return;
        }
        grid[x][y] = num;
         // 需要转方向
        if (!isValid(grid, x, y, dir)) {
            dir = (dir + 1) % 4;
        }
        dfs(grid, x + DIRS[dir][0], y + DIRS[dir][1], num + 1, dir);
    }

    private boolean isValid(int[][] grid, int x, int y, int dir) {
        int xx = x + DIRS[dir][0];
        int yy = y + DIRS[dir][1];
        return (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid.length && grid[xx][yy] == 0);
    }
}