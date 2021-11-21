class Solution {
  public int wiggleMaxLength(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int ret = 1;
    int pre = 0;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] == nums[i-1]) { continue; }
        int cur = (nums[i] > nums[i-1]) ? 1 : -1;
        if (cur != pre) {
            ret++;
            pre = cur;
        }
    }
    return ret;
  }
}