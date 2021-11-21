class Solution {
    // 数学：构建前缀最大、后缀最小队列
    public int sumOfBeauties(int[] nums) {
        int len = nums.length;
        int[] preMax = new int[len];
        int[] surMin = new int[len];
        Arrays.fill(surMin, Integer.MAX_VALUE);
        for (int i = 1; i < len - 1; i++) {
            preMax[i] = Math.max(preMax[i - 1], nums[i - 1]);
            surMin[len - i - 1] = Math.min(surMin[len - i], nums[len - i]);
        }
        int result = 0;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] < surMin[i] && nums[i] > preMax[i]) {
                result += 2;
            } else if (nums[i] < nums[i + 1] && nums[i] > nums[i - 1]) {
                result++;
            }
        }
        return result;
    }
}