class Solution {
    // 双指针：判断窗口内T/F的数量，如果有一个超过winLen - k即满足，移动right。否则，移动left。
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] chars = answerKey.toCharArray();
        int left = 0;
        int right = 0;
        int result = 0;
        int tCnt = 0;
        int fCnt = 0;
        while (right < chars.length) {
            if (chars[right] == 'T') {
                tCnt++;
            } else {
                fCnt++;
            }
            int len = right - left + 1;
            if (tCnt >= len - k || fCnt >= len - k) {
                result = Math.max(result, len);
            } else {
                while (left < right) {
                    if (chars[left] == 'T') {
                        tCnt--;
                    } else {
                        fCnt--;
                    }
                    left++;
                    len = right - left + 1;
                    if (tCnt >= len - k || fCnt >= len - k) {
                        break;
                    }
                }
            }
            right++;
        }
        return result;
    }
}