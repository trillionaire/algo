class Solution {
    // 双指针：贪心
    // https://leetcode-cn.com/problems/interval-list-intersections/solution/jiu-pa-ni-bu-dong-shuang-zhi-zhen-by-hyj8/ 
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < A.length && j < B.length) {
            // handle current
            int start = Math.max(B[j][0],A[i][0]);
            int end = Math.min(B[j][1],A[i][1]);
            // found valid region
            if (start <= end) {
                res.add(new int[] {start, end});
            }
            // remove small end
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[0][]);
    }
}