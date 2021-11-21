class Solution {
    // DFU：并查集
    class DFU {
        private int[] parents;
        DFU(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }
        public int find(int x) {
            if (x != parents[x]) {
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px < py) {
                parents[py] = px;
            } else {
                parents[px] = py;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        DFU dfu = new DFU(edges.length);
        Set<Integer> set = new HashSet();
        for (int i = 0; i < edges.length - 1; i++) {
            int from = edges[i][0] - 1;
            int to = edges[i][1] - 1;
            if (dfu.find(from) == dfu.find(to)) {
                return edges[i];
            }
            dfu.union(from, to);
        }
        return edges[edges.length - 1];
    }
}