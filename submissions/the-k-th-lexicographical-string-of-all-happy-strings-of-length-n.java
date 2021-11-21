class Solution {
    private static final String ABC = "abc";
    public String getHappyString(int n, int k) {
        TreeSet<String> tree = getHappyString(n);
        return (tree.size() >= k) ? (String) tree.toArray()[k - 1] : "";
    }

    private TreeSet<String> getHappyString(int n) {
        TreeSet<String> pre = new TreeSet<>();
        pre.add("a");
        pre.add("b");
        pre.add("c");
        for (int i = 1; i < n; i++) {
            TreeSet<String> cur = new TreeSet<>();
            for (String s : pre) {
                for (int j = 0; j < ABC.length(); j++) {
                    char c = s.charAt(s.length() - 1);
                    if (c != ABC.charAt(j)) {
                        cur.add(s + ABC.charAt(j));
                    }
                }
            }
            pre = cur;
        }
        return pre;
    }
}