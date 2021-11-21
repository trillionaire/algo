class Solution {
    // 矩形DFS：染色法替换visited，flag判断是否遇到围墙（true为未遇到）
    private int ans;
    private boolean flag;

    public int largestArea(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int result = 0;
        char[][] chars = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                chars[i][j] = grid[i].charAt(j);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chars[i][j] > '0' && chars[i][j] <= '5') {
                    // 注意：初始化ans，flag
                    ans = 0;
                    flag = true;
                    dfs(chars, i, j, chars[i][j]);
                    // 仅在dfs未遇到围墙时才统计
                    if (flag) {
                        result = Math.max(result, ans);
                    }
                }
            }
        }
        return result;
    }
    // DFS: 深度遍历与val相同的区域
    private void dfs(char[][] chars, int x, int y, char val) {
        int m = chars.length;
        int n = chars[0].length;
        // 退出：遇到围墙，flag置false
        if ((x < 0) || (x >= m) || (y < 0) || (y >= n) || chars[x][y] == '0') {
            flag = false;
            return;
        }
        if (chars[x][y] != val) {
            return;
        }
        chars[x][y] = '6'; // ‘6’代表已遍历
        ans++;
        dfs(chars, x + 1, y, val);
        dfs(chars, x - 1, y, val);
        dfs(chars, x, y + 1, val);
        dfs(chars, x, y - 1, val);
    }
}