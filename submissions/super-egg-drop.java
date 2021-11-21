class Solution {
    public int superEggDrop(int k, int n) {
        // 扔一次 + 没碎（上面还有i-1层） + 碎了（下面还有i-1层）
        // dp[i][k] = 1 + dp[i - 1][k] + dp[i - 1][k - 1]; 且不超过n次。
        // dp[i][1] = i , dp[1][k] = 1 
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][1] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = 1 + dp[i - 1][j] + dp[i - 1][j - 1];
                if (dp[i][j] >= n) {
                    return i;
                }
            }
        }
        return -1;
    }
}