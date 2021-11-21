class Solution {
    public int missingNumber(int[] nums) {
        long res = 0;
        for (int num : nums) {
            res += num;
        }
        return (int)(nums.length * (nums.length + 1) / 2 - res);
    }
}