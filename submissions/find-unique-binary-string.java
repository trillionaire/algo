class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = Arrays.stream(nums).collect(Collectors.toSet());
        for (String s : nums) {
            for (int i = 0; i < s.length(); i++) {
                char[] chars = s.toCharArray();
                chars[i] = (chars[i] == '1') ? '0' : '1';
                if (!set.contains(String.valueOf(chars))) {
                    return String.valueOf(chars);
                }
            }
        }
        return "";
    }
}