class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for (String s : strs) {
            String hashed = hash(s);
            List<String> list = map.getOrDefault(hashed, new ArrayList());
            list.add(s);
            map.put(hashed, list);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }
        return res;
    }

    private String hash(String s) {
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            sb.append(map[i]).append('a' + i);
        }
        return sb.toString();
    }
}