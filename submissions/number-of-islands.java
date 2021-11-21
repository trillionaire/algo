class Solution {
  private class Dus {
    private int count;
    private int[] parent;
    public Dus(char[][] grid) {
      count = 0;
      int m = grid.length;
      int n = grid[0].length;
      parent = new int[m*n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (grid[i][j] == '1') {
            parent[i*n + j] = i*n + j;
            count++;
          }
        }
      }
    }

    public int find(int i) {
      if (parent[i] != i) {
        parent[i] = find(parent[i]);
      }
      return parent[i];
    }

    public void union(int l, int r) {
      int lroot = find(l);
      int rroot = find(r);
      if (lroot == rroot) {
        return;
      }
      if (lroot < rroot) {
        parent[rroot] = lroot;
        count--;
        return;
      }
      parent[lroot] = rroot;
      count--;
      return;
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
        return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    Dus dus = new Dus(grid);
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          if (i > 0 && grid[i - 1][j] == '1') {
            dus.union(i*n + j , (i-1)*n + j);
          }
          if (j > 0 && grid[i][j - 1] == '1') {
            dus.union(i*n + j, i*n + j - 1);
          }
        }
      }
    }
    return dus.count;
  }
}