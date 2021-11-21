class Solution {
    private ArrayList<Integer> path;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        Set<Set<Integer>> sets = new HashSet();
        int m = grid1.length;
        int n = grid1[0].length;
        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] != 0) {
                    path = new ArrayList<Integer>();
                    dfs(grid2, i, j, path);
                    sets.add(new HashSet<Integer>(path));
                }
            }
        }
        return getSubAreas(grid1, sets);
    }

    private int getSubAreas(int[][] grid, Set<Set<Integer>> sets) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;
        for (Set<Integer> set : sets) {
            boolean flag = true;
            for (Integer i : set) {
                if (grid[i / n][i % n] == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result++;
            }
        }
        return result;
    }

    private void dfs(int[][] grid, int x, int y, ArrayList<Integer> path) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == 0) {
            return;
        }
        grid[x][y] = 0;
        path.add(x * n + y);
        dfs(grid, x + 1, y, path);
        dfs(grid, x - 1, y, path);
        dfs(grid, x, y + 1, path);
        dfs(grid, x, y - 1, path);
    }
}