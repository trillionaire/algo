class Solution {
    public int minFlips(String s) {
        int len = s.length();
        s = s + s;
        int left = 0;
        int right = 0;
        int min = len;
        int cnt = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        int pos = 0;
        char[] chars = s.toCharArray();
        while (right < s.length()) {
            if (chars[right] % 2 == right % 2) {
                cnt1++;
            } else {
                cnt2++;
            }
            if (right - left + 1 == len) {
                cnt = Math.min(cnt1, cnt2);
                if (cnt < min) {
                    min = cnt;
                }
                if (chars[left] % 2 == left % 2) {
                    cnt1--;
                } else {
                    cnt2--;
                }
                left++;
            }
            right++;
        }
        return min;
    }
}