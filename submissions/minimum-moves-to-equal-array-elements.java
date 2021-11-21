class Solution {
    // 数学： n - 1个元素+1，反向看即1个元素-1
    public int minMoves(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result += (nums[i] - nums[0]);
        }
        return result;
    }
}