class Solution {
    // 数学： 前缀异或积。 [i, k]异或积为0即可。
    public int countTriplets(int[] arr) {
        int[] xors = new int[arr.length];
        xors[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xors[i] = xors[i - 1] ^ arr[i];
        }
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int k = i + 1; k < arr.length; k++) {
                // [i, k]区域前缀异或积
                int tmp = (i == 0) ? xors[k] : (xors[k] ^ xors[i - 1]);
                // [i, k] 范围内所有j都可以
                if (tmp == 0) res += (k - i);
            }
        }
        return res;
    }
}