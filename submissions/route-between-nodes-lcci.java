class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, Set<Integer>> g = build(graph);
        return dfs(g, start, target, new HashSet<Integer>());
    }

    private Map<Integer, Set<Integer>> build(int[][] graph) {
        Map<Integer, Set<Integer>> res = new HashMap();
        for (int[] edge : graph) {
            Set<Integer> adjs = res.getOrDefault(edge[0], new HashSet<>());
            adjs.add(edge[1]);
            res.put(edge[0], adjs);
        }
        return res;
    }

    private boolean dfs(Map<Integer, Set<Integer>> graph, int start, int target, Set<Integer> visited) {
        if (start == target) {
            return true;
        }
        visited.add(start);
        Set<Integer> adj = graph.getOrDefault(start, new TreeSet<Integer>());
        for (Integer next : adj) {
            if (visited.contains(next)) {
                continue;
            }
            if (dfs(graph, next, target, visited)) {
                return true;
            }
        }
        return false;
    }
}