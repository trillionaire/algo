class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*
        1 2 3 4 5 1 2 3 4 5
        3 4 5 1 2 3 4 5 1 2
        -2 -2 -2  3 3 -2 -2 -2  3 3
        -2 -4 -6 -3 0 -2 -4 -6 -3 0
        */
        int[] val = new int[gas.length * 2];
        int[] preSum = new int[gas.length * 2];

        for (int i = 0; i < val.length; i++) {
            int j = (i < gas.length) ? i : (i - gas.length);
            val[i] = gas[j] - cost[j];
            if (i == 0) {
                preSum[i] = val[0];
            } else {
                preSum[i] = preSum[i - 1] + val[i];
            }
        }

        boolean found = false;
        for (int i = 0; i < gas.length; i++) {
            if (val[i] < 0) {
                continue;
            }
            found = true;
            int pre = (i == 0) ? 0 : preSum[i - 1];
            for (int j = 0; j < gas.length; j++) {
                if ((preSum[i + j] < pre) ||
                        ((j != gas.length - 1) && (preSum[i + j] == pre))) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return i;
            }
        }
        return -1;
    }

    
}