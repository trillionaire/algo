class Solution {
    // 双指针：记录当前找到字母
    public int findClosest(String[] words, String word1, String word2) {
        int left = -1;
        int right = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                left = i;
            }
            if (words[i].equals(word2)) {
                right = i;
            }
            if (left != -1 && right != -1) {
                result = Math.min(result, Math.abs(right - left));
            }
        }
        return result;
    }
}