class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        boolean r0 = isCommon(A, B, A[0]);
        boolean r1 = isCommon(A, B, B[0]);

        int res = 20000;
        if (r0) {
            res = Math.min(res, count(A, A[0]));
            res = Math.min(res, count(B, A[0]));
        }
        if (r1) {
            res = Math.min(res, count(B, B[0]));
            res = Math.min(res, count(A, B[0]));

        }
        if (!r0 && !r1) return -1;
        return res;
    }

    private boolean isCommon(int[] A, int[] B, int val) {
        for (int i = 0; i < A.length; i++) {
            if ((A[i] != val) && (B[i] != val)) {
                return false;
            }
        }
        return true;
    }

    private int count(int[] A, int val) {
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != val) {
                res++;
            }
        }
        return res;
    }
}