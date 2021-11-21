/*
267. 回文排列 II
给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。

如不能形成任何回文排列时，则返回一个空列表。

示例 1：

输入: "aabb"
输出: ["abba", "baab"]
示例 2：

输入: "abc"
输出: []
*/

// 全排列：折半变成全排列。注意可能有一个单


/*
    Set<String> result;
    public List<String> generatePalindromes(String s) {
        result = new TreeSet<String>();
        int length = s.length();
        Map<Character, Integer> map = getCharMap(s);
        StringBuilder path = new StringBuilder();
        int flag = isValid(map);
        int index = 0;
        if (flag == -1) {
            return result.stream().collect(Collectors.toList());
        }
        if (length % 2 != 0) {
            for(Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    path.append(entry.getKey());
                    entry.setValue(entry.getValue() - 1);
                    index++;
                }
            }
        }
        dfs(index, map, path, length);
        return result.stream().collect(Collectors.toList());
    }

    private void dfs(int index, Map<Character, Integer> map, StringBuilder path, int length) {
        if (path.length() == (length + 1) / 2) {
            result.add(getPath(path, length));
            return;
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }
            path.append(entry.getKey());
            entry.setValue(entry.getValue() - 2);
            dfs(index + 1, map, path, length);
            entry.setValue(entry.getValue() + 2);
            path.deleteCharAt(path.length() - 1);
        }
    }

    private String getPath(StringBuilder path, int length) {
        StringBuilder reverse = new StringBuilder(path);
        reverse.reverse();
        if (length % 2 != 0) {
            reverse.deleteCharAt(reverse.length() - 1);
        }
        return reverse.append(path).toString();
    }


    private int isValid(Map<Character, Integer> map) {
        int odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (++odd > 1) {
                    return -1;
                }
            }
        }
        return odd;
    }

    private Map<Character, Integer> getCharMap(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
        return map;
    }

*/