class Solution {
    private static final String LB = "(";
    private static final String RB = ")";
    private Set<String> res;
    public List<String> generateParenthesis(int n) {
        res = new HashSet<String>();
        dfs(0, "", n);
        return res.stream().collect(Collectors.toList());
    }

    private void dfs(int delta, String path, int len) {
        if (path.length() == len * 2) {
            if (delta == 0) {
                res.add(path);
            }
            return;
        }
        if (delta != len) {
            dfs(delta + 1, new String(path) + LB, len);
        }
        if (delta != 0) {
            dfs(delta - 1, new String(path) + RB, len);
        }
    }

}