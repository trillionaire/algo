class Solution {
    // DFS : 回文 
    private List<List<String>> result;

    public List<List<String>> partition(String s) {
        result = new ArrayList();
        Set<String> set = getAll(s);
        dfs(s, 0, new ArrayList<String>(), set);
        return result;
    }

    private Set<String> getAll(String s) {
        Set<String> result = new HashSet();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length * 2; i++) {
            int left = i / 2;
            int right = (i + 1) / 2;
            while (left >= 0 && (right < chars.length) && chars[left] == chars[right]) {
                result.add(s.substring(left, right + 1));
                left--;
                right++;
            }
        }
        return result;
    }

    private void dfs(String s, int start, ArrayList<String> path, Set<String> set) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String cur = s.substring(start, i);
            if (!set.contains(cur)) {
                continue;
            }
            path.add(cur);
            dfs(s, i, path, set);
            path.remove(path.size() - 1);
        }
        return;
    }
}