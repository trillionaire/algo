class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        int start = 0;
        while (list.size() > 1) {
            int remains = list.size();
            int cur = (start + k - 1) % remains;
            list.remove(cur);
            start = cur;
        }
        return list.get(0);
    }
}