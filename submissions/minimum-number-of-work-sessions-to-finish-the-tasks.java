class Solution {
    // DFS: DFS + 记忆化搜索 求解 0-1背包
    // 参考：https://leetcode-cn.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/solution/da-lao-du-zai-xiu-zhuang-ya-cai-ji-yong-xflrt/
    private int ans;

    public int minSessions(int[] tasks, int sessionTime) {
        ans = tasks.length; // 上限
        backtrack(tasks, 0, new int[tasks.length], sessionTime, 0);
        return ans;
    }

    // start:当前待分配tasks的索引；sessions:各session的耗时，长度不超过len，单个不超过sessionTime； cur:当前花费的时间段总数
    public void backtrack(int[] tasks, int start, int[] sessions, int sessionTime, int cur) {
        if(cur >= ans) return; // 剪枝
        if(start == tasks.length) {   // 更新结果 此时cur一定比ans小
            ans = cur;
            return ;
        }
        //是否需要开创时间段
        boolean flag = false;
        for(int i = 0; i < sessions.length; i++) {
            if(sessions[i] + tasks[start] > sessionTime) continue;    // 超时
             // 一次仅开创一个新时段
            if(sessions[i] == 0 && flag) break;
            if(sessions[i] == 0) { flag = true; }
            sessions[i] += tasks[start];
            backtrack(tasks, start + 1, sessions, sessionTime, flag ? cur + 1 : cur);
            sessions[i] -= tasks[start];
        }
    }
}