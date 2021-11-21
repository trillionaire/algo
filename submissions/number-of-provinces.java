class Solution {
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
    public int findCircleNum(int[][] matrix) {
        DFU dfu = new DFU(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    dfu.union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet();
        for (int i = 0; i < matrix.length; i++) {
            set.add(dfu.find(i));
        }
        return set.size();
    }
}