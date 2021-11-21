class Solution {
    public int maxCoins(int[] nums) {
        int[] nnums = new int[nums.length + 2];
        nnums[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            nnums[i+1] = nums[i];
        }
        nnums[nnums.length - 1] = 1;
        nums = nnums;

        int[][] dp = new int[nums.length][nums.length];
        for (int i = nums.length - 1; i >= 0 ; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + dp[k][j] + nums[i] * nums[k] * nums[j]);
                }        
            }
        }
        return dp[0][nums.length - 1];
    }
}