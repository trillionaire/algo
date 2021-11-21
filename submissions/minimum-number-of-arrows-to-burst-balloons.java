class Solution {
      public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int res = 0;
        boolean[] vis = new boolean[points.length];
        for (int i = 0; i < points.length; i++) {
            if (vis[i]) { continue; }
            for (int j = i + 1; j < points.length; j++) {
                if (points[j][0] <= points[i][1]) {
                    vis[j] = true;
                } else {
                    break;
                }
            }
            res++;
            vis[i] = true;
        }
        return res;
    }
}