class Solution {
    public int projectionArea(int[][] grid) {
        int x = 0;
        int y = 0;
        int z = 0;
        for (int i = 0; i < grid.length; i++) {
            int max = 0;
            for (int j = 0; j < grid[0].length; j++) {
                x += (grid[i][j] == 0) ? 0 : 1;
                max = Math.max(max, grid[i][j]);
            }
            y += max;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int max = 0;
            for (int j = 0; j < grid.length; j++) {
                max = Math.max(max, grid[j][i]);
            }
            z += max;
        }
        return (x + y + z);
    }
}