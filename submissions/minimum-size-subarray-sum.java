class Solution {
    // 双指针
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            // 移动right后可行，则记录
            if (sum >= target) {
                result = Math.min(result, right - left + 1);
                // 接着，移动left直至不可行
                while (left < right) {
                    sum -= nums[left++];
                    if (sum >= target) {
                        result = Math.min(result, right - left + 1);
                    } else {
                        break;
                    }
                }
            }
            right++;
        }
        return (result == Integer.MAX_VALUE) ? 0 : result;
    }
}