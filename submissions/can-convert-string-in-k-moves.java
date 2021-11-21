class Solution {
    // 数学: 使用[gap, count]的哈希表。表中，每个gap的数量不超过最大轮次，且最后一轮仅能在前remain项中出现。
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        // 哈希：[gap, count]
        int[] gaps = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int gap = t.charAt(i) - s.charAt(i);
            gap = (gap < 0) ? (gap + 26) : gap;
            if (gap != 0) {
                gaps[gap]++;
            }
        }
        // 判断：每个gap的数量不超过轮次，且最后一轮仅能在前remain项
        int round = k / 26 + 1;
        int remain = k % 26;
        int count = 0;
        for (int i = 1; i < gaps.length; i++) {
            if (round < gaps[i]) {
                return false;
            }
            if (round == gaps[i] && (i > remain)) {
                return false;
            }
        }
        return true;
    }
}