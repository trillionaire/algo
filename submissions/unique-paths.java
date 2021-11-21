class Solution {
    // 组合数学： C(m + n - 2, m - 1)
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        int len = Math.min(m - 1, n - 1);
        long result = 1;
        long tmp = 1;
        for (int i = 0; i < len; i++) {
            result *= (m + n - 2 - i);
            tmp *= (i + 1);
        }
        return (int)(result / tmp);
    }
}