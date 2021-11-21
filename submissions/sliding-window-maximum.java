class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 固定长度滑动窗口： 单调递减双端队列
        // https://leetcode-cn.com/problems/sliding-window-maximum/solution/yi-ge-shi-pin-kan-dong-shuang-duan-dui-l-tqqn/
        // https://www.lintcode.com/problem/362/solution
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // move right: build cur window
            addTail(dq, nums[i]);
            if (i >= k - 1) {
                // get cur window
                res[i - k + 1] = dq.peekFirst();
                // remove left: prepare
                removeFront(dq, nums[i - k + 1]);
            }
        }
        return res;
    }

    private void removeFront(Deque<Integer> dq, int num) {
        if (dq.peekFirst() != num) {
            return;
        }
        dq.pollFirst();
    }

    private void addTail(Deque<Integer> dq, int num) {
        while (!dq.isEmpty() && dq.peekLast() < num) {
            dq.pollLast();
        }
        dq.offer(num);
    }
    /*
    @Test
    public void test1() {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = {3,3,5,5,6,7};
        Assert.assertArrayEquals(maxSlidingWindow(nums,k), res);
    }

    @Test
    public void test2() {
        int[] nums = {1,3,1,2,0,5};
        int k = 3;
        int[] res = {3,3,2,5};
        Assert.assertArrayEquals(maxSlidingWindow(nums,k), res);
    }
    */
}