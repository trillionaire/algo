class Solution {
    // 二分 + 前缀和。 为box找适合的包裹
    public int minWastedSpace(int[] packages, int[][] boxes) {
        Arrays.sort(packages);
        for (int i = 0; i < boxes.length; i++) {
            Arrays.sort(boxes[i]);
        }
        long[] presums = getPresums(packages);
        long res = Long.MAX_VALUE;
        for (int j = 0; j < boxes.length; j++) {
            long cur = findBox(packages, presums, boxes[j]);
            if (cur == -1) {
                continue;
            }
            res = Math.min(res, cur);
        }
        return res == Long.MAX_VALUE ? -1 : (int)(res % 1000000007);
    }

    private long findBox(int[] packages, long[] presums, int[] boxes) {
        // box too small
        if (boxes[boxes.length - 1] < packages[packages.length - 1]) {
            return -1;
        }
        // box too big
        long res = presums[packages.length - 1] * -1;
        if (boxes[0] >= packages[packages.length - 1]) {
            res += ((long)boxes[0] * packages.length);
            return res;
        }
        // split
        int pos = 0;
        for (int i = 0; i < boxes.length; i++) {
            int right = findIndex(boxes[i], packages, pos);
            res += (long)(right - pos + 1) * boxes[i]; // 注意long
            pos = right + 1;
        }
        return res;
    }

    private int findIndex(int box, int[] packages, int left) {
        if (box >= packages[packages.length - 1]) {
            return packages.length - 1;
        }
        int right = packages.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (packages[mid] <= box) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private long[] getPresums(int[] packages) {
        long[] presums = new long[packages.length];
        for (int i = 0; i < packages.length; i++) {
            presums[i] = (i == 0) ? packages[i] : (presums[i - 1] + packages[i]);
        }
        return presums;
    }
}