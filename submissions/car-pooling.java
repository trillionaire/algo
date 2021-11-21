class Solution {
    // 差分数组
    // https://leetcode-cn.com/problems/car-pooling/solution/gou-zao-fu-zai-shu-zu-jian-cha-fu-zai-ji-ke-by-the/
    public boolean carPooling(int[][] trips, int capacity) {
        int[] capacityChanges = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            capacityChanges[trips[i][1]] -= trips[i][0];
            capacityChanges[trips[i][2]] += trips[i][0];
        }

        for (int i = 0;i < capacityChanges.length;i++) {
            capacity += capacityChanges[i];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}