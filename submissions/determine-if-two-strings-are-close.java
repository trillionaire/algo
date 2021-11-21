class Solution {
    // 数学: 保持长度一致+字符个数一致+字符个数排序后一致
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            hash1[word1.charAt(i) - 'a']++;
            hash2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] == 0 && hash2[i] != 0) {
                return false;
            }
            if (hash2[i] == 0 && hash1[i] != 0) {
                return false;
            }
        }
        Arrays.sort(hash1);
        Arrays.sort(hash2);
        return Arrays.equals(hash1, hash2);
    }
}