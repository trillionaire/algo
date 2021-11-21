class Solution {
    // 二分：按值
    public int kthSmallest(int[][] matrix, int k) {
        int len = matrix.length;
        int left = matrix[0][0];
        int right = matrix[len - 1][len - 1];
        // divide by value not index.
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = find(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else { // 注意：mid有可能不在
                right = mid - 1;
            }
        }
        return left;
    }

    private int find(int[][] matrix, int val) {
        int len = matrix.length;
        int res = 0;
        for (int i = len - 1, j = 0; i >= 0; i--) {
            while (j < len && matrix[i][j] <= val) {
                j++;
            }
            res += j;
        }
        return res;
    }
}