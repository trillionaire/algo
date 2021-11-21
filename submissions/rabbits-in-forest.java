class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap();
        Set<Integer> set = new HashSet();
        for (int i : answers) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int cnt = e.getKey() + 1;
            int group = e.getValue() / cnt;
            if (e.getValue() % cnt != 0) {
                group++;
            }
            res += cnt * group;
        }
        return res;
    }
}