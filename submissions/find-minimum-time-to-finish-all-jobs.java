class Solution {
    // https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/solution/dfsjian-zhi-4ms-by-kobe24o-zhtc/
    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        Arrays.sort(jobs);
        int[] manTime = new int[k];
        // backtrace
        dfs(jobs, k, manTime, 0);
        return res;
    }

    private void dfs(int[] jobs, int k, int[] manTime, int index) {
        if (index > jobs.length - 1) {
            int tmp = 0;
            for (int i = 0; i < k; i++) {
                tmp = Math.max(tmp, manTime[i]);
            }
            res = Math.min(res, tmp);
            return;
        }

        for(int i = 0; i < k; i++) {
            // trim 
            if (manTime[i] + jobs[index] > res) { continue; }
            manTime[i] += jobs[index];
            dfs(jobs, k, manTime, index+1);
            manTime[i] -= jobs[index];
            // trim
            if (manTime[i] == 0) { break; }
        }
    }

}