class Solution {
    // 二分+贪心： 二分求解，求与nums2[index]对应nums1中的最小差值。
    // 用贪心剪枝，按abs(nums1[index] - nums2[index])降序建优先队列，遍历记录每次变化能变小的最大值delta，如delta已经大于队头的abs(nums1[index] - nums2[index])，后续都不用再遍历。
    private static final int MOD = 1000000007;
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long result = 0;
        int len = nums1.length;
        // down by gap
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(nums2[o2] - nums1[o2]) - Math.abs(nums2[o1] - nums1[o1]);
            }
        });
        for (int i = 0; i < len; i++) {
            result += Math.abs(nums1[i] - nums2[i]);
            result %= MOD;
            queue.add(i);
        }
        int[] sorted = nums1.clone();
        Arrays.sort(sorted);
        int delta = 0;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (delta > Math.abs(nums2[index] - nums1[index])) {
                break;
            }
            int gap = getGap(sorted, nums2[index]);
            int preGap = Math.abs(nums1[index] - nums2[index]);
            delta = Math.max(delta, preGap - gap);
        }
        return (int)(result - delta + MOD) % MOD;
    }

    private int getGap(int[] sorted, int val) {
        int left = 0;
        int right = sorted.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sorted[mid] > val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (right == sorted.length - 1) {
            return Math.abs(sorted[right] - val);
        }
        if (right == -1) {
            return Math.abs(sorted[0] - val);
        }
        return Math.min(Math.abs(sorted[right] - val), Math.abs(sorted[left] - val));
    }
}