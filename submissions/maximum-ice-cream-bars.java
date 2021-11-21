class Solution {
    // 贪心：前缀和
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        if (costs[0] > coins) {
            return 0;
        }
        int[] preSums = new int[costs.length];
        preSums[0] = costs[0];
        for (int i = 1; i < costs.length; i++) {
            preSums[i] = preSums[i - 1] + costs[i];
            if (preSums[i] > coins) {
                return i;
            }
        }
        return costs.length;
    }
}