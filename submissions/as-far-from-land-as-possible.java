class Solution {
    // BFS：多源BFS（Flood Fill ）
    private static final int[][] DIRS = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};

    public int maxDistance(int[][] grid) {
        int result = -1;
        Queue<int[]> queue = new ArrayDeque();
        // 记录距离，及访问节点
        Map<Integer, Integer> distMap = new HashMap();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) { // island
                    queue.add(new int[]{i, j});
                    distMap.put(i * n + j, 0);
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int dist = distMap.get(cur[0] * n + cur[1]);
                for (int j = 0; j < DIRS.length; j++) {
                    int nx = cur[0] + DIRS[j][0];
                    int ny = cur[1] + DIRS[j][1];
                    if (!isValid(grid, nx, ny)) {
                        continue;
                    }
                    if (distMap.containsKey(nx * n + ny)) {
                        continue;
                    }
                    distMap.put(nx * n + ny, dist + 1);
                    queue.add(new int[] {nx, ny});
                    result = Math.max(result, dist + 1);
                }
            }
        }
        return result;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        return (x >= 0) && (x < grid.length) && (y >= 0) && (y < grid[0].length) && (grid[x][y] == 0);
    }
}