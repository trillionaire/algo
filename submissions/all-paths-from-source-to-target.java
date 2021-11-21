class Solution {
    // DFS    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList();
        int len = graph.length;
        List<Integer> path = new ArrayList();
        dfs(graph, 0, path, res);
        return res;
    }

    private void dfs(int[][] graph, int s, List<Integer> path, List<List<Integer>> res) {
        if (s == graph.length - 1) {
            path.add(s);
            res.add(path);
            return;
        }
        if (graph[s].length == 0) {
            return;
        }
        path.add(s);
        for (int i = 0; i < graph[s].length; i++) {
            // 创建新路径，所以不用回溯
            dfs(graph, graph[s][i], new ArrayList(path), res);
        }
    }
}