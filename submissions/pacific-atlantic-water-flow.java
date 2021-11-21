class Solution {
    // DFS : 多源DFS，反向思考降低时间复杂度（从上下左右四条边出发，寻找能否到达另外对面）
    private final static int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] canReachP;
    private boolean[][] canReachA;
    private List<List<Integer>> result = new ArrayList();

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        result = new ArrayList();
        int m = heights.length;
        int n = heights[0].length;
        canReachP = new boolean[m][n];
        canReachA = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            dfs(heights, canReachA, i, 0);
            dfs(heights, canReachP, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, canReachA, 0, i);
            dfs(heights, canReachP, m - 1, i);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                    if (canReachA[i][j] && canReachP[i][j]) {
                        result.add(Arrays.asList(new Integer[]{i, j}));
                    }
            }
        }
        return result;
    }


    private void dfs(int[][] heights, boolean[][] canReach, int i, int j) {
        canReach[i][j] = true;

        for (int k = 0; k < DIRS.length; k++) {
            int nexti = i + DIRS[k][0];
            int nextj = j + DIRS[k][1];
            if (!isValid(heights, nexti, nextj) || canReach[nexti][nextj] || (heights[nexti][nextj] < heights[i][j])) {
                continue;
            }
            dfs(heights, canReach, nexti, nextj);
        }
        //canReach[i][j] = false;
    }

    private boolean isValid(int[][] heights, int i, int j) {
        return ((i >= 0) && (i < heights.length) && (j >= 0) && (j < heights[0].length));
    }
}