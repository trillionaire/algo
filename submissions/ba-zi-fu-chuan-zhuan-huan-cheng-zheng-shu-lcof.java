class Solution {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length == 0) {
            return 0;
        }
        int sign = 1;
        long res = 0;
        int i = 0;
        if (chars[i] == '-' || chars[i] == '+') {
            sign = (chars[i] == '-') ? -1 : 1;
            i++;
        }
        for (; i < chars.length; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                int cur = chars[i] - '0';
                res = res * 10 + cur;
                if (res > Integer.MAX_VALUE) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }
        return sign * (int) res;
    }
}