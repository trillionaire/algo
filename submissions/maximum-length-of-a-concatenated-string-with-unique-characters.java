class Solution {
    private int result;

    public int maxLength(List<String> arr) {
        result = 0;
        dfs(arr, 0, 0);
        return result;
    }

    private void dfs(List<String> arr, int start, int path) {
        if (start >= arr.size()) {
            result = Math.max(result, getVal(path));
            return;
        }
        if (getVal(path) == 26) {
            result = Math.max(result, getVal(path));
            return;
        }
        // 不选当前
        dfs(arr, start + 1, path);
        // 选择当前
        if (isValid(arr.get(start)) && (hash(arr.get(start)) & path) == 0) {
            dfs(arr, start + 1, path | hash(arr.get(start)));
        }
    }

    private int hash(String s) {
        int val = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            val |= (1 << (chars[i] - 'a'));
        }
        return val;
    }

    private int getVal(int path) {
        int val = 0;
        for (int i = 0; i < 26; i++) {
            if (((1 << i) & path) != 0) {
                val++;
            }
        }
        return val;
    }

    private boolean isValid(String s) {
        int val = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((val & (1 << (chars[i] - 'a'))) != 0) {
                return false;
            }
            val |= (1 << (chars[i] - 'a'));
        }
        return true;
    }
}