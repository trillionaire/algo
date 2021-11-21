class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // LCS with max ACSII value. 
        int[][] dp = new int[m+1][n+1];
        int total = 0;
        for (int i = 0; i < m; i++) {
            total += s1.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            total += s2.charAt(i);
        }
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + s1.charAt(i-1);
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return total - 2*max;
    }
}