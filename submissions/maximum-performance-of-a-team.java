class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] map = new int[speed.length][2];
        for (int i = 0; i < speed.length; i++) {
            map[i][0] = speed[i];
            map[i][1] = efficiency[i];
        }
        Arrays.sort(map, (a, b) -> (b[1] - a[1]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        long sumOfSpeed = 0;
        long minEff = Integer.MAX_VALUE;
        long res = 0;
        for (int i = 0; i < map.length; i++) {
            if (pq.size() > k - 1) {
                sumOfSpeed -= pq.poll()[0];
            }
            pq.offer(map[i]);
            sumOfSpeed += map[i][0];
            res = Math.max(res, sumOfSpeed * map[i][1]);
        }
        return (int) (res % 1000000007);
    }
}