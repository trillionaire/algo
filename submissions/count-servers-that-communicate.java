class Solution {
    private int ans;
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        int[] cols = new int[n];
        int[] lines = new int[m];
        for (int i = 0; i < m; i++) {
            int line = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    line++;
                }
            }
            lines[i] = line;
        }
        for (int j = 0; j < n; j++) {
            int col = 0;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 1) {
                    col++;
                }
            }
            cols[j] = col;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    if(lines[i] > 1 || cols[j] > 1) {
                        result++;
                    }
                    visited[i][j] = true;
                }
            }
        }
        return result;
    }
}