class Solution {
    // 二分：按值二分。最小值为最大包裹重量，最大值为包裹总重量。找左边界。
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(weights, mid) > days) {
                left =  mid + 1;
            } else {
                right =  mid - 1;
            }
        }
        return left;
    }

    private int check (int[] weights, int max) {
        int result = 1;
        int sum = 0;
        for (int i = 0; i < weights.length; i++) {
            if (sum + weights[i] > max) {
                result++;
                sum = weights[i];
            } else {
                sum += weights[i];
            }
        }
        return result;
    }
}