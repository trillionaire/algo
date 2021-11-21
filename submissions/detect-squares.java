// 哈希表：[x << 10 | y, count]，简化存储
// 数学： 通过对角点，来确认正方形。
class DetectSquares {
    private Map<Integer, Integer> freq;
    public DetectSquares() {
        freq = new HashMap();
    }

    public void add(int[] p) {
        int val = (p[0] << 10) | p[1];
        freq.put(val, freq.getOrDefault(val, 0) + 1);
    }

    public int count(int[] p) {
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int x = entry.getKey() >> 10;
            int y = entry.getKey() & ((1 << 10) - 1);
            if (isValidSquare(p, x, y)) {
                result += freq.get((p[0] << 10) | y) * freq.get((x << 10) | p[1]) * entry.getValue();
            }
        }
        return result;
    }
    // 判断正方形：选对角点，可直接确定正方形四个点。不选选平行点，时因为存在两种正方形的情况（上下或左右）。
    private boolean isValidSquare(int[] p, int x, int y) {
        return x != p[0] && y != p[1] && Math.abs(x - p[0]) == Math.abs(y - p[1])
                && freq.containsKey((p[0] << 10) | y) && freq.containsKey((x << 10) | p[1]);
    }
}
/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */