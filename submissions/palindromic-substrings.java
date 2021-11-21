class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length * 2; i++) {
            int left = i / 2;
            int right = (i + 1) / 2;
            while ((left >= 0) & (right < chars.length) && chars[left] == chars[right]) {
                res++;
                left--;
                right++;
            }
        }
        return res;
    }
}