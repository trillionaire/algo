class Solution {
  private static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
  private int res = Integer.MAX_VALUE;

  public int minimumEffortPath(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;
    int low = 0;
    int high = 1000000;
    while (low < high) {
        boolean visited[][] = new boolean[m][n];
        int mid = (low + high) / 2;
        if (backtrace(heights, 0, 0, visited, mid)) {
            high = mid;
        } else {
            low = mid + 1;
        }
    }
    return low;
  }

  boolean backtrace(int[][] heights, int x, int y, boolean[][] visited, int max) {
    int m = heights.length;
    int n = heights[0].length;
    if ((x == m - 1) && (y == n - 1)) {
      return true;
    }
    visited[x][y] = true;
    for (int[] dir : dirs) {
      int nx = dir[0] + x;
      int ny = dir[1] + y;
      if (!isValid(m, n, nx, ny) || visited[nx][ny] == true || 
            (Math.abs(heights[nx][ny] - heights[x][y]) > max) ) {
        continue;
      }
      if (backtrace(heights, nx, ny, visited, max)) {
          return true;
      }
    }
    return false;
  }

  private boolean isValid(int m, int n, int x, int y) {
    return (0 <= x) && (x < m) && (0 <= y) && (y < n);
  }
}