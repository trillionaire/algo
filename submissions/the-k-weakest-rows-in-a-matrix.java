class Solution {
    // 二分 + 优先队列
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int sum1 = getSum(mat[o1]);
                int sum2 = getSum(mat[o2]);
                if (sum1 != sum2) {
                    return sum1 - sum2;
                }
                return o1 - o2;
            }
        });
        for (int i = 0; i < mat.length; i++) {
            pq.add(i);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    private int getSum(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}