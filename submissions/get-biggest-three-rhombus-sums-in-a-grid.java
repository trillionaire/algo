class Solution {
    int[][] DIRS = {{1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Integer> set = new HashSet();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> (a - b));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxEdge = getMaxEdge(i, j, m, n);
                for (int edge = 0; edge <= maxEdge; edge++) {
                    int cur = getSum(grid, i, j, edge);
                    if (set.contains(cur)) {
                        continue;
                    }
                    pq.add(cur);
                    set.add(cur);
                    if (pq.size() > 3) {
                        set.remove(pq.poll());
                    }
                }
            }
        }
        return pq.stream().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
    }

    private int getMaxEdge(int i, int j, int m, int n) {
        int res = Math.min(i, m - 1 - i);
        res = Math.min(res, (n - 1 - j) / 2);
        return res;
    }

    private int getSum(int[][]grid, int x, int y, int edge) {
        int res = 0;
        int cx = x;
        int cy = y;
        if (edge == 0) {
            return grid[x][y];
        }
        for (int i = 0; i < DIRS.length; i++) {
            for (int j = 0; j < edge; j++) {
                cx += DIRS[i][0];
                cy += DIRS[i][1];
                res += grid[cx][cy];
            }

        }
        return res;
    }
}