class Solution {
    // https://leetcode-cn.com/problems/sliding-window-median/solution/feng-xian-dui-chong-shuang-dui-dui-ding-hq1dt/
    // https://www.lintcode.com/problem/362/solution
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 0) {
            return new double[]{};
        }
        PriorityQueue<Integer> bigPq = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> smallPq = new PriorityQueue<Integer>();
        double[] res = new double[nums.length - k + 1];
        // 有模板
        for (int i = 0; i < nums.length; i++) {
            add(bigPq, smallPq, nums[i]);
            balance(bigPq, smallPq);
            if (i >= k - 1) {
                res[i - k + 1] = get(bigPq, smallPq, k);
                remove(bigPq, smallPq, nums[i - k + 1]);
                balance(bigPq, smallPq);
            }
        }
        return res;
    }

    private double get(PriorityQueue<Integer> bigPq, PriorityQueue<Integer> smallPq, int k) {
        return (k % 2 == 0) ? (0.5 * bigPq.peek() + 0.5 * smallPq.peek()) : bigPq.peek();
    }

    private void balance(PriorityQueue<Integer> bigPq, PriorityQueue<Integer> smallPq) {
        while (bigPq.size() < smallPq.size()) {
            bigPq.offer(smallPq.poll());
        }

        while (bigPq.size() > smallPq.size() + 1) {
            smallPq.offer(bigPq.poll());
        }
    }

    private void remove(PriorityQueue<Integer> bigPq, PriorityQueue<Integer> smallPq, int num) {
        if (num <= bigPq.peek()) {
            bigPq.remove(num);
        } else {
            smallPq.remove(num);
        }
    }

    private void add(PriorityQueue<Integer> bigPq, PriorityQueue<Integer> smallPq, int num) {
        if (bigPq.isEmpty() || num <= bigPq.peek()) {
            bigPq.add(num);
        } else {
            smallPq.add(num);
        }
    }
}