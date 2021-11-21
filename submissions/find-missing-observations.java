class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = (n + rolls.length) * mean - Arrays.stream(rolls).sum();
        int[] result = new int[n];
        if (sum < n || sum > 6 * n) {
            return new int[0];
        }

        int avg = sum / n;
        int[] cnts = new int[7];
        cnts[avg] = n;
        int delta = sum - n * avg;
        cnts[avg] -= delta;
        if (delta != 0) {
            cnts[avg + 1] = delta;
        }
        for (int i = 0; i < n; i++) {
            if (i < cnts[avg]) {
                result[i] = avg;
            } else {
                result[i] = avg + 1;
            }
        }
        return result;
    }
}