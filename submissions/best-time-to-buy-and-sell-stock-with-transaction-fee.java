class Solution {

    public int maxProfit(int[] prices, int fee) {
        int ret = 0;
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - low > fee) {
                ret += prices[i] - low - fee;
                low = prices[i] - fee;
            } else if (prices[i] < low) {
                low = prices[i];
            }
        }
        return ret;
    }
}