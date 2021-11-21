class Solution {
    public int[] getTriggerTime(int[][] increase, int[][] requirements) {
        int[][] situ = new int[increase.length + 1][increase[0].length];
        for (int i = 0; i < increase.length; i++) {
            for (int j = 0; j < increase[0].length; j++) {
                situ[i + 1][j] = situ[i][j] + increase[i][j];
            }
        }
        int[] res = new int[requirements.length];
        for (int i = 0; i < requirements.length; i++) {
            res[i] = getIndex(situ, requirements[i]);
        }
        return res;
    }

    private int getIndex(int[][] situ, int[] req) {
        int l = 0;
        int r = situ.length - 1;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (situ[mid][0] < req[0] || situ[mid][1] < req[1] || situ[mid][2] < req[2]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (l == situ.length - 1) {
            return (situ[l][0] >= req[0] && situ[l][1] >=req[1] && situ[l][2] >= req[2]) ? l : -1;
        }
        return l;
    }
}