class Solution {
    // 二分 + 前缀和
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int[] preSums = new int[nums.length];
        preSums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSums[i] = nums[i] + preSums[i - 1];
        }
        int left = 1;
        int right = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, preSums, k, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean isValid(int[] nums, int[] preSums, int k, int cnt) {
        if (cnt == 1) {
            return true;
        }
        for (int j = cnt - 1; j < nums.length; j++) {
            int sum = 0;
            if (j  == cnt - 1) {
                sum = nums[j] * (cnt - 1) - preSums[j - 1];
            } else {
                sum = nums[j] * (cnt - 1) - preSums[j - 1] + preSums[j - cnt];
            }
            if (sum <= k) {
                return true;
            }
        }
        return false;
    }
}