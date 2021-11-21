class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int res = 0;
        int i = 0;
        while (true) {
            if (i >= nums.length - 1) {
                return res;
            }
            res++;
            int maxIndex = i;
            int maxVal = i + nums[i];
            if (maxVal >= nums.length - 1) {
                return res;
            }
            for (int j = i + 1; j <= Math.min(i + nums[i], nums.length - 1); j++) {
                int tmp = nums[j] + j;
                if (tmp >= maxVal) {
                    maxIndex = j;
                    maxVal = tmp;
                }
            }
            i = maxIndex;
        }
        //return res;
    }
}