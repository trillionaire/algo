class Solution {
    // 数据结构：坐标hash(x << 8 | y)
    public static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList();
        Set<Integer> occupied = getOccupied(queens);
        for (int i = 0; i < DIRS.length; i++) {
            for (int len = 0; len < 8; len++) {
                int x = king[0] + DIRS[i][0] * len;
                int y = king[1] + DIRS[i][1] * len;
                if (occupied.contains(x << 8 | y)) {
                    result.add(Arrays.asList(new Integer[]{x, y}));
                    break;
                }
            }
        }
        return result;
    }

    private Set<Integer> getOccupied(int[][] queens) {
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < queens.length; i++) {
            result.add(queens[i][0] << 8 | queens[i][1]);
        }
        return result;
    }
}