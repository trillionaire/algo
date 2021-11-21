class Solution {
  private static final int[] dx = {-1, 0, 1, 0};
  private static final int[] dy = {0, -1, 0, 1};
  public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    boolean[][] visited = new boolean[image.length][image[0].length];
    dfs(image, sr, sc, image[sr][sc], newColor, visited);
    return image;
  }

  private void dfs (int[][] image, int sr, int sc, int oldColor, int newColor, boolean[][] visited) {
    if (!isValid(sr, sc, image.length, image[0].length)) {
      return;
    }
    if (visited[sr][sc]) {
      return;
    }
    if (image[sr][sc] != oldColor) {
      return;
    }
    visited[sr][sc] = true;
    image[sr][sc] = newColor;
    for (int i = 0; i < dx.length; i++) {
      int cx = sr + dx[i];
      int cy = sc + dy[i];
      dfs(image, cx, cy, oldColor, newColor, visited);
    }
  }

  private boolean isValid(int x, int y, int xLen, int yLen) {
    return (0 <= x) && (x < xLen) && (0 <= y) && (y < yLen);
  }

}