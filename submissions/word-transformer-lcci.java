class Solution {
    private List<String> result;
    public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
        result = new ArrayList();
        Map<String, Integer> map = new HashMap();
        for (String s : wordList) {
            if (!map.containsKey(s) && s.length() == endWord.length() && !s.equals(beginWord)) {
                map.put(s, 1);
            }
        }
        if (!map.containsKey(endWord)) {
            return result;
        }
        dfs(beginWord, endWord, map, new ArrayList<String>());
        return result;
    }

    private void dfs(String beginWord, String endWord, Map<String, Integer> map, ArrayList<String> path) {
        if (beginWord.equals(endWord)) {
            result = new ArrayList(path);
            result.add(endWord);
            return;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            if (!isValid(entry.getKey(), beginWord)) {
                continue;
            }
            entry.setValue(0);
            path.add(beginWord);
            dfs(entry.getKey(), endWord, map, path);
            // 剪支：无需回溯
            //entry.setValue(1);
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(String str1, String str2) {
        int diffCnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diffCnt++;
            }
            if (diffCnt > 1) {
                return false;
            }
        }
        return (diffCnt == 1);
    }
}