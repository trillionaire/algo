class Solution {
    // 数据结构： hash
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        // 不高兴的人
        int[] unhappys = new int[n];
        // 配对hash表
        int[] map = new int[n];
        // 关系重要度表[x, y]：importance。 0为最高
        int[][] relations = new int[n][n];
        // 构建关系表
        for (int i = 0; i < preferences.length; i++) {
            for (int j = 0; j < preferences[i].length; j++) {
                relations[i][preferences[i][j]] = j;
            }
        }
        // 构建配对表
        for (int i = 0; i < pairs.length; i++) {
            map[pairs[i][0]] = pairs[i][1];
            map[pairs[i][1]] = pairs[i][0];
        }

        for (int i = 0; i < pairs.length; i++) {
            int x = pairs[i][0];
            int y = pairs[i][1];
            // 处理x
            for (int j = 0; j < relations[x][y]; j++) {
                int u = preferences[x][j];
                int v = map[u];
                if (relations[u][x] < relations[u][v]) {
                    unhappys[x] = 1;
                    break;
                }
            }
            // 处理y
            for (int j = 0; j < relations[y][x]; j++) {
                int u = preferences[y][j];
                int v = map[u];
                if (relations[u][y] < relations[u][v]) {
                    unhappys[y] = 1;
                    break;
                }
            }
        }
        return Arrays.stream(unhappys).sum();
    }
}