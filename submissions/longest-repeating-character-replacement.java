class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxCount = 0;
        int res = 0;
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        while (r < chars.length) {
            map[chars[r] - 'A']++;
            if (map[chars[r] - 'A'] > maxCount) {
                maxCount = map[chars[r] - 'A'];
            }
            while ( l < r && r - l + 1 - maxCount > k) {
                map[chars[l] - 'A']--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}