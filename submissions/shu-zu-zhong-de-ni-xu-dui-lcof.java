class Solution {
    // 归并排序：过程中记录逆序对
    // https://pic.leetcode-cn.com/1614274007-ounrkz-Picture13.png
    private int max = 0;
    public int reversePairs(int[] nums) {
        if (nums.length < 2) return 0;
        max = 0;
        merge(nums, 0, nums.length - 1);
        return max;
    }

    public int[] merge(int[] nums, int start, int end) {
        if (start == end) {
            return new int[]{nums[start]};
        }
        int mid = start + (end - start) / 2;
        // devide
        int[] leftNums = merge(nums, start, mid);
        int[] rightNums = merge(nums, mid + 1, end);
        int[] res = new int[end - start + 1];
        int index = 0;
        int lIndex = 0;
        int rIndex = 0;
        // merge
        while (lIndex < leftNums.length && rIndex < rightNums.length) {
            // 左边当前 > 右边当前：右边当前记入结果，并处理逆序对（左边当前之后的子序列个数）
            if (leftNums[lIndex] > rightNums[rIndex]) {
                max += leftNums.length - lIndex;
                res[index++] = rightNums[rIndex++];
            } else {
                res[index++] = leftNums[lIndex++];
            }
        }
        //处理剩余左边
        while (lIndex < leftNums.length) {
            res[index++] = leftNums[lIndex++];
        }
        //处理剩余右边
        while (rIndex < rightNums.length) {
            res[index++] = rightNums[rIndex++];
        }
        return res;
    }
}