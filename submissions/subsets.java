class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList<Integer>());
        for (int num : nums) {
            List<List<Integer>> cur = cloneList(result);
            for (List<Integer> list : cur) {
                list.add(num);
            }
            result.addAll(cur);
        }
        return result;
    }

    private List<List<Integer>> cloneList(List<List<Integer>> source) {
        List<List<Integer>> result = new ArrayList();
        for(List<Integer> list : source) {
            List<Integer> cur = new ArrayList();
            for (int i : list) {
                cur.add(i);
            }
            result.add(cur);
        }
        return result;
    }

}