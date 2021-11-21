class Solution {
    // 双指针
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int left = 0;
        int right = 1;
        int len = 0;
        int gap = Integer.MIN_VALUE;
        int result = 0;
        while (right < nums.length) {
            len = right - left + 1;
            int curGap = nums[right] - nums[right - 1];
            if (gap != curGap) {
                gap = curGap;
                left = right - 1;
            } else {
                if (len >= 3) {
                    result += (len - 2);
                }
            }
            right++;
        }
        return result;
    }
}