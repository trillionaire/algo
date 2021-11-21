class Solution {
    // 单调栈：高度为弹出项
    // https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/zhao-liang-bian-di-yi-ge-xiao-yu-ta-de-zhi-by-powc/
    // https://pic.leetcode-cn.com/441ac778821dc26689b31466bced9f61ec241f092bf7e4f0f8699ef4fa3be1b2-1559826097853.png
    public int largestRectangleArea(int[] heights) {        
        if (heights == null || heights.length == 0) { return 0; }
        int len = heights.length;
        int res = heights[0];
        // 前后哨兵，值为0
        int[] newHeights = new int[len + 2];
        System.arraycopy(heights, 0, newHeights, 1, len);
        heights = newHeights;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int h = stack.pop();
                // pop case : 向左找第一个小于 heights[i] 的位置 left_i；向右找第一个小于于 heights[i] 的位置 right_i，即最大面积为 heights[i] * (right_i - left_i -1)
                res = Math.max(res, (i - stack.peek() - 1) * heights[h]);
            }
            stack.push(i);
        }
        return res;
    }
}