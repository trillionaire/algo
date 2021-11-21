class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > Math.ceil(hour)) return -1;

        int left = 1;
        int right = Integer.MAX_VALUE;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReached(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean canReached(int[] dist, double hour, long speed) {
        double time = 0;
        for (int i = 0; i < dist.length; i++) {
            if (i != dist.length - 1) {
                time += (dist[i] + speed - 1) / speed;
            } else {
                time += (double)dist[i] / speed;
            }
        }
        return time <= hour;
    }

}