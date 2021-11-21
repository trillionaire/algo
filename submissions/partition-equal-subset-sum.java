class Solution {
    public boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, sum1 = 0, sum2 = 0;
        if (len < 2) return false;
        for (int i = len - 1; i > -1; i--) {
            if (sum1 < sum2) {
                sum1 += nums[i];
            } else {
                sum2 += nums[i];
            }
        }
        if (sum1 == sum2) return true;
        if ((sum1 + sum2) % 2 == 1) return false;
        sum1 = (sum1 + sum2) >> 1;
        sum2 = sum1;
        for (int i = len - 1; i > -1; i--) {
            if (sum1 < nums[i]) {
                sum2 -= nums[i];
            } else {
                sum1 -= nums[i];
            }
        }
        return sum1 == sum2;
    }
}