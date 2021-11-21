class Solution {
    // 贪心：从左下像右上角遍历，上面的小，右边的大。
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean isInValidMatrix = (matrix == null || matrix.length == 0 || matrix[0].length == 0);
        if (isInValidMatrix) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (matrix[i][j] != target) {
            if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
            boolean isOutOfBound = (i >= matrix.length || j < 0);
            if (isOutOfBound) {
                return false;
            }
        }
        return true;
    }
}