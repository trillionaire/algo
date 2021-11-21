class Solution {
    // 二分： 二分+递归
    public int findPeakElement(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        while (left < right) { // 注意：不能<=, mid+1会溢出
            int mid = (left + right) / 2;
            int lmax = find(nums, left, mid);
            int rmax = find(nums, mid + 1, right);
            return (nums[lmax] > nums[rmax]) ? lmax : rmax;
        }
        return left;
    }
}