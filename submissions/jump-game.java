class Solution {
    // 单指针
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int right = 0;
        int max = 0;
        while (right < len) {
            max = Math.max(max, right + nums[right]);
            if (max >= len - 1) {
                return true;
            } else if (max > right) {
                right++;
            } else {
                return false;
            }
        }
        return true;
    }
}