class Solution {
    // Greed : forward till blocked, and move to path will be blocked latest.
    public int minSideJumps(int[] obstacles) {
        int res = 0;
        Set<Integer> paths = new HashSet<Integer>();
        paths.add(2);
        for (int i = 0; i < obstacles.length - 1; i++) {
            if (!paths.contains(obstacles[i + 1])) {
                continue;
            }
            // blocked case: remove path
            paths.remove(obstacles[i + 1]);
            // greed: move path till no way 
            if (paths.isEmpty()) {
                paths.add(1);
                paths.add(2);
                paths.add(3);
                paths.remove(obstacles[i]);
                paths.remove(obstacles[i + 1]);
                res++;
            }
        }
        return res;
    }
}