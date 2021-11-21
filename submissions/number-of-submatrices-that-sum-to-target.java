class Solution {
    // 二维前缀和 + HashMap优化
    // https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/solution/c-qian-zhui-he-ha-xi-by-da-li-wang/
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] preSum = new int[matrix.length + 1][matrix[0].length + 1];
        // 2d prefix sum
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                preSum[i+1][j+1] = matrix[i][j] + preSum[i+1][j] + preSum[i][j+1] - preSum[i][j];
            }
        }

        int res = 0;
        // keep regions in row [x1, x2]
        for(int x1 = 0; x1 < matrix.length; x1++) {
            for (int x2 = x1; x2 < matrix.length; x2++) {
                // optimize column complex by hashmap: column * column -> column
                // map[regions' preSum] = regions' count
                // equation: [y2's preSum] - [y1's preSum] == target
                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                map.put(0, 1);
                for (int y = 0; y < matrix[0].length; y++) {
                    // region[x1, 0, x2, y]
                    int cur = preSum[x2 + 1][y + 1] - preSum[x1][y + 1];
                    if (map.containsKey(cur - target)) {
                        res += map.get(cur - target);
                    }
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}