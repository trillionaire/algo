class Solution {
    // DFS: 状态变量start
    private int start;

    public String decodeString(String s) {
        start = 0;
        return dfs(s);
    }

    public String dfs(String s) {
        StringBuilder result = new StringBuilder();
        int num = 0;
        while (start < s.length()) {
            char c = s.charAt(start);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                start++;
                String next = dfs(s);
                for (int i = 0; i < num; i++) {
                    result.append(next);
                }
                num = 0;
            } else if (c == ']') {
                return result.toString();                    
            } else if (Character.isAlphabetic(c)) {
                result.append(c);
            }
            start++;
        }
        return result.toString();
    }
}
