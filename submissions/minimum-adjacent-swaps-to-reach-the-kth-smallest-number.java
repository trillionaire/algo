class Solution {
    private int result;

    public int getMinSwaps(String num, int k) {
        char[] target = num.toCharArray();
        for (int i = 0; i < k; i++) {
            nextPermutation(target);
        }
        return dfs(num.toCharArray(), target, 0);
    }

    private int dfs(char[] source, char[] target, int start) {
        if (Arrays.equals(source, target)) {
            return 0;
        }
        int left = -1;
        int right = -1;
        int minCnt = Integer.MAX_VALUE;
        for (int i = start; i < target.length; i++) {
            if (left == -1 && source[i] != target[i]) {
                left = i;
            }
            if (left != -1 && target[left] == source[i]) {
                right = i;
                break;
            }
        }
        char tmp = source[right];
        for (int i = right; i > left; i--) {
            source[i] = source[i - 1];
        }
        source[left] = tmp;
        return dfs(source, target, start + 1) + right - left;
    }

    private void nextPermutation(char[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            // find[<--]: first asscending neighbours
            if (nums[i] < nums[i + 1]) {
                char c = nums[i];
                char minRight = nums[i + 1];
                int right = i + 1;
                // find[-->] min item which bigger than i
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] > nums[i] && nums[j] < minRight) {
                        minRight = nums[j];
                        right = j;
                    }
                }
                nums[i] = nums[right];
                nums[right] = c;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }
}