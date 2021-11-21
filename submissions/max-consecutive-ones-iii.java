class Solution {
    public int longestOnes(int[] A, int K) {
        int l = 0;
        int r = 0;
        int remain = K;
        int res = 0;
        while (r < A.length) {
            if (A[r] == 0) { remain -= 1; }
            while (remain < 0) {
                if (A[l] == 0) { remain += 1;}
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}