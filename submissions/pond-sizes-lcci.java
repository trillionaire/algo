class Solution {
    // DFS: 染色，记录在visited中
    private static int[] dx = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int[] dy = {1, 1, 1, 0, -1, -1, -1, 0};
    private boolean visited[][];
    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        visited = new boolean[m][n];
        List<Integer> list = new ArrayList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0 && !visited[i][j]) {
                    list.add(dfs(land, i, j));
                }
            }
        }
        return list.stream().sorted().mapToInt(Integer::valueOf).toArray();
    }

    private int dfs(int[][] land, int i, int j) {
        int m = land.length;
        int n = land[0].length;
        if (!isValid(i, j, m, n) || land[i][j] != 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int res = 1;
        for (int k = 0; k < dx.length; k++) {
            res += dfs(land, i + dx[k], j + dy[k]);
        }
        return res;
    }

    private boolean isValid(int i, int j, int maxi, int maxj) {
        return (0 <= i) && (i < maxi) && (0 <= j) && (j < maxj);
    }
}