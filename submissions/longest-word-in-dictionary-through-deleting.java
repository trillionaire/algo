class Solution {
    // 贪心+排序+hash表
    // 先排序（主长度降序，次字典升序），再依次检查字符串。
    // 检查字符：将源字符的位置hash起来，遍历被检查字符串的字符，根据记录位置搜索。
    public String findLongestWord(String s, List<String> dic) {
        Map<Character, List<Integer>> charMap = getCharFreqMap(s);
        dic.sort((a, b) -> ((b.length() != a.length()) ? (b.length() - a.length()) : a.compareTo(b)));
        for (int i = 0; i < dic.size(); i++) {
            if (check(dic.get(i), charMap)) {
                return dic.get(i);
            }
        }
        return "";
    }

    private boolean check(String s, Map<Character, List<Integer>> charMap) {
        char[] chars = s.toCharArray();
        int pre = -1;
        for (int i = 0; i < chars.length; i++) {
            if (!charMap.containsKey(chars[i])) {
                return false;
            }
            int next = get(charMap.get(chars[i]), pre);
            if (next == -1) {
                return false;
            } else {
                pre = next;
            }
        }
        return true;
    }
    private int get(List<Integer> list, int pre) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= pre) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == list.size() || list.get(left) <= pre) {
            return -1;
        }
        return list.get(left);
    }

    private Map<Character, List<Integer>> getCharFreqMap(String s) {
        char[] chars = s.toCharArray();
        Map<Character, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> list = result.getOrDefault(chars[i], new ArrayList<Integer>());
            list.add(i);
            result.put(chars[i], list);
        }
        return result;
    }
}