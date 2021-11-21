class Solution {
    public int maxDistance(int[] position, int m) {
        int len = position.length;
        Arrays.sort(position);
        int left = 1;
        int right = (position[len - 1] - position[0]) / (m - 1);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(position, m, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private boolean isValid(int[] position, int m, int dist) {
        if (m == 2) {
            return position[position.length - 1] - position[0] >= dist;
        }
        int pre = 0;
        m--;
        for (int i = 1; i < position.length; i++) {
            if (position[i]- position[pre] < dist) {
                continue;
            }
            pre = i;
            m--;
            if (m > position.length - i - 1) {
                return false;
            }
            if (m == 1) {
                return position[position.length - 1] - position[i] >= dist;
            }
        }
        return false;
    }
}