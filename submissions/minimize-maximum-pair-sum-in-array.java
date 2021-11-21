class Solution {
    // 贪心
    public int minPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            result = Math.max(result, nums[i] + nums[j]);
        }
        return result;
    }
}