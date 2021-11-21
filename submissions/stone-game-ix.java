class Solution {
    // 贪心： 最终为11212与22121序列。0不在对头即可。
    // https://leetcode-cn.com/problems/stone-game-ix/solution/guan-jian-zai-yu-qiu-chu-hui-he-shu-by-e-mcgv/
    public boolean stoneGameIX(int[] stones) {
        int len = stones.length;
        int[] cnts = new int[3];
        for (int i = 0; i < len; i++) {
            cnts[stones[i] % 3]++;
        }
        // 选11212或221212序列
        return check(cnts[0], cnts[1], cnts[2]) || check(cnts[0], cnts[2], cnts[1]);
    }
    // 1121212000
    private boolean check(int cnt0, int cnt1, int cnt2) {
        if (cnt1 == 0) {
            return false;
        }
        cnt1--;
        int len = Math.min(cnt1, cnt2) * 2 + cnt0 + 1;
        if (cnt1 > cnt2) {
            len++;
            cnt1--;
        }
        return (len % 2 == 1) && (cnt1 != cnt2); // 回合数为奇数，且还有剩余石子
    }
}