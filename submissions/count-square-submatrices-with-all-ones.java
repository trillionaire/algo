class Solution {
    public int countSquares(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;
        int res = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int k = 0;
                while (check(matrix, i, j, k)) {
                    k++;
                    res++;
                }
            }
        }
        return res;
    }

    private boolean check(int[][] matrix, int i, int j, int k) {
        if (i + k >= matrix.length || j + k >= matrix[0].length) {
            return false;
        }
        for (int x = i; x <= i + k; x++) {
            for (int y = j; y <= j + k; y++) {
                if (matrix[x][y] != 1) {
                    return false;
                }
            }
        }
        //System.out.println(i + " " + j + " " + k);
        return true;
    }
}