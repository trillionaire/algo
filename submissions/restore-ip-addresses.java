class Solution {
    // 全排列型DFS + 增加stage状态变量 + 剪支（按长度）
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        dfs(s, 0, 0, new ArrayList<String>(), result);
        return result;
    }

    private void dfs(String s, int start, int stage, List<String> path, List<String> result) {
        if (start == s.length()) {
            if (stage == 4) {
                result.add(String.join(".", path));
                return;
            }
        }
        
        // trim by length or stage
        if (stage > 3 || ((s.length() - start) > (4 - stage) * 3)) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (start + i - 1 >= s.length()) {
                continue;
            }
            String cur = s.substring(start, start + i);
            if (!isValid(cur)) {
                continue;
            }
            path.add(cur);
            dfs(s, start + i, stage + 1, path, result);
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(String s) {
        int cur = Integer.valueOf(s);
        if (cur > 255 || cur < 0 || (s.charAt(0) == '0' && s.length() > 1)) {
            return false;
        }
        return true;
    }
}