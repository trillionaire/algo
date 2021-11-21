class Solution {
    private boolean result;
    public boolean circularArrayLoop(int[] nums) {
        result = false;
        for (int i = 0; i < nums.length; i++) {
            if (dfs(nums, i, (nums[i] > 0), new ArrayList<Integer>())) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int[] nums, int start, boolean forward, ArrayList<Integer> path) {
        if ((nums[start] > 0) != forward) {
            return false;
        }
        if (!path.isEmpty() && path.get(0) == start) {
            return path.size() > 1;
        }
        if (path.size() > nums.length) {
            return false;
        }
        path.add(start);
        int next = start + nums[start];
        next = next % nums.length;
        next = (next < 0) ? (next + nums.length) : next;
        boolean result = dfs(nums, next, forward, path);
        path.remove(path.size() - 1);
        return result;
    }
}