class Solution {
    //https://leetcode-cn.com/submissions/detail/149605690/
    /*
    counts[g][p]存放 刚好g个人获得p利润的方案数量，最后一列特别，存放的是所有小于等于g人 利润大于等于P的所有方案总和
    实施某次犯罪后的状态转移方程： counts[g][p]=counts[g][p] + counts[g - group][p - profit] （逆序填充）
    */
    public int profitableSchemes(int G, int P, int[] groups, int[] profits) {
        int Mod = 1_000_000_007; //模 10^9 + 7
        int N = groups.length;
        int[][] counts = new int[G + 1][P + 1];//最后一列填充的是累计的总方案数
        for (int g = 0; g <= G; g++) {
            counts[g][0] = 1;//利润为0的方案数初始为1
        }
        for (int n = 0; n < N; n++) {//遍历每一种犯罪
            int group = groups[n], profit = profits[n];
            for (int g = G; g >= group; g--) {//按照成员数从大到小遍历，逆序
                long count = counts[g][P];//备忘录中P列已有的方案数
                for (int p = Math.max(0, P - profit); p <= P; p++) { //统计凑齐P（大于等于)利润的所有方案，进行方案数累加
                    count += counts[g - group][p];//还富裕的成员数量，至少得到P-profit的所有方案总数
                }
                counts[g][P] = (int) (count % Mod);
                for (int p = P - 1; p >= profit; p--) {//逆序
                    //实施某次犯罪后的状态转移方程
                    counts[g][p] = (counts[g][p] + counts[g - group][p - profit]) % Mod;
                }
            }
        }
        return counts[G][P];
    }
}