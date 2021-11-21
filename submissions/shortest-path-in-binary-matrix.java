class Solution {
    private final static int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        Queue<int[]> queue = new LinkedList();
        Set<Integer> visited = new HashSet();
        if (grid[0][0] == 1) {
            return -1;
        }
        if (m == 1) {
            return m;
        }
        queue.add(new int[] {0, 0});
        int result = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < DIRS.length; j++) {
                    int x = cur[0] + DIRS[j][0];
                    int y = cur[1] + DIRS[j][1];
                    if (!isValid(x, y, m) || (grid[x][y] != 0) || visited.contains((x << 7) | y)) {
                        continue;
                    }
                    if (x == m - 1 && y == m - 1) {
                        return result + 1;
                    }
                    queue.add(new int[]{x, y});
                    visited.add((x << 7) | y);
                }
            }
            result++;
        }
        return -1;
    }

    private boolean isValid(int x, int y, int m) {
        return ((x >= 0) && (x < m) && (y >= 0) && (y < m));
    }
}