class Solution {
    // 双指针 + 排序
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int k = 2; k < nums.length; k++) {
            for (int j = k - 1, i = 0; i < j; j--) {
                while (i < j && nums[i] + nums[j] <= nums[k]) {
                    i++;
                }
                result += (j - i);
            }
        }
        return result;
    }
}