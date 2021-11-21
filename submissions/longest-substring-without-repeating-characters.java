class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[256];
        if (chars.length <= 1) {
            return chars.length;
        }

        int res = 0;
        for (int l = 0, r = 0; r < chars.length; r++) {
            // move r
            while (r < chars.length && (map[chars[r]] == 0)) {
                map[chars[r]] = 1;
                res = Math.max(res, r - l + 1);
                r++;
            }
            // move l
            while (r < chars.length && l <= r && (chars[r] != chars[l])) {
                map[chars[l]] = 0;
                l++;
            }
            l++;
        }
        return res;
    }
}