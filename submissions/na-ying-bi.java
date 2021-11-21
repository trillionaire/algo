class Solution {
    public int minCount(int[] coins) {        
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            res += getCount(coins[i]);
        }
        return res;
    }

    private int getCount(int i) {
        int res = 1;
        while (i > 2) {
            i -= 2;
            res++;
        }
        return res;
    }
}