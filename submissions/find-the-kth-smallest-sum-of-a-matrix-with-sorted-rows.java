class Solution {
    // 最小堆 + BFS ：每次弹出最小堆顶相邻的n行，重复k遍。节点为int[],内容时每行索引+和。visited为节点的Arrays.toString()值
    // 原理：第二小的数组必然由最小的数组经过一步变化达到，第三小的数组必然由最小的数组或者第二小的数组经过一步变化达到，以此类推
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[a.length - 1] - b[a.length - 1];
            }
        });
        Set<String> visited = new HashSet();
        int[] cur = new int[m + 1];
        for (int i = 0; i < m; i++) {
            cur[m] += matrix[i][cur[i]];
        }
        pq.add(cur);
        visited.add(hash(cur));
        int times = 1;
        while (times < k) {
            int[] min = pq.poll();
            for (int i = 0; i < m; i++) {
                if (min[i] == n - 1) {
                    continue;
                }
                int[] next = Arrays.copyOf(min, min.length);
                next[i]++;
                next[m] += (matrix[i][next[i]] - matrix[i][next[i] - 1]);
                if (!visited.contains(hash(next))) {
                    pq.add(next);
                    visited.add(hash(next));
                }
            }
            times++;
        }
        return pq.poll()[matrix.length];
    }

    private String hash(int[] cur) {
        return Arrays.toString(cur);
    }
}