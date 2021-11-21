class Solution {
    // 双指针：
    public int maxProfit(int[] prices) {
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < prices.length) {
            // right价格最大，更新结果
            if (prices[right] - prices[left] > result) {
                result = prices[right] - prices[left];                
            }
            // 当right价格低于left价格，移动left
            if (prices[right] < prices[left]) {
                left = right;
            }
            right++;
        }
        return result;
    }
}