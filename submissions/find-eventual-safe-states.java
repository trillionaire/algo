class Solution {
    // 深度优先搜索 + 三色标记法
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        // 0: not visited, 1: no-safe, 2: safe
        int[] visited = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, visited)) {
                result.add(i);
            }
        }
        return result;
    }

    // is safe
    private boolean dfs(int[][] graph, int start, int[] visited) {
        if (visited[start] != 0) {
            return visited[start] == 2;
        }
        visited[start] = 1;
        for (int i = 0; i < graph[start].length; i++) {
            if (!dfs(graph, graph[start][i], visited)) {
                return false;
            }
        }
        visited[start] = 2;
        return true;
    }
}