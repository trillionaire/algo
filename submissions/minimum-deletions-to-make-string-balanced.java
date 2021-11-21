class Solution {
    // 数学：通过前缀和+后缀和求aaabbb的最大长度
    public int minimumDeletions(String s) {
        char[] chars = s.toCharArray();
        // a的前缀和
        int[] preSumA = new int[chars.length];
        // b的后缀和
        int[] surSumB = new int[chars.length];
        int result = 0;
        preSumA[0] = (chars[0] == 'a') ? 1 : 0;
        surSumB[chars.length - 1] = (chars[chars.length - 1] == 'b') ? 1 : 0;
        for (int i = 1; i < chars.length; i++) {
            preSumA[i] = preSumA[i - 1] + ((chars[i] == 'a') ? 1 : 0);
        }
        for (int i = chars.length - 2; i >= 0; i--) {
            surSumB[i] = surSumB[i + 1] + ((chars[i] == 'b') ? 1 : 0);
        }
        for (int i = 0; i < chars.length; i++) {
            result = Math.max(result, preSumA[i] + surSumB[i]);
        }
        return chars.length - result;        
    }
}