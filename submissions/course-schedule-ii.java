class Solution {
    // 拓扑排序： BFS + 贪心
    public int[] findOrder(int n, int[][] conds) {
        List<Integer>[] adjlist = new ArrayList[n];
        int[] indegrees = new int[n];
        for (int i = 0; i < n; i++) {
            adjlist[i] = new ArrayList();
        }
        for (int i = 0; i < conds.length; i++) {
            adjlist[conds[i][1]].add(conds[i][0]);
            indegrees[conds[i][0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        int[] result = new int[n];
        int depth = 0;
        // 入度0进队列
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                result[depth++] = cur;
                for (int next : adjlist[cur]) {
                    if (--indegrees[next] == 0) {
                        queue.add(next);
                    }
                }
            }
        }
        return (depth == n) ? result : new int[0];
    }
}