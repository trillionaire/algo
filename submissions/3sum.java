class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 初始判断，不满足三数条件，直接返回空集
        if(nums.length < 3){
            return res;
        }

        // 对数组进行排序，方便下一步操作
        Arrays.sort(nums);

        // 遍历数组，0 <= i < left < right < nums.length
        // 三数和为0，即nums[left] + nums[right] = -nums[i]
        for(int i = 0; i < nums.length - 2; i++){
            // 思考1: 此时数组有序，如果当前元素大于0，那么0之后的元素不可能小于0
            if(nums[i] > 0) {
                return res;
            }

            // 思考2: 题目要求不可包含重复元素，此时数组有序，判断当前元素和上一个元素是否相等，然后跳过即可
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            // 双指针夹逼：寻找两数和为-nums[i]的元素
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            while (left < right) {
                int num = nums[left] + nums[right];
                if (num < target) {
                    // 如果后序两数和小于-nums[i]，则移动left
                    left ++;
                } else if(num > target) {
                    // 如果后序两数和大于-nums[i]，则移动right
                    right --;
                } else {
                    // 如果都不是，则表示找到一组结果
                    List<Integer> cur = new ArrayList<>(3);
                    cur.add(nums[i]);
                    cur.add(nums[left]);
                    cur.add(nums[right]);
                    res.add(cur);
                    // 思考3: 左右指针移动时有无可能出现重复元素，所以去除重复元素
                    while (left < right && nums[left + 1] == nums[left]) {
                        left++;
                    }
                    while(left < right && nums[right - 1] == nums[right]) {
                        right--;
                    }
                    // 注意找到一组元素后，继续移动指针
                    ++left;
                    --right;
                }
            }
        }
        return res;
    }
}