class Solution {
    // 单调栈：递减栈
    public int[] dailyTemperatures(int[] temps) {
        int[] result = new int[temps.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < temps.length; i++) {
            // 前面元素，出栈直到栈顶比大于当前元素
            while (!stack.isEmpty() && temps[stack.peek()] < temps[i]) {
                int pre = stack.pop();
                result[pre] = i - pre;
            }
            // 当前元素入栈
            stack.push(i);
        }
        return result;
    }
}