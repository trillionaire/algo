class Solution {
    // 并查集（DFU）: 并查集中可以随意交换
    // 注意：DFU模板
    private static class DFU {
        private int n;
        private int[] parents;
        public DFU(int n) {
            this.n = n;
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i; 
            }
        }

        public void union(int left, int right) {
            int leftp = find(left);
            int rightp = find(right);
            if (leftp < rightp) {
                parents[rightp] = leftp; // 注意： rightp，而不是right
            } else {
                parents[leftp] = rightp;
            }
        }

        public int find(int i) {
            if (i != parents[i]) { // 注意if，而不是while
                parents[i] = find(parents[i]); 
            }
            return parents[i];
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] result = s.toCharArray();
        DFU dfu = new DFU(s.length());
        for (List<Integer> pair : pairs) {
            dfu.union(pair.get(0), pair.get(1));
        }
        Map<Integer, List<Character>> charMap = new HashMap();
        Map<Integer, List<Integer>> indexMap = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            int parent = dfu.find(i);
            List<Character> curChars = charMap.getOrDefault(parent, new ArrayList());
            curChars.add(s.charAt(i));
            charMap.put(parent, curChars);
            List<Integer> curIndexes = indexMap.getOrDefault(parent, new ArrayList());
            curIndexes.add(i);
            indexMap.put(parent, curIndexes);
        }
        for (int parent : indexMap.keySet()) {
            List<Integer> indexes = indexMap.get(parent);
            List<Character> chars = charMap.get(parent);
            indexes.sort((a, b) -> (a - b));
            chars.sort((a, b) -> (a - b));
            for (int i = 0; i < indexes.size(); i++) {
                result[indexes.get(i)] = chars.get(i);
            }
        }
        return new String(result);
    }
}