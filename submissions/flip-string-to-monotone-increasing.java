class Solution {
    // 数学：一遍遍历
    public int minFlipsMonoIncr(String s) {
        char[] chars = s.toCharArray();
        int result = chars.length;
        int t0 = 0;
        int t1 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                t0++;
            }
        }
        result = Math.min(result, t0);
        result = Math.min(result, chars.length - t0);
        // check change point. t0 : zero after point; t1 : one before point
        for (int i = 0; i < chars.length; i++) {
            result = Math.min(result, t0 + t1);
            if (chars[i] == '1') {
                t1++;
            } else {
                t0--;
            }
        }
        return result;
    }
}