class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }
        List<Integer>[] graph = BuildGraph(n, connections);
        int color = 0;
        int[] list = new int[n];
        for (int i = 0; i < n; i++) {
            if (list[i] == 0) {
                dfs(graph, list, i, ++color);
            }
        }
        return color  - 1;
    }

    private void dfs(List<Integer>[] graph, int[] list, int start, int color) {        
        if (list[start] == color) {
            return;
        }
        list[start] = color;
        for(Integer i : graph[start]) {
            dfs(graph, list, i, color);
        }
    }

    private List<Integer>[] BuildGraph(int n, int[][] connections) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int[] conn : connections) {
            int pre = Math.min(conn[0], conn[1]);
            int next = Math.max(conn[0], conn[1]);
            graph[pre].add(next);
            graph[next].add(pre);

        }
        return graph;
    }
}