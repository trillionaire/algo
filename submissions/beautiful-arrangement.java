class Solution {
    public int countArrangement(int N) {
        List<Integer> set = new ArrayList();
        return backtrace(set, N);
    }

    private int backtrace(List<Integer> visited, int left) {
        // end case
        if (left == 0) {
            return 1;
        }
        Set<Integer> set = new HashSet(visited);
        // backtrace
        int res = 0;
        for (int i = 1; i <= visited.size() + left; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (i % left != 0 && left % i != 0) {
                continue;
            }
            visited.add(i);
            res += backtrace(visited, left - 1);
            visited.remove(visited.size() - 1);
        }
        return res;
    }
}