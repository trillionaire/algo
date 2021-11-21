class Solution {
    public int numWays(String s) {
        char[] chars = s.toCharArray();
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                indexes.add(i);
            }
        }
        if (indexes.size() % 3 != 0) {
            return 0;
        }
        if (indexes.size() == 0) {
            long res = s.length() - 1;
            res *= (s.length() - 2);
            res /= 2;
            res %= 1000000007;
            return (int) res;
        }
        int cnt = indexes.size() / 3;
        long res = indexes.get(cnt) - indexes.get(cnt - 1);
        res *= (indexes.get(cnt * 2) - indexes.get(cnt * 2 - 1));
        res %= 1000000007;
        return (int) res;
    }
}