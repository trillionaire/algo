class Solution {
    // Set：坐标hash优化(x << 30 | y)，可继续用每次[dx,dy]优化。
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        Set<Long> blocked = getBlocked(obstacles);
        long curX = 0L;
        long curY = 0L;
        char[] chars = command.toCharArray();
        if (blocked.contains((x << 30) | y)) {
            return false;
        }
        while (true) {
            for (int i = 0; i < chars.length; i++) {
                curX = (chars[i] == 'U') ? curX : (curX + 1);
                curY = (chars[i] == 'U') ? (curY + 1) : curY;
                if (invalid(x, y, blocked, curX, curY)) {
                    return false;
                }
                if (curX == x && curY == y) {
                    return true;
                }
            }
        }
    }

    private boolean invalid(int x, int y, Set<Long> blocked, long curX, long curY) {
        if (curX > x || curY > y) {
            return true;
        }
        if (blocked.contains((curX << 30) | curY)) {
            return true;
        }
        return false;
    }

    private Set<Long> getBlocked(int[][] obstacles) {
        Set<Long> result = new HashSet();
        for (int i = 0; i < obstacles.length; i++) {
            result.add(((long) obstacles[i][0] << 30) | obstacles[i][1]);
        }
        return result;
    }
}