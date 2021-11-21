class Solution {
    public int[] shortestSeq(int[] big, int[] small) {
        int[] result = new int[2];
        Set<Integer> set = Arrays.stream(small).boxed().collect(Collectors.toSet());
        Map<Integer, Integer> map = new HashMap<>();
        set.stream().forEach(a -> map.put(a, 0));
        Set<Integer> remain = new HashSet<Integer>(set);
        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        while (r < big.length) {
            if (set.contains(big[r])) {
                remain.remove(big[r]);
                map.put(big[r], map.get(big[r]) + 1);
                if (remain.isEmpty()) {
                    // found
                    if (minLen > r - l + 1) {
                        result[0] = l;
                        result[1] = r;
                        minLen = r - l + 1;
                    }
                }
            }
            while (l <= r && remain.isEmpty()) {
                if (minLen > r - l + 1) {
                    result[0] = l;
                    result[1] = r;
                    minLen = r - l + 1;
                }
                if (map.containsKey(big[l])) {
                    map.put(big[l], map.get(big[l]) - 1);
                    if (map.get(big[l]) == 0) {
                        remain.add(big[l]);
                    }
                }
                l++;
            }
            r++;
        }
        return (minLen == Integer.MAX_VALUE) ? new int[0] : result;
    }
}