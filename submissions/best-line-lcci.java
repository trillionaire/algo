class Solution {
    public int[] bestLine(int[][] points) {
        // key: "index1_index2", val: all indexes
        Map<String, Set<Integer>> map = new HashMap<>();
        int[] res = {0, 1};
        int max = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                long[] delta = {points[j][0] - points[i][0], (points[j][1] - points[i][1])};
                int n = 0;
                for (int k = j + 1; k < points.length; k++) {
                    long[] next = {points[k][0] - points[i][0], points[k][1] - points[i][1]};
                    if (next[0] * delta[1] == next[1] * delta[0]) {
                        n++;
                    }
                }
                if (n > max) {
                    max = n;
                    res = new int[] {i, j};
                }
            }
        }
        return res;
    }
}