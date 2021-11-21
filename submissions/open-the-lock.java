class Solution {
    // BFS： blocks可以与visited合并
    public int openLock(String[] deadends, String target) {
        if (target.equals("0000")) {
            return 0;
        }
        int result = 0;
        Set<String> blocks = Arrays.stream(deadends).collect(Collectors.toSet());
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return result;
                }
                if (blocks.contains(cur)) {
                    continue;
                }
                blocks.add(cur);
                for (int j = 0; j < target.length(); j++) {
                    String next = getStr(cur, j, 1);
                    if (!blocks.contains(next)) {
                        queue.add(next);
                    }
                    String pre = getStr(cur, j, -1);
                    if (!blocks.contains(pre)) {
                        queue.add(pre);
                    }
                }
            }
            result++;
        }
        return -1;
    }


    private String getStr(String s, int i, int delta) {
        StringBuilder sb = new StringBuilder(s);
        if (delta == 1 && sb.charAt(i) == '9') {
            sb.setCharAt(i, '0');
            return sb.toString();
        }
        if (delta == -1 && sb.charAt(i) == '0') {
            sb.setCharAt(i, '9');
            return sb.toString();
        }
        sb.setCharAt(i, (char) (sb.charAt(i) + delta));
        return sb.toString();
    }
}