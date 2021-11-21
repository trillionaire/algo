class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int size = map.size();
        int res = 0;
        int i = 0;
        while (!map.isEmpty()) {
            Map.Entry<Integer, Integer> entry = map.pollLastEntry();
            int cnt = entry.getValue();
            res += cnt * (size - i - 1);
            i++;
        }
        return res;
    }
}