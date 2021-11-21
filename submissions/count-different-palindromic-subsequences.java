class Solution {
    public int countPalindromicSubsequences(String S) {
        int len = S.length();
        char[] s = S.toCharArray();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int k = 2; k <= len; k++) {
            for (int i = 0; i <= len - k; i++) {
                int j = k + i - 1;
                if (s[i] != s[j]) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]; 
                } else {
                    int l = i + 1;
                    int r = j - 1;
                    while (s[l] != s[i]) { l++; }
                    while (s[r] != s[i]) { r--; }
                    if (l == r) { // "bcbab"
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else if (l > r) { // "bcb"
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else { // "bbcbb"
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[l + 1][r - 1];
                    }
                }
                dp[i][j] = dp[i][j] < 0 ? dp[i][j] + 1000000007 : dp[i][j] % 1000000007;
            }
        }
        return dp[0][len - 1];
    }

}