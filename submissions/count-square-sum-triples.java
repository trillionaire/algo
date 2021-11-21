class Solution {
    public int countTriples(int n) {
        Set<Integer> set = new HashSet();
        for (int i = 1; i < n; i++) {
            set.add(i * i);
        }
        int result = 0;
        for (int r = 1; r <= n; r++) {
            for (int l = 1; l * l < r * r / 2; l++) {
                if (set.contains(r * r - l * l)) {
                    result++;
                }
            }
        }
        return result * 2;
    }
}