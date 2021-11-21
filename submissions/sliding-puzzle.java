class Solution {
    int[][] delta = {{1, 3},{0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    public int slidingPuzzle(int[][] board) {
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        
        String src = toString(board);
        String target = "123450";
        queue.add(src);
        visited.add(src);
        int depth = 0;

        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String s = queue.poll();
                if (s.equals(target)) {
                    return depth;
                }
                int pos = find(s);
                for (int j = 0; j < delta[pos].length; j++) {
                    String next = replace(s, pos, delta[pos][j]);
                    if (!visited.contains(next)) {
                        queue.add(next);
                        visited.add(next);
                    }
                }
            }
            depth++;
        } 
        return -1;
    }

    private String toString(int[][] board) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                builder.append(board[i][j]);
            }
        }
        return builder.toString();
    }

    private int find(String s) {
        return s.indexOf('0');
    }
    private String replace(String s, int p1, int p2) {
        char[] chars = s.toCharArray();
        char tmp = chars[p1];
        chars[p1] = chars[p2];
        chars[p2] = tmp;
        return String.valueOf(chars);
    }
}