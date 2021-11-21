class Solution {
    // 并查集
    class DFU {
        private int[] parents;

        DFU(int n) {
            parents = new int[n];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px < py) {
                parents[py] = px;
            } else {
                parents[px] = py;
            }
        }
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> posMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            posMap.put(nums[i], i);
        }
        DFU dfu = new DFU(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (posMap.containsKey(nums[i] - 1)) {
                dfu.union(posMap.get(nums[i] - 1), i);
            }
            if (posMap.containsKey(nums[i] + 1)) {
                dfu.union(posMap.get(nums[i] + 1), i);
            }
        }
        Map<Integer, Set<Integer>> freqs = new HashMap();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int parent = dfu.find(posMap.get(nums[i]));
            Set<Integer> set = freqs.getOrDefault(parent, new HashSet());
            set.add(nums[i]);
            freqs.put(parent, set);
        }
        for (Map.Entry<Integer, Set<Integer>> entry : freqs.entrySet()) {
            result = Math.max(result, entry.getValue().size());
        }
        return result;
    }

}