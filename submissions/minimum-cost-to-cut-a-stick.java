class Solution {
    public int minCost(int n, int[] cuts) {
        int[] ncuts = new int[cuts.length + 2];
        ncuts[0] = 0;
        for (int i = 0; i < cuts.length; i++) {
            ncuts[i+1] = cuts[i];
        }
        ncuts[cuts.length+1] = n;
        Arrays.sort(ncuts);
        int[][] memo = new int[ncuts.length][ncuts.length];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {
                memo[i][j] = -1;
            }
        }
        return minCost(n, ncuts, memo, 0, ncuts.length - 1);
    }

    private int minCost(int n, int[] cuts, int[][] memo, int l, int r) {
        if (memo[l][r] != -1) {
            return memo[l][r];
        }
        if (r <= l + 1) {
            memo[l][r] = 0;
            return memo[l][r];
        }

        int res = Integer.MAX_VALUE;
        for (int i = l + 1; i < r; i++) {
            int cur = minCost(n, cuts, memo, l, i);
            cur += minCost(n, cuts, memo, i, r);
            cur += (cuts[r] - cuts[l]);
            res = Math.min(res, cur);
        }
        memo[l][r] = res;
        return memo[l][r];
    }
}