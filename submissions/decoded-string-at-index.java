class Solution {
    // 递归：
    public String decodeAtIndex(String s, int k) {
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int cur = c - '0';
                if ((k - 1) / cur >= len ) {
                    // 如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次
                    len *= cur;
                } else {
                    return decodeAtIndex(s, (k - 1) % len + 1);
                }
            } else {
                if (++len == k) {
                    return String.valueOf(c);
                }
            }
        }
        return "";
    }
}