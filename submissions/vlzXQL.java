class Solution {
    // DFS: 有向图 + 加权路径。 深度遍历时，注意有一条路径直接返回。一条都没有返回-1。
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildMap(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet());
        }
        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String from, String to, Set<String>  visited) {
        if (!graph.containsKey(from)) {
            return -1.0;
        }
        if (graph.get(from).containsKey(to)) {
            return graph.get(from).get(to);
        }
        if (visited.contains(from)) {
            return -1.0;
        }
        if (from.equals(to)) {
            return 1.0;
        }

        visited.add(from);
        for (Map.Entry<String, Double> entry : graph.get(from).entrySet()) {
            double cur = dfs(graph, entry.getKey(), to, visited);
            // NOTE: return if found one path
            if (cur >= 0) {
                return cur * entry.getValue();
            }
        }
        visited.remove(from);
        // NOTE: no path found
        return -1.0;
    }

    private Map<String, Map<String,Double>> buildMap(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> result = new HashMap();
        for (int i = 0; i < values.length; i++) {
            // from -> to
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            Map<String, Double> val = result.getOrDefault(from, new HashMap());
            val.put(to, values[i]);
            result.put(from, val);
            val = result.getOrDefault(to, new HashMap());
            val.put(from, 1.0 / values[i]);
            result.put(to, val);
        }
        return result;
    }
}