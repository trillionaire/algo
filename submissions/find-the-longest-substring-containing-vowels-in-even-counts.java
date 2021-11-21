class Solution {
    public int findTheLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int even = 0, max = 0;
        int[] dp = new int[1 << 5]; // "各种"情况，首次出现的索引
        Arrays.fill(dp, -1);
        dp[even] = 0; // 现在是完美平衡
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (c == 'a') even ^= 1;
            else if (c == 'e') even ^= (1 << 1);
            else if (c == 'i') even ^= (1 << 2);
            else if (c == 'o') even ^= (1 << 3);
            else if (c == 'u') even ^= (1 << 4);
            if (dp[even] == -1) dp[even] = i + 1;
            else max = Math.max(max, i + 1 - dp[even]); // 计算距离，首次出现这种情况的索引
        }
        return max;
    }
}