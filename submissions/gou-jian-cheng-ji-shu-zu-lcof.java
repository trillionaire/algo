class Solution {
    // 数学： 前缀积*后缀积
    // nums:  1,   2,  3,  4,  5
    // preMul:  1,   1,  2,  6,  24
    // sufMul: 120, 80, 20, 5,  1
    public int[] constructArr(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int[] preMul = new int[a.length];
        int[] sufMul = new int[a.length];
        int[] result = new int[a.length];

        preMul[0] = 1;
        for (int i = 1; i < a.length; i++) {
            preMul[i] = preMul[i - 1] * a[i - 1];
        }
        sufMul[a.length - 1] = 1;
        for (int i = a.length - 2; i >= 0; i--) {
            sufMul[i] = sufMul[i + 1] * a[i + 1];
        }

        for (int i = 0; i < a.length; i++) {
            result[i] = preMul[i] * sufMul[i];
        }
        return result;
    }
}