class Solution {
  // DP: 按最后1，2位求解
  private static final int MOD = 1000000007;

  public int numDecodings(String s) {
    char[] chars = s.toCharArray();
    int n = chars.length;
    long[] dp = new long[n + 1];
    dp[0] = 1;
    dp[1] = byLastChar(chars[0]);
    for (int i = 2; i <= n; i++) {
      dp[i] = dp[i - 1] * byLastChar(chars[i - 1]) % MOD
          + dp[i - 2] * byLastTwoChars(chars[i - 2], chars[i - 1]) % MOD;
    }
    return (int)dp[n] % MOD;
  }

  private int byLastTwoChars(char c1, char c2) {
    int ret = 0;
    if (c1 == '1') {
      // 1* : 11-19 : 9
      // 1[0-9] : 1
      ret = (c2 == '*' ? 9 : 1);
    } else if (c1 == '2') {
      // 2* : 21-26 : 6
      // 2[0-6] : 2[0-6] : 1
      // 2[7-9] : 0
      ret = (c2 == '*' ? 6 : (c2 <= '6') ? 1 : 0);
    } else if (c1 == '*') {
      // *[0-6] : 2
      // *[7-9] : 1
      // **: 11-19, 21-26 : 15
      ret = (c2 == '*' ? 15 : (c2 <= '6') ? 2 : 1);
    }
    // [3-9]*
    // 0*
    return ret;
  }


  private int byLastChar(char c) {
    return (c == '*' ? 9 : (c == '0') ? 0 : 1);
  }
}