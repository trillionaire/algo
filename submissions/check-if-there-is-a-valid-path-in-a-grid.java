class Solution {
    // x, y: dirs, z: type
    // type : 上(2, 3, 4), 下(2, 5, 6), 左(1, 4, 6), 右(1, 3, 5)
    final private int[][][] DIRS = new int[][][] {
            // type : 1
            {{0, -1, 1}, {0, -1, 4}, {0, -1, 6}, {0, 1, 1}, {0, 1, 3}, {0, 1, 5}},
            {{-1, 0, 2}, {-1, 0, 3}, {-1, 0, 4}, {1, 0, 2}, {1, 0, 5}, {1, 0, 6}},
            {{0, -1, 1}, {0, -1, 4}, {0, -1, 6}, {1, 0, 2}, {1, 0, 5}, {1, 0, 6}},
            {{0, 1, 1}, {0, 1, 3}, {0, 1, 5}, {1, 0, 2}, {1, 0, 5}, {1, 0, 6}},
            {{0, -1, 1}, {0, -1, 4}, {0, -1, 6}, {-1, 0, 2}, {-1, 0, 3}, {-1, 0, 4}},
            {{0, 1, 1}, {0, 1, 3}, {0, 1, 5}, {-1, 0, 2}, {-1, 0, 3}, {-1, 0, 4}}
    };
    public boolean hasValidPath(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        return dfs(grid, 0, 0, visited);
    }

    private boolean dfs(int[][] grid, int x, int y, boolean[][] visited) {
        //System.out.println(x + " , " + y);
        int m = grid.length;
        int n = grid[0].length;
        if ((x == m - 1) && (y == n - 1)) {
            return true;
        }

        if (!isValid(grid, x, y, visited)) {
            return false;
        }
        visited[x][y] = true; 
        for (int[] item : DIRS[grid[x][y] - 1]) {
            int nx = x + item[0];
            int ny = y + item[1];
            int ntype = item[2];
            if (isValid(grid, nx ,ny, visited) && ntype == grid[nx][ny] && dfs(grid, nx, ny, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int[][] grid, int x, int y, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        return (x >= 0) && (x < m) && (y >= 0) && (y < n) && !visited[x][y];
    }
}