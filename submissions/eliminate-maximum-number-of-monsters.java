class Solution {
    // Greedy（贪心）：按到达城市的time排序，每次取最小的time
    public int eliminateMaximum(int[] dist, int[] speed) {
        int[] time = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            time[i] = (dist[i] / speed[i]);
            if (dist[i] % speed[i] != 0) {
                time[i] += 1;
            }
        }
        Arrays.sort(time);
        for (int i = 0; i < time.length; i++) {
            if (time[i] <= i) {
                return i;
            }
        }
        return time.length;
    }
}