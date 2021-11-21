class Solution {
    public double[] cutSquares(int[] square1, int[] square2) {
        double[] mid1 = {square1[0] + square1[2] / 2.0, square1[1] + square1[2] / 2.0};
        double[] mid2 = {square2[0] + square2[2] / 2.0, square2[1] + square2[2] / 2.0};
        double[] begin1 = {square1[0], square1[1]};
        double[] begin2 = {square2[0], square2[1]};
        double[] end1 = {square1[0] + square1[2], square1[1] + square1[2]};
        double[] end2 = {square2[0] + square2[2], square2[1] + square2[2]};
        // 90 degree
        if (Math.abs(mid2[0] - mid1[0]) < 0.00001) {
            return new double[]{mid1[0], Math.min(begin1[1], begin2[1]), mid1[0], Math.max(end1[1], end2[1])};
        }
        // 0 degree
        if (Math.abs(mid2[1] - mid1[1]) < 0.00001) {
            return new double[]{Math.min(begin1[0], begin2[0]), mid1[1], Math.max(end1[0], end2[0]), mid1[1]};
        }
        double a = (mid2[1] - mid1[1]) / (mid2[0] - mid1[0]);
        double b = mid1[1] - a * mid1[0];
        double[] res = new double[4];
        boolean isLeft = Math.abs(a) < 1.00001;
        if (isLeft) {
            res[0] = Math.min(begin1[0], begin2[0]);
            res[1] = a * res[0] + b;
            res[2] = Math.max(end1[0], end2[0]);
            res[3] = a * res[2] + b;
        } else {
            res[1] = Math.min(begin1[1], begin2[1]);
            res[3] = Math.max(end1[1], end2[1]);
            res[0] = (res[1] - b) / a;
            res[2] = (res[3] - b) / a;
            if (res[0] > res[2]) {
                double tmp = res[0];
                res[0] = res[2];
                res[2] = tmp;
                tmp = res[1];
                res[1] = res[3];
                res[3] = tmp;
            }
        }
        return res;
    }
}