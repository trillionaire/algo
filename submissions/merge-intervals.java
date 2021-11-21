class Solution {
    // 贪心： 区间合并 + 贪心
    public int[][] merge(int[][] intervals) {
        // https://leetcode-cn.com/problems/merge-intervals/solution/56-he-bing-qu-jian-bu-zhi-bu-jue-jiu-yong-tan-xin-/
        List<int[]> res = new ArrayList();
        // 左边界排序
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        // 贪心
        for (int i = 0; i < intervals.length; i++) {
            // 当前区间晚于最后的区间时，新增区间
            if (res.isEmpty() || res.get(res.size() - 1)[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else { // 合并区间
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
            }
        }
        int[][] result = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

}