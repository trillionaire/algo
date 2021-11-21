class Solution {
    // DFS：记忆化搜索，memo记录从index开始的数量
    public int respace(String[] dic, String s) {
        Set<String> set = new HashSet<String>(Arrays.asList(dic));
        // 从index开始的数量
        int[] memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dfs(s, 0, set, memo);
    }

    private int dfs(String s, int start, Set<String> set, int[] memo) {
        if (start >= s.length()) {
            return 0;
        }
        if (memo[start] != -1) {
            return memo[start];
        }
        int result = Integer.MAX_VALUE;
        // 遍历所有将[start, end] 切分为两端字符串的情况
        for (int i = start + 1; i <= s.length(); i++) {
            String pre = s.substring(start, i);
            // 前段可识别：dfs后面的
            if (set.contains(pre)) {
                result = Math.min(result, dfs(s, i, set, memo));
            } else { // 前段不可识别：dfs后面的 + 前段长度
                result = Math.min(result, i - start + dfs(s, i, set, memo));
            }
        }
        memo[start] = result;
        return result;
    }

}