class Solution {
    public boolean checkZeroOnes(String s) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int oneMax = 0;
        int zeroMax = 0;
        while (right < chars.length) {
            if (chars[right] == '0') {
                left = right + 1;
            } else {
                oneMax = Math.max(oneMax, right - left + 1);
            }
            right++;
        }
        left = 0;
        right = 0;
        while (right < chars.length) {
            if (chars[right] == '1') {
                left = right + 1;                
            } else {
                zeroMax = Math.max(zeroMax, right - left + 1);
            }
            right++;
        }
        return oneMax > zeroMax;
    }
}