class Solution {
    // 单调栈：单调递减栈
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return (new int[0]);
        }
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * len; i++) {
            while (!stack.isEmpty() && (nums[stack.peek() % len] < nums[i % len])) {
                int cur = stack.pop();
                res[cur % len] = nums[i % len];
            }
            stack.push(i);
        }
        return res;
    }
}