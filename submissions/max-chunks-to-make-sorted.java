class Solution {
    // 单点栈
    public int maxChunksToSorted(int[] arr) {
        // 2, 1, 0, 4, 3
        Deque<Integer> stack = new ArrayDeque<Integer>();
        // 维持单调增栈
        for (int i = 0; i < arr.length; i++) {
            // cur大于栈顶时，入栈
            if (stack.isEmpty() || arr[stack.peekLast()] < arr[i]) {
                stack.add(i);
                continue;
            }
            // cur小于栈顶时，栈内所有大于cur的分为一组，用栈顶表示。
            int top = stack.peekLast();
            while (!stack.isEmpty() && arr[stack.peekLast()] > arr[i]) {
                stack.removeLast();
            }
            stack.addLast(top);
        }
        return stack.size();
    }

/*  // 数学
    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int max = -1;
        // 如果前N个数字最大的肯定是N，那么当遍历到i位置时： i == 前N个最大的数字，当前位置可加分为一个单独块。
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (i == max) {
                res++;
            }
        }
        return res;
    }
*/
}