class Solution {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        List<Integer> res = new ArrayList<>();
        int[] hash = new int[26];
        int l = 0;
        int r = 0;
        for (int i = 0; i < chars.length; i++) {
            hash[chars[i] - 'a'] = i;
        }
        int range = 0;
        while (r < chars.length) {
            range = Math.max(range, hash[chars[r] - 'a']);
            if (range == r) {
                res.add(r - l + 1);
                l = r + 1;
            }
            r++;
        }
        return res;
    }
}