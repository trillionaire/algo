class Solution {
  private static final int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
  public int cutOffTree(List<List<Integer>> forest) {
    int m = forest.size();
    int n = forest.get(0).size();
    int res = 0;
    int val = forest.get(0).get(0);
    List<int[]> nodes = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (forest.get(i).get(j) > 1) {
          nodes.add(new int[] {i, j, forest.get(i).get(j)});
        }
      }
    }
    nodes.sort((a, b) -> (a[2] - b[2]));
    int cur = 0;
    int sx = 0;
    int sy = 0;
    for (int i = 0; i < nodes.size(); i++) {
      cur = bfs(forest, sx, sy, nodes.get(i)[0], nodes.get(i)[1]);
      if (cur == -1) {
        return -1;
      }
      res += cur;
      sx = nodes.get(i)[0];
      sy = nodes.get(i)[1];
    }
    return res;
  }

  private int bfs(List<List<Integer>> forest, int sx, int sy, int tx, int ty) {
    int m = forest.size();
    int n = forest.get(0).size();
    Queue<int[]> queue = new LinkedList();
    boolean[][] vis = new boolean[m][n];
    queue.add(new int[] {sx, sy});
    vis[sx][sy] = true;
    int steps = 0;

    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int l = 0; l < size; l++) {
        int[] cur = queue.poll();
        if (cur[0] == tx && cur[1] == ty) {
          return steps;
        }
        for (int i = 0; i < dirs.length; i++) {
          int nx = cur[0] + dirs[i][0];
          int ny = cur[1] + dirs[i][1];
          if (!isValid(forest, nx, ny, vis)) {
            continue;
          }
          queue.add(new int[] {nx, ny});
          vis[nx][ny] = true;
        }
      }
      steps++;
    }
    return -1;
  }

  private boolean isValid(List<List<Integer>> forest, int x, int y, boolean[][] vis) {
    int m = forest.size();
    int n = forest.get(0).size();
    return ((x >= 0) && (x < m) && (y >= 0) && (y < n) && !vis[x][y] && (forest.get(x).get(y) > 0));
  }

}