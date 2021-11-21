class Solution {
    // DFS + 记忆化
    // https://leetcode-cn.com/problems/interleaving-string/solution/shou-hua-tu-jie-dfshui-su-dfsji-yi-hua-by-hyj8/
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s1.isEmpty()) {
            return s2.equals(s3);
        }
        if (s2.isEmpty()) {
            return s1.equals(s3);
        }
        boolean[][] visited = new boolean[s1.length()][s2.length()];
        return dfs(s1, 0, s2, 0, s3, 0, visited);
    }

    private boolean dfs(String s1, int start1, String s2, int start2, String s3, int start3, boolean[][] visited) {
        if (start1 == s1.length()) {
            return s2.substring(start2).equals(s3.substring(start3));
        }
        if (start2 == s2.length()) {
            return s1.substring(start1).equals(s3.substring(start3));
        }
        if (visited[start1][start2]) {
            return false;
        }
        visited[start1][start2] = true;
        if (s1.charAt(start1) == s3.charAt(start3)) {
            if (dfs(s1, start1 + 1, s2, start2, s3, start3 + 1, visited)) {
                return true;
            }
        }
        if (s2.charAt(start2) == s3.charAt(start3)) {
            if (dfs(s1, start1, s2, start2 + 1, s3, start3 + 1, visited)) {
                return true;
            }
        }
        return false;
    }
}