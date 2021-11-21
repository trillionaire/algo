class Solution {
    // 二分法：左边界 + 右边界
    // https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/yi-wen-dai-ni-gao-ding-er-fen-cha-zhao-j-ymwl/
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        int left = 0;
        int right = nums.length - 1;
        // 第一个大于等于target
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 反面条件
            if (nums[mid] < target) { // mid太小，用右半边
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        result[0] = left;

        // 最后一个小于等于target
        left = 0;
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 反面条件
            if (nums[mid] > target) { // mid太大，用左半边
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        result[1] = right;
        if (result[0] > result[1]) {
            result = new int[] {-1, -1};
        }
        return result;
    }
}