class Solution {
    public int maximalRectangle(char[][] oldMatrix) {
        if (oldMatrix.length == 0 || oldMatrix[0].length == 0) {
            return 0;
        }
        int[][] matrix = new int[oldMatrix.length + 1][oldMatrix[0].length + 1];
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] presum = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = (oldMatrix[i - 1][j - 1] - '0');
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                presum[i][j] =
                        presum[i][j - 1] + presum[i - 1][j] + matrix[i][j] - presum[i - 1][j - 1];
            }
        }
        int result = 0;
        for (int x1 = 1; x1 < m; x1++) {
            for (int y1 = 1; y1 < n; y1++) {
                for (int x2 = x1; x2 < m; x2++) {
                    int x = x2 - x1 + 1;
                    for (int y2 = y1; y2 < n; y2++) {
                        int y = y2 - y1 + 1;
                        int area = presum[x2][y2] + presum[x1 - 1][y1 - 1] - presum[x1 - 1][y2]
                                - presum[x2][y1 - 1];
                        if (area == x * y) {
                            result = Math.max(result, area);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}