class Solution {
    private static final int[][] DIRS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[m][n];
        int step = 0;
        queue.add(entrance);
        visited[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int j = 0; j < DIRS.length; j++) {
                    int nextX = cur[0] + DIRS[j][0];
                    int nextY = cur[1] + DIRS[j][1];
                    if (!isValid(maze, nextX, nextY, visited)) {
                        continue;
                    }
                    if (isExit(maze, nextX, nextY)) {
                        return step;
                    }
                    queue.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }
        return -1;
    }

    private boolean isExit(char[][] maze, int x, int y) {
        int m = maze.length;
        int n = maze[0].length;
        return (x == 0) || (x == m - 1) || (y == 0) || (y == n - 1);
    }

    private boolean isValid(char[][] maze, int x, int y, boolean[][] visited) {
        int m = maze.length;
        int n = maze[0].length;
        return (x >= 0) && (x < m) && (y >= 0) && (y < n) && !visited[x][y] && maze[x][y] == '.';
    }
}