class Solution {
    // 二分 + 前缀和
    private int[] presum;
    public Solution(int[] w) {
        presum = new int[w.length];
        presum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            presum[i] = presum[i - 1] + w[i];
        }
    }
    
    public int pickIndex() {
        int target = (int)(Math.random() * presum[presum.length - 1]) + 1;
        return bsearch(target);
    }

    private int bsearch (int target) {
        int left = 0;
        int right = presum.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (presum[mid] == target) {
                return mid;
            } else if (presum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */