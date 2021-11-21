class Solution {
  // dp: dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
  public int maximalSquare(char[][] matrix) {
    boolean isInvalid = (matrix == null) || (matrix.length == 0) || (matrix[0].length == 0);
    if (isInvalid) {
      return 0;
    }
    int row = matrix.length;
    int column = matrix[0].length;
    int[][] dp = new int[row + 1][column + 1];
    int max = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        if (matrix[i][j] == '1') {
          int tmp = Math.min(dp[i][j], dp[i][j+1]);
          tmp = Math.min(tmp, dp[i+1][j]);
          dp[i+1][j+1] = tmp + 1;
          if (max < dp[i+1][j+1]) {
            max = dp[i+1][j+1];
          }
        }
      }
    }
    return max*max;
  }
}