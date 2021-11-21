class Solution {
    // 双指针+贪心： 从最大长度收窄，每次向内收窄短板（可能更大的面积）
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                result = Math.max(result, (right - left) * height[left]);
                left++;
            } else {
                result = Math.max(result, (right - left) * height[right]);
                right--;
            }
        }
        return result;
    }
}