class Solution {
    // 哈希 + 排列组合
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> freqMap = new HashMap();
        for(String num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (int i = 1; i <= target.length(); i++) {
            String prefix = target.substring(0, i);
            String suffix = target.substring(i);
            if (!freqMap.containsKey(prefix) || !freqMap.containsKey(suffix)) {
                continue;
            }
            if (prefix.equals(suffix)) {
                result += freqMap.get(prefix) * (freqMap.get(prefix) - 1);
            } else {
                result += freqMap.get(prefix) * freqMap.get(suffix);
            }
        }
        return result;
    }
}