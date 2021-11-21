class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // 滑动窗口模板： TreeMap优化
        // https://leetcode-cn.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/solution/he-gua-de-shu-ju-jie-gou-hua-dong-chuang-v46j/
        int l = 0;
        int r = 0;
        int res = 0;
        // map: val, count
        TreeMap<Integer, Integer> map = new TreeMap();
        while (r < nums.length) {
            // handle right
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            // move left : find valid
            while ((l < r) && (Math.abs(map.firstKey() - map.lastKey()) > limit)) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            // valid window
            res = Math.max(res, r - l + 1);
            // move right : one by one
            r++;
        }
        return res;
    }
}