class Solution {
    // 双指针：滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet();
        int result = 0;
        while (right < chars.length) {
            if (set.contains(chars[right])) {
                while (left < right && (chars[left] != chars[right])) {
                    set.remove(chars[left]);
                    left++;
                }
                left++;
            } else {
                set.add(chars[right]);
                result = Math.max(result, right - left + 1);
            }
            right++;
        }
        return result;
    }
}