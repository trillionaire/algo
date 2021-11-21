class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1.length() == o2.length() ? o1.compareTo(o2) : o2.length() - o1.length());
            }
        });
        Map<String, Integer> map = new HashMap<String, Integer>();
        Arrays.stream(words).forEach(s->map.put(s, map.getOrDefault(s, 0) + 1));
        for (String s : words) {
            Map<String, Integer> remains = new HashMap(map);
            remains.put(s, remains.get(s) - 1);
            if (remains.get(s) == 0) {
                remains.remove(s);
            }
            if (dfs(s, remains)) {
                return s;
            }
        }
        return "";
    }

    private boolean dfs(String s, Map<String, Integer> set) {
        if (s.equals("")) {
            return true;
        }
        for (Map.Entry<String, Integer> entry : set.entrySet()) {
            String remain = entry.getKey();
            if (s.startsWith(remain)) {
                String newS = s.substring(remain.length());
                if (dfs(newS, set)) {
                    return true;
                }
            }
        }
        return false;
    }
}