class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> cur = new ArrayList();
            if (i == 1) {
                cur.add(1);
                res.add(cur);
                continue;
            }
            List<Integer> pre = res.get(res.size() - 1);
            cur.add(1);
            for (int j = 1; j < pre.size(); j++) {
                cur.add(pre.get(j - 1) + pre.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}