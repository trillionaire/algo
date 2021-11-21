class Solution {
    // 双指针
    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0;
        int res = 0;
        int l = 0;
        int r = 0;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        while (r < s.length()) {
            cost += Math.abs(sc[r] - tc[r]);
            while (cost > maxCost) {
                cost -= Math.abs(sc[l] - tc[l]);
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }

}