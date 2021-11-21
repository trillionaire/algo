class Solution {
    // 左右指针：正向找到第一个不一致的为left，反向找到第一个不一致的为right
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int left = -1;
        int right = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sorted[i]) {
                left = i;
            } else {
                break;
            }
        }
        for (int i = nums.length - 1; i > left; i--) {
            if (nums[i] == sorted[i]) {
                right = i;
            } else {
                break;
            }
        }
        return right - left - 1;
    }
}