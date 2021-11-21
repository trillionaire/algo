class Solution {
    // 数学：仅方向不变且终点不为起点时不能成环
    // clockwise: U -> R -> D -> L
    public static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean isRobotBounded(String instructions) {
        int x = 0;
        int y = 0;
        int dir = 0;
        char[] chars = instructions.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case 'L': {
                    dir = (dir + 3) % 4;
                    break;
                }
                case 'R': {
                    dir = (dir + 1) % 4;
                    break;
                }
                case 'G': {
                    x += DIRS[dir][0];
                    y += DIRS[dir][1];
                    break;
                }
            }
        }
        return (dir != 0) || ((x == 0 && y == 0));
    }
}