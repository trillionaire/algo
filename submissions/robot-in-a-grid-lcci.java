class Solution {
    private List<List<Integer>> path = new ArrayList<>();
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        boolean[][] visited = new boolean[obstacleGrid.length][obstacleGrid[0].length];
        dfs(obstacleGrid, 0, 0, path, visited);
        return path;
    }

    private boolean dfs(int[][] obstacleGrid, int x, int y, List<List<Integer>> path, boolean[][] visited) {
        if (x > obstacleGrid.length - 1 || y > obstacleGrid[0].length - 1 || obstacleGrid[x][y] == 1 || visited[x][y]) {
            return false;
        }
        path.add(Arrays.asList(x, y));
        visited[x][y] = true;
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            List<Integer> node = new ArrayList();
            return true;
        }
        if (dfs(obstacleGrid, x, y + 1, path, visited) || dfs(obstacleGrid, x + 1, y, path, visited)) {
            return true;
        }
        path.remove(path.size() - 1);
        //visited[x][y] = false;
        return false;
    }
}