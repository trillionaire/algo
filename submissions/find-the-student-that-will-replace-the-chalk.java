class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        long sum = 0;
        for (int j = 0; j < chalk.length; j++) {
            sum += chalk[j];
        }
        k = (int) (k % sum);
        while (k > 0) {
            if (k < chalk[i]) {
                return i;
            }
            k -= chalk[i];
            i = (i + 1) % chalk.length;
        }
        return i;
    }
}