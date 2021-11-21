class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] matrix = new int[mat.length + 1][mat[0].length + 1];
        int[][] presum = new int[matrix.length][matrix[0].length];
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = mat[i - 1][j - 1];
                presum[i][j] = presum[i - 1][j] + presum[i][j - 1] + matrix[i][j] - presum[i - 1][j - 1];
            }
        }
        int[][] res = new int[mat.length][mat[0].length];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int x1 = Math.max(1, i - k);
                int y1 = Math.max(1, j - k);
                int x2 = Math.min(m - 1, i + k);
                int y2 = Math.min(n - 1, j + k);
                res[i - 1][j - 1] = presum[x2][y2] + presum[x1 - 1][y1 - 1] - presum[x1 - 1][y2] - presum[x2][y1 - 1];
            }
        }
        return res;
    }
}