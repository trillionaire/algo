class Solution {
    public int[] findSquare(int[][] matrix) {
        int[] result = {-1, -1, -1};
        int[][] mat = new int[matrix.length + 1][matrix[0].length + 1];
        int[][] presums = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                mat[i][j] = matrix[i - 1][j - 1];
                presums[i][j] = presums[i - 1][j] + presums[i][j - 1] + mat[i][j] - presums[i - 1][j - 1];
            }
        }
        for (int i = 1; i < mat.length; i++) {
            for (int j = 1; j < mat[0].length; j++) {
                for (int len = 1; (len + i - 1 < mat.length) && (len + j - 1 < mat[0].length); len++) {
                    int outRegion = presums[len + i - 1][len + j - 1] + presums[i - 1][j - 1]
                                    - presums[len + i - 1][j - 1] - presums[i - 1][len + j - 1];
                    int innerRegion = 0;
                    if (len > 2) {
                        innerRegion = presums[len + i - 2][len + j - 2] + presums[i][j]
                                - presums[len + i - 2][j] - presums[i][len + j - 2];
                    }
                    if (outRegion == innerRegion) {
                        if (len > result[2]) {
                            result = new int[] {i - 1, j - 1, len};
                        }
                    }
                }
            }
        }
        if (result[2] == -1) {
            return new int[0];
        }
        return result;
    }
}