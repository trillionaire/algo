class Solution {
    // preSum + hash
    //https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/bao-li-jie-fa-qian-zhui-he-qian-zhui-he-you-hua-ja/
    public int subarraySum(int[] nums, int k) {
        // <sum, sumCount>
        Map<Integer, Integer> sumMap = new HashMap<>();
        // base case: <null, once>
        sumMap.put(0, 1);
        int sum = 0;
        int result = 0;
        for (int num : nums) {
            sum += num;
            result += sumMap.getOrDefault(sum - k, 0);
            int count = sumMap.getOrDefault(sum, 0) + 1;
            sumMap.put(sum, count);
        }
        return result;
    }
}