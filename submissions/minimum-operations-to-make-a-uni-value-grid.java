class Solution {
    // 数学：排序 + 中位数
    // 假设要让所有元素均为y，设小于y的元素有p个，大于y的元素有q个，可以发现：
    // 若 p<q，y每增加x，操作数就可以减小 q-p；若 p>q，y每减小x，操作数就可以减小 p-q；
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] sorted = new int[m * n];
        int mod = grid[0][0] % x;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sorted[i * n + j] = grid[i][j];
                if ( grid[i][j] % x != mod) {
                    return -1;
                }
            }
        }
        Arrays.sort(sorted);
        int median = sorted[(m * n - 1) / 2];
        int result = 0;
        for (int i = 0; i < sorted.length; i++) {
            result += Math.abs(median - sorted[i]) / x;
        }
        return result;
    }
}