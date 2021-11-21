class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap();
        List<String> res = new ArrayList<String>();
        int l = 0;
        int r = 0;
        while (r <= s.length()) {
            while (r > l + 10) {
                l++;
            }
            if ( r == l + 10) {
                String cur = s.substring(l, r);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                if (map.get(cur) == 2) {
                    res.add(cur);
                }
            }
            r++;
        }
        return res;
    }

}