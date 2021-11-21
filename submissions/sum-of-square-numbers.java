class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i*i);
        }
        for (Integer i : set) {
            int remain = c - i;
            if (set.contains(remain)) {
                return true;
            }
        }
        return false;
    }
}