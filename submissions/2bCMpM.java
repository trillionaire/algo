class Solution {
    // BFS：矩形+洪水填充。从所有为0的岛屿找1，降低时间复杂度。visited通过结果标记。队列可用(x << bit | y)哈希，可以用int[]
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(i << 16 | j);
                } else {
                    result[i][j] = -1;
                }
            }
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 0; j < DIRS.length; j++) {
                    int x = (cur >> 16) + DIRS[j][0];
                    int y = (cur & ((1 << 16) - 1)) + DIRS[j][1];
                    if (!isValid(x, y, m, n) || result[x][y] != -1) {
                        continue;
                    }
                    result[x][y] = (depth + 1);
                    queue.add(x << 16 | y);
                }
            }
            depth++;
        }
        return result;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return (x >= 0) && (x < m) && (y >= 0) && (y < n);
    }

}