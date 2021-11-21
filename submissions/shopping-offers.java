class Solution {
    // DFS + 记忆化搜索
    public int shoppingOffers(List<Integer> prices, List<List<Integer>> specials, List<Integer> needs) {       
        // 建立备忘录: [needs，cost]
        // 可以用List做key：HashMap用equals判断key是否存在。而List的equals是遍历里面的元素，依次是否相等
        Map<List<Integer>, Integer> memo = new HashMap();
        return dfs(needs, prices, specials, memo);
    }

    private int dfs(List<Integer> needs, List<Integer> prices, List<List<Integer>> specials, Map<List<Integer>, Integer> memo) {
        if (memo.containsKey(needs)) {
            return memo.get(needs);
        }
        int result = 0;
        // 不选
        for (int i = 0; i < needs.size(); i++) {
            result += (needs.get(i) * prices.get(i));
        }
        // 遍历：是否可选择一个礼包
        for (int i = 0; i < specials.size(); i++) {
            List<Integer> special = specials.get(i);
            boolean flag = canUseSpecial(needs, special);
            if (!flag) { continue; }
            List<Integer> nextNeeds = updateNeeds(needs, special);
            // choose current special
            result = Math.min(result, dfs(nextNeeds, prices, specials, memo) + 
                    special.get(special.size() - 1));
        }
        memo.put(needs, result);
        return result;
    }

    private List<Integer> updateNeeds(List<Integer> needs, List<Integer> specials) {
        List<Integer> result = new ArrayList<Integer>(needs);
        for (int i = 0; i < needs.size(); i++) {
            result.set(i, result.get(i) - specials.get(i));
        }
        return result;
    }

    private boolean canUseSpecial(List<Integer> needs, List<Integer> special) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < special.get(i)) {
                return false;
            }
        }
        return true;
    }
}