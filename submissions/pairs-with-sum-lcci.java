class Solution {
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        Set<Integer> set = new HashSet();
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int x = entry.getKey();
            int xCount = entry.getValue();
            int y = target - x;
            int yCount = map.getOrDefault(y, 0);
            if (set.contains(x) || yCount == 0) { continue; }
            if (x == y) {
                for (int i = 0; i < xCount / 2; i++) {
                    List<Integer> cur = new ArrayList<Integer>();
                    cur.add(x);
                    cur.add(y);
                    res.add(cur);
                }
            } else {
                for (int i = 0; i < Math.min(xCount, yCount); i++ ) {
                    List<Integer> cur = new ArrayList<Integer>();
                    cur.add(x);
                    cur.add(y);
                    res.add(cur);
                }
            }
            set.add(x);
            set.add(y);
        }
        return res;
    }
}