class Solution {
    public int openLock(String[] deadends, String target) {
        int result = 0;
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        Set<String> blocked = Arrays.stream(deadends).collect(Collectors.toSet());
        if (blocked.contains("0000")) {
            return -1;
        }
        queue.add("0000");
        visited.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return result;
                }
                for (String next : getNextStr(cur)) {
                    if (blocked.contains(next) || visited.contains(next)) {
                        continue;
                    }
                    queue.add(next);
                    visited.add(next);
                }
            }
            result++;
        }
        return -1;
    }

    private List<String> getNextStr(String s) {
        List<String> result = new ArrayList();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char[] nextChars = chars.clone();
            nextChars[i] = getNextChar(chars[i], 1);
            result.add(new String(nextChars));
            nextChars = chars.clone();
            nextChars[i] = getNextChar(chars[i], -1);
            result.add(new String(nextChars));
        }
        return result;
    }

    private char getNextChar(char c, int delta) {
        int i = (c - '0') + delta;
        if (i < 0) {
            i += 10;
        } else if (i > 9) {
            i -= 10;
        }
        return (char) ('0' + i);
    }
}