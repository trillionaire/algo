class Solution {
    // 二分 + 滑窗 + 贪心： 
    // 二分检查是否一天val题是否可行
    public int minTime(int[] time, int m) {
        int l = 0;
        int r = Arrays.stream(time).sum();
        int mid = 0;
        while (l <= r) {
            mid = (l + r) / 2;
            // 相反条件：mid太小，取右区间
            if (!isTimeOkay(time, m, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
    
    // 滑窗 + 贪心：检查一天val题是否可在m天完成。每天的题用贪心，只要不超过val。
    private boolean isTimeOkay(int[] time, int m, int val) {
        boolean res = false;
        int group = 0;
        int sum = 0;
        int max = 0;
        int l = 0;
        int r = 0;
        while (r < time.length) {
            sum += time[r];
            max = Math.max(max, time[r]);
            // 去除当前区域max值后一天仍超过val题：新增一天，刷新left
            if (sum - max > val) {
                if (++group >= m) {
                    return false;
                }
                sum = time[r];
                max = time[r];
                l = r;
            }
            r++;
        }
        return true;
    }
}